package com.sparg.java.dm.model;

import com.sparg.java.dm.annotation.BK;
import com.sparg.java.dm.annotation.FK;
import com.sparg.java.dm.annotation.PK;
import com.sparg.java.dm.annotation.Source;
import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.annotation.Target;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author sambasivaprasada.m Date 25/03/2014
 * 
 */

@Table(name = "customer_branch", sourceQuery = "select * from customer_branch")
public class CustomerBranch {

    @Source(name = "branch_number")
    @Target(name = "branch_number")
    private String branchNumber;

	@PK
    @BK
    @Source(name = "customer_branch_id")
	private Long customerBranchId;

    @FK(reference = Customer.class, field = "customerId")
    @Target(name = "customer_id")
    @Source(name = "customer_id")
    private Long customerId;

    @Source(name = "billing_format_code")
	@Target(name = "billing_format_code")
	private String billingFormatCode;

	@Source(name = "payment_format_code")
	@Target(name = "payment_format_code")
	private String paymentFormatCode;

	@Source(name = "branch_name")
	@Target(name = "branch_name")
	private String branchName;

	@Source(name = "preferred_name_on_certificate")
	@Target(name = "preferred_name_on_certificate")
	private String preferredNameOnCertificate;

	@Source(name = "effective_date")
	@Target(name = "effective_date")
	private Date effectiveDate;

	@Source(name = "master_policy_type_code")
	@Target(name = "master_policy_type_code")
	private String masterPolicyTypeCode;

	@Source(name = "institution_type_code")
	@Target(name = "institution_type_code")
	private String institutionTypeCode;

	@Source(name = "business_channel_code")
	@Target(name = "business_channel_code")
	private String businessChannelCode;

	@Source(name = "phone")
	@Target(name = "phone")
	private String phone;

	@Source(name = "fax")
	@Target(name = "fax")
	private String fax;

	@Source(name = "email")
	@Target(name = "email")
	private String email;

	@Source(name = "is_servicer_designated")
	@Target(name = "is_servicer_designated", update = true)
	private Integer servicerDesignated;

    @Source(name = "statement_generation_day")
	@Target(name = "statement_generation_day")
	private Integer statementGenerationDay;

	@Source(name = "delivery_method_code")
	@Target(name = "delivery_method_code")
	private String deliveryMethodCode;

	@Source(name = "is_seperate_bpmi_lpmi_statements")
	@Target(name = "is_seperate_bpmi_lpmi_statements")
	private Integer seperateBpmiLpmiStatements;

	@Target(name = "created_by")
	private Integer createdBy = 1;

	@Target(name = "created")
	private Timestamp created = new Timestamp(new java.util.Date().getTime());

	@Target(name = "updated_by", update = true)
	private Integer updatedBy = 1;

	@Target(name = "updated", update = true)
	private Timestamp updated = new Timestamp(new java.util.Date().getTime());

	@Target(name = "version")
	private Integer version = 1;

	@Source(name = "is_active")
	@Target(name = "is_active")
	private Integer active;

	@Source(name = "service_bureau_client_code")
	@Target(name = "service_bureau_client_code")
	private String serviceBureauClientCode;

	@Source(name = "billing_file_name")
	@Target(name = "billing_file_name")
	private String billingFileName;

	@Source(name = "service_bureau_code")
	@Target(name = "service_bureau_code")
	private String serviceBureauCode;
	
	@Source(name = "is_email_enabled")
	@Target(name = "is_email_enabled",update = true)
	private Integer emailEnabled;

	@Source(name = "is_delegated_approved")
	@Target(name = "is_delegated_approved", update = true)
	private Integer delegatedApproved;

	@Source(name = "delegated_effective_date")
	@Target(name = "delegated_effective_date", update = true)
	private Timestamp delegatedEffectiveDate;

	@Source(name = "is_qa_review_allowed")
	@Target(name = "is_qa_review_allowed", update = true)
	private Integer qaReviewAllowed;

	@Source(name = "is_bulk_transaction_allowed")
	@Target(name = "is_bulk_transaction_allowed", update = true)
	private Integer bulkTransactionAllowed;

	@Source(name = "qa_review_effective_from")
	@Target(name = "qa_review_effective_from", update = true)
	private Timestamp qaReviewEffectiveFrom;

	@Source(name = "qa_review_effective_to")
	@Target(name = "qa_review_effective_to", update = true)
	private Timestamp qaReviewEffectiveTo;

	@Source(name = "refund_preference")
	@Target(name = "refund_preference", update = true)
	private String refundPreference;
	
	@Source(name = "is_correspondent")
	@Target(name = "is_correspondent", update = true)
	private Integer correspondent = 0;
	
	@Source(name = "is_b2b_origination_allowed")
	@Target(name = "is_b2b_origination_allowed", update = true)
	private Integer b2bOriginationAllowed = 0;
	
	@Source(name = "is_b2b_servicing_allowed")
	@Target(name = "is_b2b_servicing_allowed", update = true)
	private Integer b2bServicingAllowed = 0;
	
	@Source(name = "is_subservicer_designated")
	@Target(name = "is_subservicer_designated", update = true)
	private Integer subservicerDesignated;
	
	@Source(name = "subservicer_designated_customer_id")
	@Target(name = "subservicer_designated_customer_id", update = true)
	private Integer subservicerDesignatedCustomerId;

	@Source(name = "subservicer_designated_customer_branch_id")
	@Target(name = "subservicer_designated_customer_branch_id", update = true)
	private Integer subservicerDesignatedCustomerBranchId;

	@Source(name = "billing_cutoff_day")
	@Target(name = "billing_cutoff_day", update = true)
	private Integer billingCutoffDay;

	@Source(name = "is_commitment_excluded")
	@Target(name = "is_commitment_excluded", update = true)
	private Integer commitmentExcluded = 0; 

	@Source(name = "b2b_los_system")
	@Target(name = "b2b_los_system", update = true)
	private String b2bLosSystem;
	
	@Source(name = "is_b2b_accept_loan_closed_date_allowed")
	@Target(name = "is_b2b_accept_loan_closed_date_allowed", update = true)
	private Integer b2bAcceptLoanClosedDateAllowed = 0; 
	
	@Source(name = "is_b2b_unsolicited_response_supported")
	@Target(name = "is_b2b_unsolicited_response_supported", update = true)
	private Integer b2bUnsolicitedResponseSupported = 0; 
		
	@Source(name = "b2b_unsolicited_response_format")
	@Target(name = "b2b_unsolicited_response_format", update = true)
	private String b2bUnsolicitedResponseFormat;
	
	@Source(name = "is_b2b_commitment_excluded")
	@Target(name = "is_b2b_commitment_excluded", update = true)
	private Integer b2bCommitmentExcluded = 0; 

	@Source(name = "is_monthly_adv_forward_dated")
	@Target(name = "is_monthly_adv_forward_dated", update = true)
	private Integer monthlyAdvForwardDated = 0; 
	
	@Source(name = "is_watchlist")
	@Target(name = "is_watchlist", update = true)
	private Integer watchlist; 
	
	@Source(name = "watchlist_effective_from")
	@Target(name = "watchlist_effective_from", update = true)
	private Timestamp watchlistEffectiveFrom;
	
	@Source(name = "watchlist_effective_to")
	@Target(name = "watchlist_effective_to", update = true)
	private Timestamp watchlistEffectiveTo;

	@Source(name = "b2b_statement_delivery_day")
	@Target(name = "b2b_statement_delivery_day", update = true)
	private Integer b2bStatementDeliveryDay;
	
	@Source(name = "is_mailing_address_different")
	@Target(name = "is_mailing_address_different", update = true)
	private Integer mailingAddressDifferent; 

	@Source(name = "phone_extension")
	@Target(name = "phone_extension", update = true)
	private String phoneExtension;
	
	@Source(name = "is_terminated")
	@Target(name = "is_terminated", update = true)
	private Integer terminated = 0;
	
	@Source(name = "billing_cutoff_date_month")
	@Target(name = "billing_cutoff_date_month", update = true)
	private String billingCutoffDateMonth;
	

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(final String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public Long getCustomerBranchId() {
        return customerBranchId;
    }

    public void setCustomerBranchId(final Long customerBranchId) {
        this.customerBranchId = customerBranchId;

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;

    }

    public String getBillingFormatCode() {
        return billingFormatCode;
    }

    public void setBillingFormatCode(final String billingFormatCode) {
        this.billingFormatCode = billingFormatCode;
    }

    public String getPaymentFormatCode() {
        return paymentFormatCode;
    }

    public void setPaymentFormatCode(final String paymentFormatCode) {
        this.paymentFormatCode = paymentFormatCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    public String getPreferredNameOnCertificate() {
        return preferredNameOnCertificate;
    }

    public void setPreferredNameOnCertificate(final String preferredNameOnCertificate) {
        this.preferredNameOnCertificate = preferredNameOnCertificate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(final Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getMasterPolicyTypeCode() {
        return masterPolicyTypeCode;
    }

    public void setMasterPolicyTypeCode(final String masterPolicyTypeCode) {
        this.masterPolicyTypeCode = masterPolicyTypeCode;
    }

    public String getInstitutionTypeCode() {
        return institutionTypeCode;
    }

    public void setInstitutionTypeCode(final String institutionTypeCode) {
        this.institutionTypeCode = institutionTypeCode;
    }

    public String getBusinessChannelCode() {
        return businessChannelCode;
    }

    public void setBusinessChannelCode(final String businessChannelCode) {
        this.businessChannelCode = businessChannelCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(final String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getServicerDesignated() {
        return servicerDesignated;
    }

    public void setServicerDesignated(final Integer servicerDesignated) {
        this.servicerDesignated = servicerDesignated;
    }

    public Integer getStatementGenerationDay() {
        return statementGenerationDay;
    }

    public void setStatementGenerationDay(final Integer statementGenerationDay) {
        this.statementGenerationDay = statementGenerationDay;
    }

    public String getDeliveryMethodCode() {
        return deliveryMethodCode;
    }

    public void setDeliveryMethodCode(final String deliveryMethodCode) {
        this.deliveryMethodCode = deliveryMethodCode;
    }

    public Integer getSeperateBpmiLpmiStatements() {
        return this.seperateBpmiLpmiStatements;
    }

    public void setSeperateBpmiLpmiStatements(final Integer seperateBpmiLpmiStatements) {
        this.seperateBpmiLpmiStatements = seperateBpmiLpmiStatements;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(final Timestamp created) {
        this.created = created;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(final Timestamp updated) {
        this.updated = updated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

    public String getServiceBureauClientCode() {
        return serviceBureauClientCode;
    }

    public void setServiceBureauClientCode(final String serviceBureauClientCode) {
        this.serviceBureauClientCode = serviceBureauClientCode;
    }

    public String getBillingFileName() {
        return billingFileName;
    }

    public void setBillingFileName(final String billingFileName) {
        this.billingFileName = billingFileName;
    }

    public String getServiceBureauCode() {
        return serviceBureauCode;
    }

    public void setServiceBureauCode(final String serviceBureauCode) {
        this.serviceBureauCode = serviceBureauCode;
    }

    public Integer getEmailEnabled() {
		return emailEnabled;
	}

	public void setEmailEnabled(Integer emailEnabled) {
		this.emailEnabled = emailEnabled;
	}

	public Integer getDelegatedApproved() {
		return delegatedApproved;
	}

	public void setDelegatedApproved(Integer delegatedApproved) {
		this.delegatedApproved = delegatedApproved;
	}

	public Timestamp getDelegatedEffectiveDate() {
		return delegatedEffectiveDate;
	}

	public void setDelegatedEffectiveDate(Timestamp delegatedEffectiveDate) {
		this.delegatedEffectiveDate = delegatedEffectiveDate;
	}

	public Integer getQaReviewAllowed() {
		return qaReviewAllowed;
	}

	public void setQaReviewAllowed(Integer qaReviewAllowed) {
		this.qaReviewAllowed = qaReviewAllowed;
	}

	public Integer getBulkTransactionAllowed() {
		return bulkTransactionAllowed;
	}

	public void setBulkTransactionAllowed(Integer bulkTransactionAllowed) {
		this.bulkTransactionAllowed = bulkTransactionAllowed;
	}

	public Timestamp getQaReviewEffectiveFrom() {
		return qaReviewEffectiveFrom;
	}

	public void setQaReviewEffectiveFrom(Timestamp qaReviewEffectiveFrom) {
		this.qaReviewEffectiveFrom = qaReviewEffectiveFrom;
	}

	public Timestamp getQaReviewEffectiveTo() {
		return qaReviewEffectiveTo;
	}

	public void setQaReviewEffectiveTo(Timestamp qaReviewEffectiveTo) {
		this.qaReviewEffectiveTo = qaReviewEffectiveTo;
	}

	public String getRefundPreference() {
		return refundPreference;
	}

	public void setRefundPreference(String refundPreference) {
		this.refundPreference = refundPreference;
	}

	public Integer getCorrespondent() {
		return correspondent;
	}

	public void setCorrespondent(Integer correspondent) {
		this.correspondent = correspondent;
	}

	public Integer getB2bOriginationAllowed() {
		return b2bOriginationAllowed;
	}

	public void setB2bOriginationAllowed(Integer b2bOriginationAllowed) {
		this.b2bOriginationAllowed = b2bOriginationAllowed;
	}

	public Integer getB2bServicingAllowed() {
		return b2bServicingAllowed;
	}

	public void setB2bServicingAllowed(Integer b2bServicingAllowed) {
		this.b2bServicingAllowed = b2bServicingAllowed;
	}

	public Integer getSubservicerDesignated() {
		return subservicerDesignated;
	}

	public void setSubservicerDesignated(Integer subservicerDesignated) {
		this.subservicerDesignated = subservicerDesignated;
	}

	public Integer getSubservicerDesignatedCustomerId() {
		return subservicerDesignatedCustomerId;
	}

	public void setSubservicerDesignatedCustomerId(
			Integer subservicerDesignatedCustomerId) {
		this.subservicerDesignatedCustomerId = subservicerDesignatedCustomerId;
	}

	public Integer getSubservicerDesignatedCustomerBranchId() {
		return subservicerDesignatedCustomerBranchId;
	}

	public void setSubservicerDesignatedCustomerBranchId(
			Integer subservicerDesignatedCustomerBranchId) {
		this.subservicerDesignatedCustomerBranchId = subservicerDesignatedCustomerBranchId;
	}

	public Integer getBillingCutoffDay() {
		return billingCutoffDay;
	}

	public void setBillingCutoffDay(Integer billingCutoffDay) {
		this.billingCutoffDay = billingCutoffDay;
	}

	public Integer getCommitmentExcluded() {
		return commitmentExcluded;
	}

	public void setCommitmentExcluded(Integer commitmentExcluded) {
		this.commitmentExcluded = commitmentExcluded;
	}

	public String getB2bLosSystem() {
		return b2bLosSystem;
	}

	public void setB2bLosSystem(String b2bLosSystem) {
		this.b2bLosSystem = b2bLosSystem;
	}

	public Integer getB2bAcceptLoanClosedDateAllowed() {
		return b2bAcceptLoanClosedDateAllowed;
	}

	public void setB2bAcceptLoanClosedDateAllowed(
			Integer b2bAcceptLoanClosedDateAllowed) {
		this.b2bAcceptLoanClosedDateAllowed = b2bAcceptLoanClosedDateAllowed;
	}

	public Integer getB2bUnsolicitedResponseSupported() {
		return b2bUnsolicitedResponseSupported;
	}

	public void setB2bUnsolicitedResponseSupported(
			Integer b2bUnsolicitedResponseSupported) {
		this.b2bUnsolicitedResponseSupported = b2bUnsolicitedResponseSupported;
	}

	public String getB2bUnsolicitedResponseFormat() {
		return b2bUnsolicitedResponseFormat;
	}

	public void setB2bUnsolicitedResponseFormat(String b2bUnsolicitedResponseFormat) {
		this.b2bUnsolicitedResponseFormat = b2bUnsolicitedResponseFormat;
	}

	public Integer getB2bCommitmentExcluded() {
		return b2bCommitmentExcluded;
	}

	public void setB2bCommitmentExcluded(Integer b2bCommitmentExcluded) {
		this.b2bCommitmentExcluded = b2bCommitmentExcluded;
	}

	public Integer getMonthlyAdvForwardDated() {
		return monthlyAdvForwardDated;
	}

	public void setMonthlyAdvForwardDated(Integer monthlyAdvForwardDated) {
		this.monthlyAdvForwardDated = monthlyAdvForwardDated;
	}

	public Integer getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(Integer watchlist) {
		this.watchlist = watchlist;
	}

	public Timestamp getWatchlistEffectiveFrom() {
		return watchlistEffectiveFrom;
	}

	public void setWatchlistEffectiveFrom(Timestamp watchlistEffectiveFrom) {
		this.watchlistEffectiveFrom = watchlistEffectiveFrom;
	}

	public Timestamp getWatchlistEffectiveTo() {
		return watchlistEffectiveTo;
	}

	public void setWatchlistEffectiveTo(Timestamp watchlistEffectiveTo) {
		this.watchlistEffectiveTo = watchlistEffectiveTo;
	}

	public Integer getB2bStatementDeliveryDay() {
		return b2bStatementDeliveryDay;
	}

	public void setB2bStatementDeliveryDay(Integer b2bStatementDeliveryDay) {
		this.b2bStatementDeliveryDay = b2bStatementDeliveryDay;
	}

	public Integer getMailingAddressDifferent() {
		return mailingAddressDifferent;
	}

	public void setMailingAddressDifferent(Integer mailingAddressDifferent) {
		this.mailingAddressDifferent = mailingAddressDifferent;
	}

	public String getPhoneExtension() {
		return phoneExtension;
	}

	public void setPhoneExtension(String phoneExtension) {
		this.phoneExtension = phoneExtension;
	}

	public Integer getTerminated() {
		return terminated;
	}

	public void setTerminated(Integer terminated) {
		this.terminated = terminated;
	}

	public String getBillingCutoffDateMonth() {
		return billingCutoffDateMonth;
	}

	public void setBillingCutoffDateMonth(String billingCutoffDateMonth) {
		this.billingCutoffDateMonth = billingCutoffDateMonth;
	}

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CustomerBranch that = (CustomerBranch) o;

        if (!customerBranchId.equals(that.customerBranchId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return customerBranchId.hashCode();
    }
}
