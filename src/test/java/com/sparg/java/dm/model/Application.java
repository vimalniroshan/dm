package com.sparg.java.dm.model;

import com.sparg.java.dm.annotation.BK;
import com.sparg.java.dm.annotation.PK;
import com.sparg.java.dm.annotation.Source;
import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.annotation.Target;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author sambasivaprasada.m
 *
 *         Date 01/04/2014
 *
 */
@Table(name = "application", sourceQueryFile = "application.sql", sourceQuery = "select * from application")
public class Application {

	@BK
	@Source(name = "certificate_number")
	@Target(name = "certificate_number")
	private String certificateNumber;

	@PK
	@Target(name = "application_id")
	private Long applicationId;

	@Source(name = "submitted_date")
	@Target(name = "submitted_date", update = true)
	private Timestamp submittedDate;

	@Source(name = "submitted_by")
	private String submittedByIMSUser;

	@Target(name = "submitted_by", update = true)
	private Integer submittedBy = 1;

	@Source(name = "submission_type_code")
	@Target(name = "submission_type_code")
	private String submissionTypeCode;

	@Source(name = "insurance_paid_type_code")
	@Target(name = "insurance_paid_type_code")
	private String insurancePaidTypeCode;

	@Source(name = "premium_plan_type_code")
	@Target(name = "premium_plan_type_code")
	private String premiumPlanTypeCode;

	@Source(name = "coverage_percentage")
	@Target(name = "coverage_percentage")
	private BigDecimal coveragePercentage;

	@Source(name = "refund_type_code")
	@Target(name = "refund_type_code")
	private String refundTypeCode;

	@Source(name = "renewal_type_code")
	@Target(name = "renewal_type_code")
	private String renewalTypeCode;

	@Source(name = "created_by")
	private String createdByIMSUser;

	@Target(name = "created_by", update = true)
	private Integer createdBy = 1;

	@Source(name = "created")
	@Target(name = "created", update = true)
	private Timestamp created = new Timestamp(new java.util.Date().getTime());

	@Target(name = "updated_by", update = true)
	private Integer updatedBy = 1;

	@Target(name = "updated", update = true)
	private Timestamp updated = new Timestamp(new java.util.Date().getTime());

	@Target(name = "version")
	private Integer version = 1;

	@Source(name = "creation_channel")
	@Target(name = "creation_channel", update = true)
	private String creationChannel;

	@Source(name = "workflow_status_updated_date")
	@Target(name = "workflow_status_updated_date", update = true)
	private Timestamp workflowStatusUpdatedDate;

	@Source(name = "is_repricing_required")
	@Target(name = "is_repricing_required", update = true)
	private Integer repricingRequired = 0;

	@Source(name = "last_edited_by")
	@Target(name = "last_edited_by", update = true)
	private Integer lastEditedBy;

	@Source(name = "last_edited")
	@Target(name = "last_edited", update = true)
	private Timestamp lastEdited;

	@Source(name = "internal_user_locked_by")
	@Target(name = "internal_user_locked_by", update = true)
	private Integer internalUserLockedBy;

	@Source(name = "internal_user_locked_datetime")
	@Target(name = "internal_user_locked_datetime", update = true)
	private Timestamp internalUserLockedDatetime;

	@Source(name = "external_user_locked_by")
	@Target(name = "external_user_locked_by", update = true)
	private Integer externalUserLockedBy;

	@Source(name = "external_user_locked_datetime")
	@Target(name = "external_user_locked_datetime", update = true)
	private Timestamp externalUserLockedDatetime;

	@Source(name = "is_certificate_document_generated")
	@Target(name = "is_certificate_document_generated", update = true)
	private Integer certificateDocumentGenerated = 0;

	@Source(name = "is_non_pricing_changes_pending")
	@Target(name = "is_non_pricing_changes_pending", update = true)
	private Integer nonPricingChangesPending = 0;

	@Source(name = "workflow_status_code")
	@Target(name = "workflow_status_code", update = true)
	private String workflowStatusCode;

	@Source(name = "previous_workflow_status_code")
	@Target(name = "previous_workflow_status_code", update = true)
	private String previousWorkflowStatusCode;

	@Source(name = "workflow_status_updated_by")
	@Target(name = "workflow_status_updated_by", update = true)
	private Integer workflowStatusUpdatedBy;

	@Source(name = "workflow_task_code")
	@Target(name = "workflow_task_code", update = true)
	private String workflowTaskCode;

	@Source(name = "application_decision_code")
	@Target(name = "application_decision_code", update = true)
	private String applicationDecisionCode;

	@Source(name = "decline_reason_num_of_units")
	@Target(name = "decline_reason_num_of_units", update = true)
	private Integer declineReasonNumOfUnits;

	@Source(name = "decline_reason_other_1")
	@Target(name = "decline_reason_other_1", update = true)
	private String declineReasonOther1;

	@Source(name = "decline_reason_other_2")
	@Target(name = "decline_reason_other_2", update = true)
	private String declineReasonOther2;

	@Source(name = "cover_letter_ind")
	@Target(name = "cover_letter_ind", update = true)
	private Integer coverLetterInd = 0;

	@Source(name = "is_best_mi_rate")
	@Target(name = "is_best_mi_rate", update = true)
	private Integer bestMiRate = 0;

	@Source(name = "manager_review_decline_decision_ind")
	@Target(name = "manager_review_decline_decision_ind", update = true)
	private Integer managerReviewDeclineDecisionInd;

	@Source(name = "is_hold_for_condition_docs_uploaded")
	@Target(name = "is_hold_for_condition_docs_uploaded", update = true)
	private Integer holdForConditionDocsUploaded = 0;

	@Source(name = "is_credit_info_changed")
	@Target(name = "is_credit_info_changed", update = true)
	private Integer creditInfoChanged = 0;

	@Source(name = "escalated_by")
	@Target(name = "escalated_by", update = true)
	private Integer escalatedBy;

	@Source(name = "is_fcra_document_generated")
	@Target(name = "is_fcra_document_generated", update = true)
	private Integer fcraDocumentGenerated = 0;

	@Source(name = "resubmission_date")
	@Target(name = "resubmission_date", update = true)
	private Timestamp resubmissionDate;

	@Source(name = "advanced_to_underwriting_by")
	@Target(name = "advanced_to_underwriting_by", update = true)
	private Integer advancedToUnderwritingBy;

	@Source(name = "decision_letter_email_ids")
	@Target(name = "decision_letter_email_ids", update = true)
	private String decisionLetterEmailIds;

	@Source(name = "email_decision_letter_ind")
	@Target(name = "email_decision_letter_ind", update = true)
	private Integer emailDecisionLetterInd = 0;

	@Source(name = "decision_date")
	@Target(name = "decision_date", update = true)
	private Timestamp decisionDate;

	@Source(name = "decision_by")
	private String decisionByIMSUser;

	@Target(name = "decision_by", update = true)
	private Integer decisionBy;

	@Source(name = "sla_clock_start_time")
	@Target(name = "sla_clock_start_time", update = true)
	private Timestamp slaClockStartTime;

	@Source(name = "rush_indicator")
	@Target(name = "rush_indicator", update = true)
	private Integer rushIndicator = 0;

	@Source(name = "product_type")
	@Target(name = "product_type", update = true)
	private String productType;

	@Source(name = "delegated_last_action_code")
	@Target(name = "delegated_last_action_code", update = true)
	private String delegatedLastActionCode;

	@Source(name = "current_workflow_task_id")
	@Target(name = "current_workflow_task_id", update = true)
	private String currentWorkflowTaskId;

	@Source(name = "initial_underwriter")
	private String initialUnderwriterIMSUser;

	@Target(name = "initial_underwriter", update = true)
	private Integer initialUnderwriter;

	@Source(name = "sla_clock_end_time")
	@Target(name = "sla_clock_end_time", update = true)
	private Timestamp slaClockEndTime;

	@Source(name = "previous_application_decision_code")
	@Target(name = "previous_application_decision_code", update = true)
	private String previousApplicationDecisionCode;

	@Source(name = "is_qa_review_recommended")
	@Target(name = "is_qa_review_recommended", update = true)
	private Integer qaReviewRecommended = 0;

	@Source(name = "qa_review_recommended_reason_code")
	@Target(name = "qa_review_recommended_reason_code", update = true)
	private String qaReviewRecommendedReasonCode;

	@Source(name = "qa_review_status_code")
	@Target(name = "qa_review_status_code", update = true)
	private String qaReviewStatusCode;

	@Source(name = "qa_review_recommended_date")
	@Target(name = "qa_review_recommended_date", update = true)
	private Timestamp qaReviewRecommendedDate;

	@Source(name = "qa_review_recommended_by")
	@Target(name = "qa_review_recommended_by", update = true)
	private Integer qaReviewRecommendedBy;

	@Source(name = "sla_timer_trigger_code")
	@Target(name = "sla_timer_trigger_code", update = true)
	private String slaTimerTriggerCode;



	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Timestamp getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Integer getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Integer submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubmittedByIMSUser() {
		return submittedByIMSUser;
	}

	public void setSubmittedByIMSUser(final String submittedByIMSUser) {
		this.submittedByIMSUser = submittedByIMSUser;
	}

	public String getSubmissionTypeCode() {
		return submissionTypeCode;
	}

	public void setSubmissionTypeCode(String submissionTypeCode) {
		this.submissionTypeCode = submissionTypeCode;
	}

	public String getInsurancePaidTypeCode() {
		return insurancePaidTypeCode;
	}

	public void setInsurancePaidTypeCode(String insurancePaidTypeCode) {
		this.insurancePaidTypeCode = insurancePaidTypeCode;
	}

	public String getPremiumPlanTypeCode() {
		return premiumPlanTypeCode;
	}

	public void setPremiumPlanTypeCode(String premiumPlanTypeCode) {
		this.premiumPlanTypeCode = premiumPlanTypeCode;
	}

	public BigDecimal getCoveragePercentage() {
		return coveragePercentage;
	}

	public void setCoveragePercentage(BigDecimal coveragePercentage) {
		this.coveragePercentage = coveragePercentage;
	}

	public String getRefundTypeCode() {
		return refundTypeCode;
	}

	public void setRefundTypeCode(String refundTypeCode) {
		this.refundTypeCode = refundTypeCode;
	}

	public String getRenewalTypeCode() {
		return renewalTypeCode;
	}

	public void setRenewalTypeCode(String renewalTypeCode) {
		this.renewalTypeCode = renewalTypeCode;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final Integer createdBy) {
		if(createdBy != null) {
			this.createdBy = createdBy;
		}
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		if(created != null) {
			this.created = created;
		}
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreationChannel() {
		return creationChannel;
	}

	public void setCreationChannel(String creationChannel) {
		this.creationChannel = creationChannel;
	}

	public String getWorkflowStatusCode() {
		return workflowStatusCode;
	}

	public void setWorkflowStatusCode(String workflowStatusCode) {
		this.workflowStatusCode = workflowStatusCode;
	}

	public Timestamp getWorkflowStatusUpdatedDate() {
		return workflowStatusUpdatedDate;
	}

	public void setWorkflowStatusUpdatedDate(Timestamp workflowStatusUpdatedDate) {
		this.workflowStatusUpdatedDate = workflowStatusUpdatedDate;
	}

	public Integer getLastEditedBy() {
		return lastEditedBy;
	}

	public void setLastEditedBy(Integer lastEditedBy) {
		this.lastEditedBy = lastEditedBy;
	}

	public Timestamp getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Timestamp lastEdited) {
		this.lastEdited = lastEdited;
	}

	public Integer getInternalUserLockedBy() {
		return internalUserLockedBy;
	}

	public void setInternalUserLockedBy(Integer internalUserLockedBy) {
		this.internalUserLockedBy = internalUserLockedBy;
	}

	public Timestamp getInternalUserLockedDatetime() {
		return internalUserLockedDatetime;
	}

	public void setInternalUserLockedDatetime(
			Timestamp internalUserLockedDatetime) {
		this.internalUserLockedDatetime = internalUserLockedDatetime;
	}

	public Integer getExternalUserLockedBy() {
		return externalUserLockedBy;
	}

	public void setExternalUserLockedBy(Integer externalUserLockedBy) {
		this.externalUserLockedBy = externalUserLockedBy;
	}

	public Timestamp getExternalUserLockedDatetime() {
		return externalUserLockedDatetime;
	}

	public void setExternalUserLockedDatetime(
			Timestamp externalUserLockedDatetime) {
		this.externalUserLockedDatetime = externalUserLockedDatetime;
	}

	public Integer getRepricingRequired() {
		return repricingRequired;
	}

	public void setRepricingRequired(Integer repricingRequired) {
		this.repricingRequired = repricingRequired;
	}

	public Integer getCertificateDocumentGenerated() {
		return certificateDocumentGenerated;
	}

	public void setCertificateDocumentGenerated(
			Integer certificateDocumentGenerated) {
		this.certificateDocumentGenerated = certificateDocumentGenerated;
	}

	public Integer getNonPricingChangesPending() {
		return nonPricingChangesPending;
	}

	public void setNonPricingChangesPending(Integer nonPricingChangesPending) {
		this.nonPricingChangesPending = nonPricingChangesPending;
	}

	public String getPreviousWorkflowStatusCode() {
		return previousWorkflowStatusCode;
	}

	public void setPreviousWorkflowStatusCode(String previousWorkflowStatusCode) {
		this.previousWorkflowStatusCode = previousWorkflowStatusCode;
	}

	public Integer getWorkflowStatusUpdatedBy() {
		return workflowStatusUpdatedBy;
	}

	public void setWorkflowStatusUpdatedBy(Integer workflowStatusUpdatedBy) {
		this.workflowStatusUpdatedBy = workflowStatusUpdatedBy;
	}

	public String getWorkflowTaskCode() {
		return workflowTaskCode;
	}

	public void setWorkflowTaskCode(String workflowTaskCode) {
		this.workflowTaskCode = workflowTaskCode;
	}

	public String getApplicationDecisionCode() {
		return applicationDecisionCode;
	}

	public void setApplicationDecisionCode(String applicationDecisionCode) {
		this.applicationDecisionCode = applicationDecisionCode;
	}

	public Integer getDeclineReasonNumOfUnits() {
		return declineReasonNumOfUnits;
	}

	public void setDeclineReasonNumOfUnits(Integer declineReasonNumOfUnits) {
		this.declineReasonNumOfUnits = declineReasonNumOfUnits;
	}

	public String getDeclineReasonOther1() {
		return declineReasonOther1;
	}

	public void setDeclineReasonOther1(String declineReasonOther1) {
		this.declineReasonOther1 = declineReasonOther1;
	}

	public String getDeclineReasonOther2() {
		return declineReasonOther2;
	}

	public void setDeclineReasonOther2(String declineReasonOther2) {
		this.declineReasonOther2 = declineReasonOther2;
	}

	public Integer getCoverLetterInd() {
		return coverLetterInd;
	}

	public void setCoverLetterInd(Integer coverLetterInd) {
		this.coverLetterInd = coverLetterInd;
	}

	public Integer getBestMiRate() {
		return bestMiRate;
	}

	public void setBestMiRate(Integer bestMiRate) {
		this.bestMiRate = bestMiRate;
	}

	public Integer getManagerReviewDeclineDecisionInd() {
		return managerReviewDeclineDecisionInd;
	}

	public void setManagerReviewDeclineDecisionInd(
			Integer managerReviewDeclineDecisionInd) {
		this.managerReviewDeclineDecisionInd = managerReviewDeclineDecisionInd;
	}

	public Integer getHoldForConditionDocsUploaded() {
		return holdForConditionDocsUploaded;
	}

	public void setHoldForConditionDocsUploaded(Integer holdForConditionDocsUploaded) {
		this.holdForConditionDocsUploaded = holdForConditionDocsUploaded;
	}

	public Integer getCreditInfoChanged() {
		return creditInfoChanged;
	}

	public void setCreditInfoChanged(Integer creditInfoChanged) {
		this.creditInfoChanged = creditInfoChanged;
	}

	public Integer getEscalatedBy() {
		return escalatedBy;
	}

	public void setEscalatedBy(Integer escalatedBy) {
		this.escalatedBy = escalatedBy;
	}

	public Integer getFcraDocumentGenerated() {
		return fcraDocumentGenerated;
	}

	public void setFcraDocumentGenerated(Integer fcraDocumentGenerated) {
		this.fcraDocumentGenerated = fcraDocumentGenerated;
	}

	public Timestamp getResubmissionDate() {
		return resubmissionDate;
	}

	public void setResubmissionDate(Timestamp resubmissionDate) {
		this.resubmissionDate = resubmissionDate;
	}

	public Integer getAdvancedToUnderwritingBy() {
		return advancedToUnderwritingBy;
	}

	public void setAdvancedToUnderwritingBy(Integer advancedToUnderwritingBy) {
		this.advancedToUnderwritingBy = advancedToUnderwritingBy;
	}

	public String getDecisionLetterEmailIds() {
		return decisionLetterEmailIds;
	}

	public void setDecisionLetterEmailIds(String decisionLetterEmailIds) {
		this.decisionLetterEmailIds = decisionLetterEmailIds;
	}

	public Integer getEmailDecisionLetterInd() {
		return emailDecisionLetterInd;
	}

	public void setEmailDecisionLetterInd(Integer emailDecisionLetterInd) {
		this.emailDecisionLetterInd = emailDecisionLetterInd;
	}

	public Timestamp getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(Timestamp decisionDate) {
		this.decisionDate = decisionDate;
	}

	public Integer getDecisionBy() {
		return decisionBy;
	}

	public void setDecisionBy(Integer decisionBy) {
		this.decisionBy = decisionBy;
	}

	public Timestamp getSlaClockStartTime() {
		return slaClockStartTime;
	}

	public void setSlaClockStartTime(Timestamp slaClockStartTime) {
		this.slaClockStartTime = slaClockStartTime;
	}

	public Integer getRushIndicator() {
		return rushIndicator;
	}

	public void setRushIndicator(Integer rushIndicator) {
		this.rushIndicator = rushIndicator;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDelegatedLastActionCode() {
		return delegatedLastActionCode;
	}

	public void setDelegatedLastActionCode(String delegatedLastActionCode) {
		this.delegatedLastActionCode = delegatedLastActionCode;
	}

	public String getCurrentWorkflowTaskId() {
		return currentWorkflowTaskId;
	}

	public void setCurrentWorkflowTaskId(String currentWorkflowTaskId) {
		this.currentWorkflowTaskId = currentWorkflowTaskId;
	}

	public Integer getInitialUnderwriter() {
		return initialUnderwriter;
	}

	public void setInitialUnderwriter(Integer initialUnderwriter) {
		this.initialUnderwriter = initialUnderwriter;
	}

	public Timestamp getSlaClockEndTime() {
		return slaClockEndTime;
	}

	public void setSlaClockEndTime(Timestamp slaClockEndTime) {
		this.slaClockEndTime = slaClockEndTime;
	}

	public String getPreviousApplicationDecisionCode() {
		return previousApplicationDecisionCode;
	}

	public void setPreviousApplicationDecisionCode(
			String previousApplicationDecisionCode) {
		this.previousApplicationDecisionCode = previousApplicationDecisionCode;
	}

	public Integer getQaReviewRecommended() {
		return qaReviewRecommended;
	}

	public void setQaReviewRecommended(Integer qaReviewRecommended) {
		this.qaReviewRecommended = qaReviewRecommended;
	}

	public String getQaReviewRecommendedReasonCode() {
		return qaReviewRecommendedReasonCode;
	}

	public void setQaReviewRecommendedReasonCode(
			String qaReviewRecommendedReasonCode) {
		this.qaReviewRecommendedReasonCode = qaReviewRecommendedReasonCode;
	}

	public String getQaReviewStatusCode() {
		return qaReviewStatusCode;
	}

	public void setQaReviewStatusCode(String qaReviewStatusCode) {
		this.qaReviewStatusCode = qaReviewStatusCode;
	}

	public Timestamp getQaReviewRecommendedDate() {
		return qaReviewRecommendedDate;
	}

	public void setQaReviewRecommendedDate(Timestamp qaReviewRecommendedDate) {
		this.qaReviewRecommendedDate = qaReviewRecommendedDate;
	}

	public Integer getQaReviewRecommendedBy() {
		return qaReviewRecommendedBy;
	}

	public void setQaReviewRecommendedBy(Integer qaReviewRecommendedBy) {
		this.qaReviewRecommendedBy = qaReviewRecommendedBy;
	}

	public String getSlaTimerTriggerCode() {
		return slaTimerTriggerCode;
	}

	public void setSlaTimerTriggerCode(String slaTimerTriggerCode) {
		this.slaTimerTriggerCode = slaTimerTriggerCode;
	}

	public String getInitialUnderwriterIMSUser() {
		return initialUnderwriterIMSUser;
	}

	public void setInitialUnderwriterIMSUser(final String initialUnderwriterIMSUser) {
		this.initialUnderwriterIMSUser = initialUnderwriterIMSUser;
	}

	public String getDecisionByIMSUser() {
		return decisionByIMSUser;
	}

	public void setDecisionByIMSUser(final String decisionByIMSUser) {
		this.decisionByIMSUser = decisionByIMSUser;
	}

	public String getCreatedByIMSUser() {
		return createdByIMSUser;
	}

	public void setCreatedByIMSUser(final String createdByIMSUser) {
		this.createdByIMSUser = createdByIMSUser;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Application))
			return false;

		final Application that = (Application) o;

		if (certificateNumber != null ? !certificateNumber
				.equals(that.certificateNumber)
				: that.certificateNumber != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return certificateNumber != null ? certificateNumber.hashCode() : 0;
	}

}
