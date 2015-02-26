/*	application	*/
BEGIN
	/*create submission type mapping table*/
	DECLARE @LKUP_submission_type_xref TABLE (
		IMS_applicationtype varchar(255),
		AXIS_submission_type_code varchar(3)
	)
	
	/*insert submission type mapping*/
	INSERT INTO @LKUP_submission_type_xref VALUES ('Delegated','DEL')
	INSERT INTO @LKUP_submission_type_xref VALUES ('StandardApplication','NDL')

	/*create insurance paid type mapping table*/
	DECLARE @LKUP_insurance_paid_type_xref TABLE (
		IMS_premiumpaymenttype varchar(255),
		AXIS_insurance_paid_type_code varchar(3)
	)
	
	/*insert insurance paid type mapping*/
	INSERT INTO @LKUP_insurance_paid_type_xref VALUES ('BorrowerPaid','BPI')
	INSERT INTO @LKUP_insurance_paid_type_xref VALUES ('BothBorrowerAndLenderPaid','BPI')
	INSERT INTO @LKUP_insurance_paid_type_xref VALUES ('LenderPaid','LPI')

	/*create premium plan type mapping table*/
	DECLARE @LKUP_premium_plan_type_xref TABLE (
		IMS_premiumplantype varchar(255),
		IMS_midurationtype varchar(255),
		AXIS_premium_plan_type_code varchar(3)
	)
	
	/*insert premium plan type mapping*/
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ZeroOptionMonthly','PeriodicMonthly','MTA')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ZeroOptionMonthly','NotApplicable','MTA')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ZeroOptionMonthly','','MTA')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Monthly','PeriodicMonthly','MTH')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Monthly','NotApplicable','MTH')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Monthly','','MTH')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('LevelAnnual','Annual','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('LevelAnnual','NotApplicable','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('LevelAnnual','','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardAnnual','Annual','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardAnnual','NotApplicable','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardAnnual','','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('OneTime','SingleSpecific','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('OneTime','SingleLifeOfLoan','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('OneTime','PeriodicMonthly','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('OneTime','NotApplicable','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('OneTime','','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardFrontLoaded','PeriodicMonthly','MTH')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardFrontLoaded','SingleSpecific','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardFrontLoaded','SingleLifeOfLoan','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('StandardFrontLoaded','Annual','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('BackLoaded','PeriodicMonthly','MTA')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('BackLoaded','SingleSpecific','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('BackLoaded','SingleLifeOfLoan','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('BackLoaded','Annual','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ModifiedFrontLoaded','PeriodicMonthly','MTH')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ModifiedFrontLoaded','SingleSpecific','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ModifiedFrontLoaded','SingleLifeOfLoan','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('ModifiedFrontLoaded','Annual','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Level','PeriodicMonthly','MTH')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Level','SingleSpecific','ANN')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Level','SingleLifeOfLoan','SGL')
	INSERT INTO @LKUP_premium_plan_type_xref VALUES ('Level','Annual','SGL')

	
	/*create refund type mapping table*/
	DECLARE @LKUP_refund_type_xref TABLE (
		IMS_premiumrefundabletype varchar(255),
		AXIS_refund_type_code varchar(3)
	)
	
	/*insert refund type mapping*/
	INSERT INTO @LKUP_refund_type_xref VALUES ('Refundable','REF')
	INSERT INTO @LKUP_refund_type_xref VALUES ('RefundableWithLimits','REF')
	INSERT INTO @LKUP_refund_type_xref VALUES ('NotRefundable','NOR')

	/*create renewal type mapping table*/
	DECLARE @LKUP_renewal_type_xref TABLE (
		IMS_rencalctype varchar(255),
		AXIS_renewal_type_code varchar(3)
	)
	
	/*insert renewal type mapping*/
	INSERT INTO @LKUP_renewal_type_xref VALUES ('Declining','AMO')
	INSERT INTO @LKUP_renewal_type_xref VALUES ('Constant','CON')
	INSERT INTO @LKUP_renewal_type_xref VALUES ('NoRenewals','NOR')
	INSERT INTO @LKUP_renewal_type_xref VALUES ('NotApplicable','NOR')
	
	/*create certificate state type mapping table*/
	DECLARE @LKUP_certificate_state_type_xref TABLE (
		IMS_POLICYSTATUS varchar(255),
		AXIS_certificate_state_type_code varchar(3)
	)

	/*insert certificate state type mapping*/
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_ADDITIONAL_PREMIUM_DUE','')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_APP_REJECTED','APL')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_CANCELLED','') /*if loan closing date exists then certificate else commitment*/
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_COMMIT_CONDITIONS','COM')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_COMMITMENT','COM')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_EXPIRED','') /*if loan closing date exists then certificate else commitment*/
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_HOLD_FOR_CONDITIONS','APL')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_INCOMPLETE','PRA')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_INFORCE','CER')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_INPROGRESS','APL')
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_REINSTMT_INPROGRESS','') /*if loan closing date exists then certificate else commitment*/
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_REINSTMT_RESUBMISSION','') /*if loan closing date exists then certificate else commitment*/
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_REINSTMT_RQRMTS_PENDING','') /*if loan closing date exists then certificate else commitment*/
	INSERT INTO @LKUP_certificate_state_type_xref VALUES ('OLI_POLSTAT_TERMINATE','') /*if loan closing date exists then certificate else commitment*/


	/*get application data*/
	SELECT
		BK_certificate_number				=	LEFT(applicationInfo.trackingid,10),
		certificate_number					=	LEFT(applicationInfo.trackingid,10),
		submitted_date						=	submission_date.submission_date,
		submitted_by						=	CASE
													WHEN create_origination_user_by_application.origination_user_id IS NOT NULL THEN /*use the oldest application created by id if it is an origination user account*/
														create_origination_user_by_application.origination_user_id
													WHEN create_origination_user_by_current_application.origination_user_id IS NOT NULL THEN /*use the current application created by id if it is an origination user account*/
														create_origination_user_by_current_application.origination_user_id
													WHEN user_task_submission.submitted_by IS NOT NULL THEN /*use the oldest task origination user account*/
														user_task_submission.submitted_by
													ELSE
														NULL /*else use the create user*/
												END,
		submission_type_code				=	CASE
													WHEN AXIS_certificate_state_type_code NOT IN ('PRA','APL') THEN /*if not a pre-application or application*/
														ISNULL(stx.AXIS_submission_type_code,'DEL')
													ELSE
														stx.AXIS_submission_type_code
												END,
		BK_originator_customer_number		=	LEFT(applicationInfo.LENDERIDENTIFIER,5),
		BK_originator_customer_branch_number=	RIGHT(applicationInfo.LENDERIDENTIFIER,4),		
		insurance_paid_type_code			=	CASE
													WHEN AXIS_certificate_state_type_code NOT IN ('PRA','APL') THEN /*if not a pre-application or application*/
														ISNULL(iptx.AXIS_insurance_paid_type_code,'BPI')
													ELSE
														iptx.AXIS_insurance_paid_type_code
												END,
		premium_plan_type_code				=	CASE
													WHEN AXIS_certificate_state_type_code NOT IN ('PRA','APL') THEN /*if not a pre-application or application*/
														ISNULL(pptx.AXIS_premium_plan_type_code,'MTA')
													ELSE
														pptx.AXIS_premium_plan_type_code
												END,
		coverage_percentage					=	CASE
													WHEN AXIS_certificate_state_type_code NOT IN ('PRA','APL') THEN /*if not a pre-application or application*/
														CONVERT(DECIMAL(8,4),ISNULL(ROUND(CONVERT(DECIMAL(8,4),loanfeatures.micoveragepercent)/100,4),0))
													ELSE
														CONVERT(DECIMAL(8,4),ROUND(CONVERT(DECIMAL(8,4),loanfeatures.micoveragepercent)/100,4),0)
												END,
		refund_type_code					=	CASE
													WHEN AXIS_certificate_state_type_code NOT IN ('PRA','APL') THEN /*if not a pre-application or application*/
														ISNULL(rftx.AXIS_refund_type_code,'NOR')
													ELSE
														rftx.AXIS_refund_type_code
												END, 
		renewal_type_code					=	CASE
													WHEN AXIS_certificate_state_type_code NOT IN ('PRA','APL') THEN /*if not a pre-application or application*/
														ISNULL(rntx.AXIS_renewal_type_code,'CON')
													ELSE
														rntx.AXIS_renewal_type_code
												END,
		created_by							=	application_date.CREATEDBY,
		created								=	application_date.CREATEDATE,
		updated_by							=	NULL,
		updated								=	NULL,
		version								=	1,
		application_status_code				=	NULL,
		creation_channel					=	CASE
													WHEN ESTATERIGHTSTYPE IS NULL THEN
														'UI'
													ELSE 
														'B2B' 
												END, 
		workflow_status_updated_date		=	NULL,
		is_repricing_required				=	0,
		last_edited_by						=	NULL,
		last_edited							=	NULL,
		internal_user_locked_by				=	NULL,
		internal_user_locked_datetime		=	NULL,
		external_user_locked_by				=	NULL,
		external_user_locked_datetime		=	NULL,
		is_certificate_document_generated	=	CASE
												WHEN policy.policystatus IN ('OLI_POLSTAT_ADDITIONAL_PREMIUM_DUE','OLI_POLSTAT_CANCELLED','OLI_POLSTAT_EXPIRED','OLI_POLSTAT_REINSTMT_INPROGRESS','OLI_POLSTAT_REINSTMT_RESUBMISSION','OLI_POLSTAT_REINSTMT_RQRMTS_PENDING','OLI_POLSTAT_TERMINATE') AND loandtls.CLOSINGDATE IS NULL THEN /*if a loan closed date does not exist the state must be a commitment*/
													1 /*must have been a commitment*/
												WHEN policy.policystatus IN ('OLI_POLSTAT_ADDITIONAL_PREMIUM_DUE','OLI_POLSTAT_CANCELLED','OLI_POLSTAT_EXPIRED','OLI_POLSTAT_REINSTMT_INPROGRESS','OLI_POLSTAT_REINSTMT_RESUBMISSION','OLI_POLSTAT_REINSTMT_RQRMTS_PENDING','OLI_POLSTAT_TERMINATE') AND loandtls.CLOSINGDATE IS NULL AND loanfeatures.loanscheduledclosingdate IS NOT NULL AND pptx.AXIS_premium_plan_type_code = 'MTA' THEN /*if a loan closed date does not exist but it is Monthly ADVANTAGE with scheduled loan closed date it must be a certificate*/
													1 /*must have been a certificate*/
												WHEN policy.policystatus IN ('OLI_POLSTAT_ADDITIONAL_PREMIUM_DUE','OLI_POLSTAT_CANCELLED','OLI_POLSTAT_EXPIRED','OLI_POLSTAT_REINSTMT_INPROGRESS','OLI_POLSTAT_REINSTMT_RESUBMISSION','OLI_POLSTAT_REINSTMT_RQRMTS_PENDING','OLI_POLSTAT_TERMINATE') AND loandtls.CLOSINGDATE IS NOT NULL THEN /*if a loan close date exists it must be a certificate*/
													1 /*must have been a certificate*/
												ELSE
													0
											END,
		is_non_pricing_changes_pending		=	0,
		workflow_status_code				=	NULL,
		previous_workflow_status_code       =   NULL,
		workflow_status_updated_by          =   NULL,
		workflow_task_code                  =   NULL,
		application_decision_code			=	CASE 
													WHEN applicationInfo.underwriterdecision in ('Approved','ConditionedApproval') THEN /*approved*/
														'APV'
													WHEN applicationInfo.underwriterdecision in ('Declined','Manually Declined') THEN /*declined*/
														'DCL'
													WHEN applicationInfo.underwriterdecision ='Suspended' AND inprogress_task_user.roletype ='Processor' AND applicationInfo.applicationtype ='StandardApplication' THEN /*non-delegated application; supensed and assigned to a processor*/
														'PIC'
													WHEN applicationInfo.underwriterdecision ='Suspended' AND inprogress_task_user.roletype ='Underwriter' AND applicationInfo.applicationtype ='StandardApplication' THEN /*non-delegated application; supensed and assigned to a underwriter*/
														'PND'
													ELSE 
														NULL 
												END,
		decline_reason_num_of_units			=	NULL,
    	decline_reason_other_1				=   NULL,
    	decline_reason_other_2				=   NULL,
		cover_letter_ind					=	0,
		is_best_mi_rate						=	0,
		manager_review_decline_decision_ind	=	NULL,
		is_hold_for_condition_docs_uploaded	=	0,
		is_credit_info_changed				=	0,
		escalated_by						=	NULL,
		is_fcra_document_generated			=	0,
		resubmission_date					=	NULL,
		advanced_to_underwriting_by			=	NULL,
		decision_letter_email_ids			=	NULL,
		email_decision_letter_ind			=	0,
		decision_date						=	descision.CREATEDATE,
		decision_by							=	descision.ownerid,
		rush_indicator						=	0,
		product_type						=	CASE 
													WHEN (FREDDIEMACDECISION = 'Eligible' OR FANNIEMAEDECISION = 'Eligible') AND adjustment.name IN ('Loan Size > $417,000', 'Loan greater than $625,500','Loan greater than $417,000') THEN /*if eligible for FNMA or FHMLC and there is a pricing adjustment due to the loan size*/
														'AUS High Balance Conforming'
													WHEN (FREDDIEMACDECISION = 'Eligible'OR FANNIEMAEDECISION = 'Eligible') THEN 
														'AUS Conforming'
													WHEN (FREDDIEMACDECISION != 'Eligible'AND FANNIEMAEDECISION != 'Eligible') AND adjustment.name IN ('Loan Size > $417,000', 'Loan greater than $625,500','Loan greater than $417,000') THEN /*if not eligible for FNMA or FHMLC and there is a pricing adjustment due to the loan size*/
														'Non AUS Jumbo'
													ELSE 
														'Non AUS Conforming'
												END,
		delegated_last_action_code			=	NULL,
		current_workflow_task_id			=	NULL,
		initial_underwriter					=	initial_uw.OWNERID,
		sla_clock_start_time				=	NULL,
		sla_clock_end_time                  =   NULL,
		previous_application_decision_code	=	CASE 
													WHEN previous_descision.underwriterdecision in ('Approved','ConditionedApproval') THEN /*approved*/
														'APV'
													WHEN previous_descision.underwriterdecision in ('Declined','Manually Declined') THEN /*declined*/
														'DCL'
													WHEN previous_descision.underwriterdecision ='Suspended' AND previous_inprogress_task_user.roletype ='Processor' AND applicationInfo.applicationtype ='StandardApplication' THEN /*non-delegated application; supensed and assigned to a processor*/
														'PIC'
													WHEN previous_descision.underwriterdecision ='Suspended' AND previous_inprogress_task_user.roletype ='Underwriter' AND applicationInfo.applicationtype ='StandardApplication' THEN /*non-delegated application; supensed and assigned to a underwriter*/
														'PND'
													ELSE 
														NULL 
												END,
		is_qa_review_recommended			=	0,
		qa_review_recommended_reason_code	=	NULL,
		qa_review_status_code				=	NULL,
		qa_review_recommended_date			=	NULL,
		qa_review_recommended_by			=	NULL,
		sla_timer_trigger_code				=	NULL
	FROM
		lf$app_policy policy
	INNER JOIN
		lf$app_holding holding
	ON
		holding.canonicalid = policy.parentcanonicalid
	AND
		holding.enabledflag = 'Y' /*Determines If Record Is Valid Or Not*/
	INNER JOIN 
		mi$app_applicationinfo applicationInfo
	ON
		policy.canonicalid = applicationInfo.parentcanonicalid
	LEFT OUTER JOIN
		MI$APP_CERTIFICATE certificate
	ON
		certificate.PARENTCANONICALID = policy.CANONICALID
	LEFT OUTER JOIN
		mi$app_loan_dtls loandtls 
	ON 
		loandtls.parentcanonicalid = applicationInfo.canonicalid
	LEFT OUTER JOIN
		mi$app_loan_features loanfeatures 
	ON 
		loanfeatures.parentcanonicalid = loandtls.loandetailskey
	LEFT OUTER JOIN
		(
		SELECT 
			TRACKINGID,
			MIN(CASE 
					WHEN INITIALSUBMISSIONDATE IS NULL THEN
						CREATEDATE 
					ELSE 
						INITIALSUBMISSIONDATE
				END) as submission_date
	    FROM
			mi$app_applicationinfo
	    GROUP BY 
			TRACKINGID
	     ) submission_date
	ON
		submission_date.TRACKINGID = applicationInfo.TRACKINGID
	LEFT OUTER JOIN
		(
		SELECT
			ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) certificate_number,
			ownerid AS submitted_by
		FROM
			USER_TASK ut
		WHERE
			EXISTS
			(
			SELECT
				*
			FROM
				(
				SELECT
					ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) AS certificate_number,
					MIN(CANONICALID) AS CANONICALID
				FROM
					USER_TASK
				WHERE
					OWNERROLENAME LIKE 'LoanOriginators'
				GROUP BY
					ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER)
				) iut
			WHERE
				iut.CANONICALID = ut.CANONICALID
			)
		) user_task_submission
	ON
		user_task_submission.certificate_number = applicationInfo.TRACKINGID
	LEFT OUTER JOIN
		(
		SELECT
			USERID AS origination_user_id
		FROM
			LF$APP_SEEC_SYSTEMUSER sysu
		WHERE
			EXISTS
				(
				SELECT
					*
				FROM
					LF$APP_SEEC_ROLEREF rolr
				WHERE
					EXISTS
						(
						SELECT
							*
						FROM
							dbo.LF$APP_SEEC_ROLE role
						WHERE
							ROLENAME = 'LoanOriginators'
						AND
							role.CANONICALID = rolr.ROLEID
						)
				AND
					sysu.CANONICALID = rolr.PARENTCANONICALID
				)
		) create_origination_user_by_current_application
	ON
		create_origination_user_by_current_application.origination_user_id = applicationInfo.CREATEDBY
	LEFT OUTER JOIN /*get create user by oldest application record*/
		(
		SELECT
			TRACKINGID,
			CREATEDBY AS origination_user_id
		FROM
			mi$app_applicationinfo applicationInfo
		WHERE
			EXISTS
				(
				SELECT
					*
				FROM
					(	
					SELECT
						min_canonical.TRACKINGID,
						MIN(min_canonical.CANONICALID) AS CANONICALID
					FROM
						mi$app_applicationinfo AS min_canonical
					WHERE
						EXISTS
							(
							SELECT
								*
							FROM
								(
								SELECT
									TRACKINGID,
									MIN(CREATEDATE) AS MINCREATEDATE
								FROM
									mi$app_applicationinfo applicationInfo
								GROUP BY
									TRACKINGID
								) min_app_create
							WHERE
								min_app_create.TRACKINGID = min_canonical.TRACKINGID
							AND
								min_app_create.MINCREATEDATE = min_canonical.CREATEDATE
							)
					GROUP BY
						min_canonical.TRACKINGID
					) min_canonical
				WHERE
					min_canonical.CANONICALID = applicationInfo.CANONICALID
				)
		AND
			EXISTS
				(
				SELECT
					*
				FROM
					(
					SELECT
						USERID AS origination_user_id
					FROM
						LF$APP_SEEC_SYSTEMUSER sysu
					WHERE
						EXISTS
							(
							SELECT
								*
							FROM
								LF$APP_SEEC_ROLEREF rolr
							WHERE
								EXISTS
									(
									SELECT
										*
									FROM
										dbo.LF$APP_SEEC_ROLE role
									WHERE
										ROLENAME IN ('LoanOriginators','Underwriters','SupUnderwriters','UnderWritingDirector')
									AND
										role.CANONICALID = rolr.ROLEID
									)
							AND
								sysu.CANONICALID = rolr.PARENTCANONICALID
							)
					) origination_users
				WHERE
					origination_users.origination_user_id = applicationInfo.CREATEDBY
				)
		) create_origination_user_by_application
	ON
		create_origination_user_by_application.origination_user_id = applicationInfo.CREATEDBY
	AND
		create_origination_user_by_application.trackingid = applicationInfo.trackingid
	LEFT OUTER JOIN
		(
		SELECT
			TRACKINGID,
			CREATEDATE,
			CREATEDBY,
			ROW_NUMBER() OVER (PARTITION BY TRACKINGID ORDER BY CREATEDATE ASC) AS rn
		FROM 
			mi$app_applicationinfo
		GROUP BY 
			TRACKINGID,
			CREATEDATE,
			CREATEDBY
	    ) application_date 
	ON 
		application_date.TRACKINGID = applicationInfo.TRACKINGID
	AND
		application_date.rn = 1 /*get the first row of data created for this application which represents the date it was created*/
	LEFT OUTER JOIN
		(/*get the first underwriter to touch this certificate*/
		SELECT
			MACAPPLICATIONNUMBER,
			OWNERID,
			CREATEDATE,
			ROW_NUMBER() OVER (PARTITION BY MACAPPLICATIONNUMBER ORDER BY CANONICALID DESC) AS rn
		FROM 
			USER_TASK
		WHERE 
			OWNERROLENAME IN ('SupUnderwriters','UnderWritingDirector','CaseMgmtUnderwriter') /*underwriter*/
		AND
			MACAPPLICATIONNUMBER IS NOT NULL /*Only Consider Tasks With Valid Application Numbers*/
		) initial_uw 
	ON
		initial_uw.MACAPPLICATIONNUMBER = applicationInfo.TRACKINGID
	AND
		initial_uw.rn = 1 /*get the first row of data created for this application which represents the date it was created*/
	LEFT OUTER JOIN
		(/*retrieve the first underwriter to make a descion*/
		SELECT
			MACAPPLICATIONNUMBER,
			OWNERID,
			CREATEDATE,
			APP_STATUS,
			ROW_NUMBER() OVER (PARTITION BY MACAPPLICATIONNUMBER ORDER BY CANONICALID DESC) AS rn
		FROM
			USER_TASK
		WHERE
			APP_STATUS IN ('Commitment','Commitment with Conditions','Rejected','Hold for Conditions','In Progress') /*decision related tasks*/
		AND
			OWNERROLENAME IN ('SupUnderwriters','UnderWritingDirector','CaseMgmtUnderwriter') /*underwriter*/
		AND
			MACAPPLICATIONNUMBER IS NOT NULL /*ignore unknown certificate numbers*/
		) descision
	ON
		descision.MACAPPLICATIONNUMBER = applicationInfo.TRACKINGID
	AND
		descision.rn = 1 /*get the first row of data created for this application which represents the date it was created*/
	LEFT OUTER JOIN
		(/*retrieve the first underwriter to make a descion*/
		SELECT
			TRACKINGID,
			underwriterdecision,
			CREATEDATE,
			ROW_NUMBER() OVER (PARTITION BY TRACKINGID ORDER BY CREATEDATE DESC) AS rn
		FROM
			mi$app_applicationinfo applicationInfo
		WHERE
			TRACKINGID IS NOT NULL /*ignore unknown certificate numbers*/
		AND
			applicationInfo.underwriterdecision IS NOT NULL /*a decision must have been made*/
		AND
			EXISTS /*must be different from the current underwriting status*/
				(
				SELECT
					*
				FROM
					mi$app_applicationinfo cur_applicationInfo
				WHERE
					cur_applicationInfo.APPVERSIONSTATUS = 'current'
				AND
					cur_applicationInfo.underwriterdecision IS NOT NULL /*a status must exist*/
				AND
					cur_applicationInfo.underwriterdecision != applicationInfo.underwriterdecision
				AND
					cur_applicationInfo.TRACKINGID = applicationInfo.TRACKINGID
				)
		) previous_descision
	ON
		previous_descision.TRACKINGID = applicationInfo.TRACKINGID
	AND
		previous_descision.rn = 1 /*get the first row of data created for this application which represents the date it was created*/	
	LEFT OUTER JOIN
		dbo.mi$app_mi_adjustment adjustment
	ON
		adjustment.PARENTCANONICALID = certificate.CERTIFICATEKEY
	LEFT OUTER JOIN
		(/*look for open tasks assigned to underwriters or processors*/
		SELECT
			ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) AS certificate_number,
			CASE
				  WHEN OWNERROLENAME = 'poolunderwriter' THEN
						'Underwriter'
				  ELSE
						'Processor'
			END AS RoleType
		FROM 
			USER_TASK 
		WHERE 
			EXISTS
				(
				SELECT
					*
				FROM
					(
					SELECT /*get the most recent open task*/
						ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) AS certificate_number,
						MAX(CANONICALID) CANONICALID
					FROM
						USER_TASK
					WHERE 
						APP_STATUS = 'In Progress'
					AND
						TASK_STATUS = 'open'
					AND
						ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) IS NOT NULL /*ignore unknown certificate records*/
					GROUP BY
						ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER)
					) i
				WHERE
					i.CANONICALID = USER_TASK.CANONICALID
				 )
		) inprogress_task_user
	ON
		inprogress_task_user.certificate_number = applicationInfo.TRACKINGID
		
	LEFT OUTER JOIN
		(/*look for open tasks assigned to underwriters or processors*/
		SELECT
			ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) AS certificate_number,
			CASE
				  WHEN OWNERROLENAME = 'poolunderwriter' THEN
						'Underwriter'
				  ELSE
						'Processor'
			END AS RoleType
		FROM 
			USER_TASK 
		WHERE 
			EXISTS
				(
				SELECT
					*
				FROM
					(
					SELECT /*get the most recent open task*/
						ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) AS certificate_number,
						MAX(CANONICALID) CANONICALID
					FROM
						USER_TASK
					WHERE 
						APP_STATUS = 'In Progress'
					AND
						TASK_STATUS = 'completed'
					AND
						ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER) IS NOT NULL /*ignore unknown certificate records*/
					GROUP BY
						ISNULL(CERTIFICATENUMBER,MACAPPLICATIONNUMBER)
					) i
				WHERE
					i.CANONICALID = USER_TASK.CANONICALID
				 )
		) previous_inprogress_task_user
	ON
		previous_inprogress_task_user.certificate_number = applicationInfo.TRACKINGID
		
	LEFT OUTER JOIN
		@LKUP_certificate_state_type_xref csttx
	ON
		csttx.IMS_POLICYSTATUS = policy.policystatus
	LEFT OUTER JOIN
		@LKUP_submission_type_xref stx
	ON
		stx.IMS_applicationtype = applicationInfo.applicationtype
	LEFT OUTER JOIN
		@LKUP_insurance_paid_type_xref iptx
	ON
		iptx.IMS_premiumpaymenttype = applicationInfo.premiumpaymenttype
	LEFT OUTER JOIN
		@LKUP_premium_plan_type_xref pptx
	ON
		pptx.IMS_premiumplantype = applicationInfo.premiumplantype
	AND
		pptx.IMS_midurationtype = ISNULL(applicationInfo.midurationtype,'')
	LEFT OUTER JOIN
		@LKUP_refund_type_xref rftx
	ON
		rftx.IMS_premiumrefundabletype = applicationInfo.premiumrefundabletype
	LEFT OUTER JOIN
		@LKUP_renewal_type_xref rntx
	ON
		rntx.IMS_rencalctype = applicationInfo.rencalctype
	WHERE
		applicationInfo.appversionstatus = 'Current'
	AND
		applicationInfo.trackingid IS NOT NULL /*a certificate number must exist*/
	AND
		applicationInfo.lenderidentifier IS NOT NULL /*a certificate originator master policy must exist*/
	ORDER BY 1
	--AND
	--    a.BK_originator_customer_number in ('<<customerNumberList>>')
END