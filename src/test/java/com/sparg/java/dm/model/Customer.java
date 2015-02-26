package com.sparg.java.dm.model;


import com.sparg.java.dm.annotation.BK;
import com.sparg.java.dm.annotation.Filter;
import com.sparg.java.dm.annotation.PK;
import com.sparg.java.dm.annotation.Source;
import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.annotation.Target;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author: vimal.sengoden
 * Date: 3/26/14
 * Time: 2:44 PM
 */
@Table(name = "customer", sourceQueryFile = "customer.sql", sourceQuery = "select * from customer")
public class Customer {

    @Filter
    @BK
    @Source(name="customer_number")
    @Target(name="customer_number")
    private String customerNumber;

    @PK
    @Target(name="customer_id")
    private Long customerId;

    @Source(name="company_name")
    @Target(name="company_name")
    private String customerName;

    @Source(name="master_policy_type_code")
    @Target(name="master_policy_type_code")
    private String masterPolicyTypeCode;

    @Source(name="effective_date")
    @Target(name="effective_date")
    private Date effectiveDate;

    @Source(name="phone")
    @Target(name="phone")
    private String phone;

    @Source(name="fax")
    @Target(name="fax")
    private String fax;

    @Source(name="email")
    @Target(name="email")
    private String email;

    @Source(name="is_delegated_approved")
    @Target(name="is_delegated_approved")
    private Boolean delegatedApproved;

    @Source(name="freddie_mac_seller_servicer_number")
    @Target(name="freddie_mac_seller_servicer_number")
    private String freddieMacSellerServicerNumber;

    @Source(name="fannie_mae_seller_servicer_number")
    @Target(name="fannie_mae_seller_servicer_number")
    private String fannieMaeSellerServicerNumber;

    @Source(name="fdic_number")
    @Target(name="fdic_number")
    private String fdicNumber;

    @Source(name="ncua_number")
    @Target(name="ncua_number")
    private String ncuaNumber;

    @Target(name="created")
    private Timestamp created = new Timestamp(new java.util.Date().getTime());

    @Target(name="created_by")
    private Integer createdBy = 1;

    @Target(name="updated", update = true)
    private Timestamp updated = new Timestamp(new java.util.Date().getTime());

    @Target(name="updated_by", update = true)
    private Integer updatedBy = 1;

    @Target(name="version")
    private Integer version = 1;
    
    @Source(name="is_bulk_transaction_allowed")
    @Target(name="is_bulk_transaction_allowed", update = true)
    private Integer bulkTransactionAllowed;
    
    @Source(name="delegated_effective_date")
    @Target(name="delegated_effective_date", update = true)
    private Timestamp delegatedEffectiveDate;
    
    @Source(name="is_correspondent")
    @Target(name="is_correspondent", update = true)
    private Integer correspondent = 0;
    
    @Source(name="is_b2b_origination_allowed")
    @Target(name="is_b2b_origination_allowed", update = true)
    private Integer b2bOriginationAllowed = 0;
    
    @Source(name="investor_other")
    @Target(name="investor_other" , update = true)
    private String investorOther;
    
    @Source(name="b2b_los_system")
    @Target(name="b2b_los_system" , update = true)
    private String b2bLosSystem;
 
    @Source(name="is_b2b_accept_loan_closed_date_allowed")
    @Target(name="is_b2b_accept_loan_closed_date_allowed", update = true)
    private Integer b2bAcceptLoanClosedDateAllowed = 0;
    
    @Source(name="is_b2b_unsolicited_response_supported")
    @Target(name="is_b2b_unsolicited_response_supported", update = true)
    private Integer b2bUnsolicitedResponseSupported = 0;

    @Source(name="b2b_unsolicited_response_format")
    @Target(name="b2b_unsolicited_response_format" , update = true)
    private String b2bUnsolicitedResponseFormat;
    	
    @Source(name="is_mailing_address_different")
    @Target(name="is_mailing_address_different", update = true)
    private Integer mailingAddressDifferent = 0;
   
    @Source(name="phone_extension")
    @Target(name="phone_extension", update = true)
    private String phoneExtension;
    
    @Source(name="is_active")
    @Target(name="is_active", update = true)
    private Integer active = 1;
    
    @Source(name="is_terminated")
    @Target(name="is_terminated", update = true)
    private Integer terminated = 0;

    @Source(name="last_generated_branch_number")
    @Target(name="last_generated_branch_number" , update = true)
    private String lastGeneratedBranchNumber;
   
    @Source(name="is_migrated")
    @Target(name="is_migrated", update = true)
    private Integer migrated = 1;
    
    public String getCustomerNumber() {
        return customerNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerNumber(final String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getMasterPolicyTypeCode() {
        return masterPolicyTypeCode;
    }

    public void setMasterPolicyTypeCode(final String masterPolicyTypeCode) {
        this.masterPolicyTypeCode = masterPolicyTypeCode;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(final Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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

    public Boolean getDelegatedApproved() {
        return delegatedApproved;
    }

    public void setDelegatedApproved(final Boolean isDelegatedApproved) {
        this.delegatedApproved = isDelegatedApproved;
    }

    public String getFreddieMacSellerServicerNumber() {
        return freddieMacSellerServicerNumber;
    }

    public void setFreddieMacSellerServicerNumber(final String freddieMacSellerServicerNumber) {
        this.freddieMacSellerServicerNumber = freddieMacSellerServicerNumber;
    }

    public String getFannieMaeSellerServicerNumber() {
        return fannieMaeSellerServicerNumber;
    }

    public void setFannieMaeSellerServicerNumber(final String fannieMaeSellerServicerNumber) {
        this.fannieMaeSellerServicerNumber = fannieMaeSellerServicerNumber;
    }

    public String getFdicNumber() {
        return fdicNumber;
    }

    public void setFdicNumber(final String fdicNumber) {
        this.fdicNumber = fdicNumber;
    }

    public String getNcuaNumber() {
        return ncuaNumber;
    }

    public void setNcuaNumber(final String ncuaNumber) {
        this.ncuaNumber = ncuaNumber;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(final Timestamp created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(final Timestamp updated) {
        this.updated = updated;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

    public Integer getBulkTransactionAllowed() {
		return bulkTransactionAllowed;
	}

	public void setBulkTransactionAllowed(Integer bulkTransactionAllowed) {
		this.bulkTransactionAllowed = bulkTransactionAllowed;
	}

	public Timestamp getDelegatedEffectiveDate() {
		return delegatedEffectiveDate;
	}

	public void setDelegatedEffectiveDate(Timestamp delegatedEffectiveDate) {
		this.delegatedEffectiveDate = delegatedEffectiveDate;
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

	public String getInvestorOther() {
		return investorOther;
	}

	public void setInvestorOther(String investorOther) {
		this.investorOther = investorOther;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getTerminated() {
		return terminated;
	}

	public void setTerminated(Integer terminated) {
		this.terminated = terminated;
	}

    public String getLastGeneratedBranchNumber() {
        return lastGeneratedBranchNumber;
    }

    public void setLastGeneratedBranchNumber(final String lastGeneratedBranchNumber) {
        this.lastGeneratedBranchNumber = lastGeneratedBranchNumber;
    }

    public Integer getMigrated() {
        return migrated;
    }

    public void setMigrated(final Integer migrated) {
        this.migrated = migrated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        final Customer customer = (Customer) o;

        if (customerNumber != null ? !customerNumber.equals(customer.customerNumber) : customer.customerNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return customerNumber != null ? customerNumber.hashCode() : 0;
    }
}
