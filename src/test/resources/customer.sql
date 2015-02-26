/*customer*/
BEGIN
	/*create address type mapping table*/
	DECLARE @LKUP_address_type_xref TABLE (
		IMS_addresstypecode varchar(255),
		AXIS_address_type_code varchar(3)
	)

	/*insert address type mapping*/
	INSERT INTO @LKUP_address_type_xref VALUES ('OLI_ADTYPE_POLMAIL','MAL')
	INSERT INTO @LKUP_address_type_xref VALUES ('OLI_ADTYPE_BUS','PHY')

	/*create a table variable to help retrieve unique customer addresses*/
	DECLARE @unique_customer_address TABLE (
		CUSTOMERNUMBER varchar(255),
		ADDRESSKEY varchar(255),
		addresstypecode varchar(255),
		CREATEDATE datetime
	)

	/*retrieve unique customer addresses*/
	INSERT INTO
		@unique_customer_address
		(
		CUSTOMERNUMBER,
		addresstypecode,
		ADDRESSKEY,
		CREATEDATE
		)
	SELECT
		masterPolExtn.CUSTOMERNUMBER,
		address.addresstypecode,
		MAX(address.ADDRESSKEY), /*if somehow more than one created address key exists as of the same exact time*/
		MAX(address.CREATEDATE)
	FROM
		lf$app_policy policy
	LEFT JOIN
		mi$app_master_policy_extn masterPolExtn
	ON
		policy.canonicalid = masterPolExtn.parentcanonicalid
	AND
		masterPolExtn.versiontype = 'Current' /*must be the current record*/
	LEFT JOIN
		lf$app_relation relation
	ON
		relation.originatingobjecttype = 'OLI_HOLDING'
	AND
		relation.relatedobjecttype = 'OLI_PARTY'
	AND
		relation.enabledflag = 'Y' /*must be the current record*/
	AND
		relation.relationrolecode = 'OLI_REL_INSURED'
	AND
		policy.parentcanonicalid = relation.originatingobjectid
	LEFT JOIN
		lf$app_party party
	ON
		party.partykey = relation.relatedobjectid
	AND
		party.ENABLEDFLAG = 'Y' /*must be the current record*/
	LEFT JOIN
		lf$app_address address
	ON
		party.canonicalid = address.parentcanonicalid
	AND
		address.enabledflag = 'Y' /*must be the current record*/
	INNER JOIN
		@LKUP_address_type_xref address_type
	ON
		address_type.IMS_addresstypecode = address.addresstypecode
	WHERE
		policy.issuetype IS NOT NULL
	AND
		masterPolExtn.BRANCHNUMBER = '0001' /*In IMS the first branch is the customer parent branch*/
	GROUP BY
		masterPolExtn.CUSTOMERNUMBER,
		address.addresstypecode

	/*create table to hold customer addresses*/
	CREATE TABLE #customer_address (
		customer_number VARCHAR(5),
		address_line1 VARCHAR(100),
		address_line2 VARCHAR(100),
		city VARCHAR(100),
		state_code VARCHAR(3),
		zip_code VARCHAR(9),
		address_type_code VARCHAR(3)
	)

	/*retreive customer addresses*/
	INSERT INTO
		#customer_address
		(
		customer_number,
		address_line1,
		address_line2,
		city,
		state_code,
		zip_code,
		address_type_code
		)
	SELECT
		customer_number				=	LEFT(masterPolExtn.CUSTOMERNUMBER,5),
		address_line1				=	LEFT(ISNULL(address.line1,''),100),
		address_line2				=	LEFT(address.line2,100),
		city						=	LEFT(ISNULL(address.city,''),100),
		state_code					=	CASE RTRIM(address.addressstate) WHEN '' THEN 'CA' ELSE LEFT(address.addressstate,3) END,
		zip_code					=	LEFT(ISNULL(address.zip,''),9),
		address_type_code			=	address_type.AXIS_address_type_code
	FROM
		lf$app_policy policy
	LEFT JOIN
		mi$app_master_policy_extn masterPolExtn
	ON
		policy.canonicalid = masterPolExtn.parentcanonicalid
	AND
		masterPolExtn.versiontype = 'Current' /*must be the current record*/
	LEFT JOIN
		lf$app_relation relation
	ON
		relation.originatingobjecttype = 'OLI_HOLDING'
	AND
		relation.relatedobjecttype = 'OLI_PARTY'
	AND
		relation.enabledflag = 'Y' /*must be the current record*/
	AND
		relation.relationrolecode = 'OLI_REL_INSURED'
	AND
		policy.parentcanonicalid = relation.originatingobjectid
	LEFT JOIN
		lf$app_party party
	ON
		party.partykey = relation.relatedobjectid
	AND
		party.ENABLEDFLAG = 'Y' /*must be the current record*/
	LEFT JOIN
		lf$app_address address
	ON
		party.canonicalid = address.parentcanonicalid
	AND
		address.enabledflag = 'Y' /*must be the current record*/
	INNER JOIN
		@LKUP_address_type_xref address_type
	ON
		address_type.IMS_addresstypecode = address.addresstypecode
	WHERE
		policy.issuetype IS NOT NULL
	AND
		masterPolExtn.BRANCHNUMBER = '0001' /*In IMS the first branch is the customer parent branch*/
	AND
		EXISTS
			(
			SELECT
				*
			FROM
				@unique_customer_address uca
			WHERE
				uca.ADDRESSKEY = address.ADDRESSKEY
			AND
				uca.addresstypecode = address.addresstypecode
			)
	AND
		address.addressstate IS NOT NULL
	AND
		address.addresstypecode	IS NOT NULL

	/*create a table variable to retrieve customer master policy type and delegated approval*/
	DECLARE @customermptda TABLE (
		customer_number varchar(5),
		branch_number varchar(4),
		is_lender int,
		is_servicer int,
		is_delegated_approved int,
		create_date DATETIME
	)
	
	
	/*create a temp table for unique relations*/
	CREATE TABLE #uniquerelation(
		originatingobjectid varchar(255),
		relatedobjectid varchar(255),
		createdate datetime
		)
		
	/*create a temp table for policy applications*/
	CREATE TABLE #uniquepolicyapplication	(
		PARENTCANONICALID VARCHAR(255),
		POLICYAPPLICATIONINFOKEY VARCHAR(255),
		CREATEDATE DATETIME
	)
		
	/*create a table variable to retrieve customer information*/
	DECLARE @customer TABLE (
		customer_number varchar(5),
		customer_name varchar(250),
		effective_date datetime,
		phone varchar(12),
		fax varchar(12),
		email varchar(100),
		freddie_mac_seller_servicer_number varchar(100),
		fannie_mae_seller_servicer_number varchar(100),
		fdic_number varchar(100),
		ncua_number varchar(100),
		delegated_effective_date datetime,
		business_channel varchar(255),
		party_parentcanonical varchar(255)
		
	)

	/*insert unique unique relations*/
	INSERT INTO
		#uniquerelation
		(
		originatingobjectid,
		relatedobjectid,
		createdate
		)
	SELECT
		originatingobjectid,
		MAX(relatedobjectid) AS relatedobjectid,
		createdate
	FROM
		lf$app_relation relation
	WHERE 
		relation.originatingobjecttype = 'OLI_HOLDING' 
	AND 
		relation.relatedobjecttype = 'OLI_PARTY' 
	AND 
		relation.enabledflag = 'Y' /*must be the current record*/
	AND 
		relation.relationrolecode = 'OLI_REL_INSURED' 
	AND
		enddate IS NULL /*relationship must be active*/
	AND
		EXISTS
			(
			SELECT
				*
			FROM
				(
				SELECT
					originatingobjectid,
					MAX(ISNULL(createdate,'01/01/1900')) AS createdate
				FROM
					lf$app_relation relation
				WHERE 
					relation.originatingobjecttype = 'OLI_HOLDING' 
				AND 
					relation.relatedobjecttype = 'OLI_PARTY' 
				AND 
					relation.enabledflag = 'Y' /*must be the current record*/
				AND 
					relation.relationrolecode = 'OLI_REL_INSURED' 
				AND
					enddate IS NULL /*relationship must be active*/
				GROUP BY
					originatingobjectid
				) as i
			WHERE
				i.originatingobjectid = relation.originatingobjectid
			AND
				i.createdate = ISNULL(relation.createdate,'01/01/1900')
			)
	GROUP BY
		originatingobjectid,
		createdate
		
	/*get unique policy applications*/
	INSERT INTO
		#uniquepolicyapplication
		(
		PARENTCANONICALID,
		POLICYAPPLICATIONINFOKEY,
		CREATEDATE
		)
	SELECT
		PARENTCANONICALID,
		MAX(POLICYAPPLICATIONINFOKEY) AS POLICYAPPLICATIONINFOKEY,	
		CREATEDATE
	FROM
		mi$app_policyapplicationinfo
	WHERE
		ENABLEDFLAG = 'Y' /*must be the current record*/
	AND
		EXISTS
			(
			SELECT
				*
			FROM
				(
				SELECT
					PARENTCANONICALID,
					MAX(ISNULL(CREATEDATE,'01/01/1900')) AS CREATEDATE	
				FROM
					mi$app_policyapplicationinfo
				WHERE
					ENABLEDFLAG = 'Y' /*must be the current record*/
				GROUP BY
					PARENTCANONICALID
				) AS i
			WHERE
				i.PARENTCANONICALID = mi$app_policyapplicationinfo.PARENTCANONICALID
			AND
				i.CREATEDATE = ISNULL(mi$app_policyapplicationinfo.CREATEDATE,'01/01/1900')
		)
	GROUP BY
		PARENTCANONICALID,
		CREATEDATE
		
	/*retrieve customer master policy type and delegated approval for all branches from IMS; this is data will be used to derive customer level preferences*/
	INSERT INTO
		@customermptda
		(
		customer_number,
		branch_number,
		is_lender,
		is_servicer,
		is_delegated_approved,
		create_date
		)
	SELECT
		customer_number				=	LEFT(masterPolExtn.CUSTOMERNUMBER,5),
		branch_number				=	LEFT(masterPolExtn.BRANCHNUMBER,4),
		is_lender					=	CASE
											WHEN policy.issuetype = 'Servicer' THEN
												0              
											ELSE
												1
										END,		
		is_servicer					=	CASE
											WHEN policy.issuetype = 'Lender' THEN
												0              
											ELSE
												1
										END,
		is_delegated_approved		=	CASE
											WHEN masterPolExtn.delegationrequired = 'OLI_BOOL_FALSE' THEN
												0
											ELSE
												1
										END,
		create_date					=	ISNULL(policy.CREATEDATE,'01/01/1900')
	FROM   
		lf$app_policy policy 
	LEFT JOIN 
		mi$app_master_policy_extn masterPolExtn 
	ON 
		policy.canonicalid = masterPolExtn.parentcanonicalid 
	AND 
		masterPolExtn.versiontype = 'Current' /*must be the current record*/
	LEFT JOIN 
		#uniquerelation relation 
	ON 
		policy.parentcanonicalid = relation.originatingobjectid 
	LEFT JOIN 
		lf$app_party party
	ON 
		party.partykey = relation.relatedobjectid 
	AND
		party.ENABLEDFLAG = 'Y' /*must be the current record*/
	WHERE 
		policy.issuetype IS NOT NULL
	
	/*retrieve customer information from IMS*/
	INSERT INTO
		@customer
		(
		customer_number,
		customer_name,
		effective_date,
		phone,
		fax,
		email,
		delegated_effective_date,
		business_channel,
		party_parentcanonical
		)
	SELECT
		customer_number				=	LEFT(masterPolExtn.CUSTOMERNUMBER,5),
		customer_name				=	CASE 
											WHEN LEFT(org.abbrname,250)= 'NULL' THEN
												''
											ELSE LEFT(org.abbrname,250)
										END,
		effective_date				=	policy.effdate,
		phone						=	'NULL',
		fax							=	MAX(LEFT(ISNULL(fax.areacode,'') + ISNULL(fax.DIALNUMBER,''),12)),
		email						=	MAX(LEFT(email.addrline,100)), /*if multiple emial addresses exist, select the largest*/
		delegated_effective_date	=	CASE
											WHEN masterPolExtn.DELEGATIONREQUIRED = 'OLI_BOOL_TRUE' THEN /*only use the delegated effective date if the master policy is currently delegated*/
												ISNULL(mpe.mindate,GETDATE()) /*if not known then use today's date.*/
											/*else null*/
										END,
		business_channel			=   macappinfo.BUSINESSCHANNEL,
		party_parentcanonical		=   party.PARENTCANONICALID 
	FROM
		lf$app_policy policy 
	LEFT JOIN 
		mi$app_master_policy_extn masterPolExtn 
	ON 
		policy.canonicalid = masterPolExtn.parentcanonicalid 
	AND 
		masterPolExtn.versiontype = 'Current' /*must be the current record*/
	LEFT JOIN 
		mi$app_policyapplicationinfo macappinfo
	ON 
		policy.canonicalid = macappinfo.parentcanonicalid
	AND
		macappinfo.ENABLEDFLAG = 'Y' /*must be the current record*/
	LEFT JOIN 
		lf$app_relation relation 
	ON 
		relation.originatingobjecttype = 'OLI_HOLDING' 
	AND 
		relation.relatedobjecttype = 'OLI_PARTY' 
	AND 
		relation.enabledflag = 'Y' /*must be the current record*/
	AND 
		relation.relationrolecode = 'OLI_REL_INSURED' 
	AND 
		policy.parentcanonicalid = relation.originatingobjectid 
	LEFT JOIN 
		lf$app_party party
	ON 
		party.partykey = relation.relatedobjectid
	AND
		party.ENABLEDFLAG = 'Y' /*must be the current record*/
	LEFT JOIN 
		lf$app_organization org 
	ON 
		party.canonicalid = org.parentcanonicalid
	AND
		org.ENABLEDFLAG = 'Y' /*must be the current record*/
	LEFT JOIN 
		(
		SELECT 
			PARENTCANONICALID,
			AREACODE,
			DIALNUMBER
		FROM
			lf$app_phone
		WHERE
			PHONETYPECODE = 'OLI_PHONETYPE_BUSFAX' /*get only fax numbers*/
		AND
			ENABLEDFLAG = 'Y'/*must be the current record*/
		AND
			DIALNUMBER IS NOT NULL
		AND
			DIALNUMBER != ''
		) fax 
	ON 
		party.canonicalid = fax.parentcanonicalid
	LEFT JOIN
		(
		SELECT
			mpe.PARENTCANONICALID,
			mpe.CUSTOMERNUMBER,
			mpe.BRANCHNUMBER, 
			mpe.APPROVALDATE,
			minapproval.mindate
		FROM 
			dbo.MI$APP_MASTER_POLICY_EXTN  mpe
		INNER JOIN
			(
			SELECT 
				MIN(APPROVALDATE) AS mindate,
				CUSTOMERNUMBER
			FROM 
				dbo.MI$APP_MASTER_POLICY_EXTN 
			GROUP BY 
				CUSTOMERNUMBER
			) minapproval
		ON
			mpe.CUSTOMERNUMBER = minapproval.CUSTOMERNUMBER
		AND 
			mpe.versiontype = 'Current' /*must be the current record*/
		)mpe  
	ON
		mpe.parentcanonicalid = policy.canonicalid
	LEFT JOIN 
		lf$app_emailaddress email
	ON 
		party.partykey = email.parentcanonicalid 
	AND
		email.ENABLEDFLAG = 'Y' /*must be the current record*/
	WHERE 
		policy.issuetype IS NOT NULL
	AND
		masterPolExtn.BRANCHNUMBER = '0001' 
	AND
		masterPolExtn.CUSTOMERNUMBER != 'null'
	AND
		LEN(masterPolExtn.CUSTOMERNUMBER)= 5
		/*In IMS the first branch is the customer parent branch*/
	AND
		EXISTS /*more than one enabled policy application. pick the newest*/
			(
			SELECT
				*
			FROM
				#uniquepolicyapplication
			WHERE
				#uniquepolicyapplication.PARENTCANONICALID = macappinfo.parentcanonicalid
			AND
				#uniquepolicyapplication.POLICYAPPLICATIONINFOKEY = macappinfo.POLICYAPPLICATIONINFOKEY
			AND 
				#uniquepolicyapplication.CREATEDATE = macappinfo.CREATEDATE
			)	
	GROUP BY
		LEFT(masterPolExtn.CUSTOMERNUMBER,5),
		LEFT(org.abbrname,250),
		policy.effdate,
		CASE
			WHEN masterPolExtn.DELEGATIONREQUIRED = 'OLI_BOOL_TRUE' THEN /*only use the delegated effective date if the master policy is currently delegated*/
				ISNULL(mpe.mindate,GETDATE()) /*if not known then use today's date.*/
			/*else null*/
		END,
		macappinfo.businesschannel,
		party.PARENTCANONICALID

	/*get axis customer table fields*/
	SELECT DISTINCT
		customer_number						=	c.customer_number,
		customer_name						=	ISNULL(c.customer_name, ''),
		master_policy_type_code				=	CASE
													WHEN cmpt.is_lender = 1 and cmpt.is_servicer = 1 THEN /*if both a lender and servicer; originator and servicer*/
														'ONS'
													WHEN cmpt.is_lender = 1 and cmpt.is_servicer = 0 THEN /*if a lender only; originator*/
														'ORG'
													ELSE /*if a servicer only; servicer*/
														'SVC'
												END,
		effective_date						=	c.effective_date,
		phone								=	c.phone,
		fax									=	REPLACE((
													CASE
														WHEN c.fax = '' THEN 
															NULL 
														ELSE 
															c.fax 
													END
													),'-',''),
		email								=	CASE 
												WHEN c.email = ' ' THEN 
													null 
												ELSE 
													c.email 
											END,
		is_delegated_approved				=	ISNULL(cda.is_delegated_approved,0), /*if the customer does not contain an explicit delegated approval, default to non-delegated*/
		freddie_mac_seller_servicer_number	=	c.freddie_mac_seller_servicer_number,
		fannie_mae_seller_servicer_number	=	c.fannie_mae_seller_servicer_number,
		fdic_number							=	c.fdic_number,
		ncua_number							=	c.ncua_number,
		is_qa_review_required				=	0,
		tier								=	'Bronze',
		is_bulk_transaction_allowed			=	0,
		delegated_effective_date			=	 CASE
													WHEN cda.is_delegated_approved = 1 THEN
														c.delegated_effective_date
													ELSE
														NULL
												END,
		qa_review_effective_from			=	NULL,
		qa_review_effective_to				=	NULL,
		is_correspondent					=	CASE 
													WHEN CHARINDEX('Correspondent',c.business_channel) != 0 THEN /*if more than one defined, use correspondent first*/
														1 
													ELSE /*must be wholesale*/
														0 
													END,								
		is_b2b_origination_allowed			=	0,
		investor_other						=	NULL,
		b2b_los_system						=	NULL,
		is_b2b_accept_loan_closed_date_allowed = 0,
		is_b2b_unsolicited_response_supported  = 0,
		b2b_unsolicited_response_format		=	NULL,
		is_mailing_address_different		=	CASE
													WHEN is_mailing_address_same.customer_number IS NULL THEN /*a matching mailing address could not be found*/
														1 /*the mailing address is different*/
													ELSE
														0 /*the mailing address is the same*/
												END,
		phone_extension						=	CASE 
													WHEN c.phone IS NULL THEN 
														Null 
													ELSE 
														SUBSTRING(replace((LEFT(ISNULL(c.phone,'') + ISNULL(c.phone,''),12)),'-',''),11,15) 
												END,
		is_active							= 1,
		is_terminated						= 0,
		last_generated_branch_number		= '0001',
		is_migrated							= 1
	INTO 
		#customer
	FROM
		@customer c
	LEFT OUTER JOIN
		(
		SELECT
			customer_number,
			MAX(create_date) AS max_create_date 
		FROM
			@customermptda
		GROUP BY
			customer_number
		) cmpcd
	ON
		cmpcd.customer_number = c.customer_number
	LEFT OUTER JOIN
		(
		SELECT /*if one branch is delegated, the customer is delegated*/
			customer_number,
			MAX(is_delegated_approved) AS is_delegated_approved
		FROM
			@customermptda cmptda
		GROUP BY
			customer_number
		) AS cda
	ON
		cda.customer_number = c.customer_number
	LEFT OUTER JOIN
		(
		SELECT /*get lender and servicer type by customer number; if any branch is a lender, the customer is a lender; if any branch is a servicer, the customer is a servicer*/
			customer_number,
			MAX(is_lender) AS is_lender,
			MAX(is_servicer) AS is_servicer
		FROM
			@customermptda cmptda
		GROUP BY
			customer_number
		) AS cmpt
	ON
		cmpt.customer_number = c.customer_number
	LEFT OUTER JOIN
		(
		SELECT
			customer_number
		FROM
			#customer_address phy_address
		WHERE
			phy_address.address_type_code = 'PHY'
		AND
			EXISTS
				(
				SELECT
					*
				FROM
					#customer_address mal_address
				WHERE
					mal_address.customer_number = phy_address.customer_number
				AND
					mal_address.address_line1 = phy_address.address_line1
				AND
					ISNULL(mal_address.address_line2,'') = ISNULL(phy_address.address_line2,'')
				AND
					mal_address.city = phy_address.city
				AND
					mal_address.state_code = phy_address.state_code
				AND
					mal_address.zip_code = phy_address.zip_code
				AND
					mal_address.address_type_code = 'MAL'
				)
		) is_mailing_address_same
	ON
		is_mailing_address_same.customer_number = c.customer_number
	WHERE
		EXISTS
			(
			SELECT
				*
			FROM
				(
				SELECT
					customer_number,
					create_date,
					row_no = ROW_NUMBER () over (partition by customer_number order by create_date DESC)
				FROM
					@customermptda
				) cmptdau
			WHERE
				cmptdau.customer_number = cmpcd.customer_number
			AND
				cmptdau.create_date = cmpcd.max_create_date
			)
	

	/*get customers*/
	SELECT
		customer_number,
		customer_name,
		master_policy_type_code,
		effective_date,
		phone,
		fax,
		email,
		is_delegated_approved, /*if the customer does not contain an explicit delegated approval, default to non-delegated*/
		freddie_mac_seller_servicer_number,
		fannie_mae_seller_servicer_number,
		fdic_number,
		ncua_number,
		is_qa_review_required,
		tier,
		is_bulk_transaction_allowed,
		delegated_effective_date,
		qa_review_effective_from,
		qa_review_effective_to,
		is_correspondent,
		is_b2b_origination_allowed,
		investor_other,
		b2b_los_system,
		is_b2b_accept_loan_closed_date_allowed,
		is_b2b_unsolicited_response_supported,
		b2b_unsolicited_response_format,
		is_mailing_address_different,
		phone_extension,
		is_active,
		is_terminated,
		last_generated_branch_number,
		is_migrated
	FROM
		#customer
	-- WHERE
	--	customer_number IN ('<<customerNumberList>>')
	
	/*clean-up*/	
	DROP TABLE #uniquerelation
	DROP TABLE #uniquepolicyapplication
	DROP TABLE #customer
	DROP TABLE #customer_address
END
