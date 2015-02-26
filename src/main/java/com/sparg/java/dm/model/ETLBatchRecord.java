package com.sparg.java.dm.model;

import com.google.gson.Gson;
import com.sparg.java.dm.annotation.PK;
import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.annotation.Target;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: vimal.sengoden
 * Date: 4/16/14
 * Time: 3:37 PM
 */
@Table(name = "etl_batch_record")
public class ETLBatchRecord {
	private static final Gson gson = new Gson();

	public static final String NO_ASSOCIATED_PARENT_RECORD = "No associated parent record";
	public static final String NO_ASSOCIATED_CHILD_RECORD = "No associated child record";
	public static final String INVALID_CHILD_RECORD = "Invalid child record";
	public static final String NO_FK_REFERENCE = "No FK[%s] reference record found";
	public static final String EMPTY_RECORD = "Expected values is empty";
	public static final String RECORD_UPDATED_BY_AXIS_S_USER = "Record updated by Axis-S User";
	public static final String INVALID_VALUE = "Invalid value for column %s";
	public static final String LOAN_AMOUNT_GT_417K_2UNITS = "Loan amount is > 417000 and 2 units";
	public static final String MISMATCH_VALUES = "Values mismatch between source and calculated";

	@PK
	@Target(name = "id")
	private Long id;
	@Target(name = "etl_batch_id")
	private Long batchId;
	@Target(name = "timestamp")
	private Timestamp timestamp;
	@Target(name = "entity")
	private String entity;
	@Target(name = "etl_flag")
	private String entityEtlFlag;
	@Target(name = "entity_bk")
	private String entityBk;
	@Target(name = "entity_pk")
	private String entityPk;
	@Target(name = "record")
	private String record;
	@Target(name = "error")
	private String error;
	@Target(name = "error_details")
	private String errorDetails;

	public ETLBatchRecord(Object row, ETLFlag etlFlag, String error, String errorDetails) {
		timestamp = new Timestamp(new Date().getTime());
		//batchId = MigrationContext.getEtlBatch().getId();
		entity = row.getClass().getName();
		entityEtlFlag = etlFlag.toString();
		//entityBk = row.toBKString();
		//entityPk = String.valueOf(row.getPrimaryKey());
		record = gson.toJson(row);
		this.error = error;
		this.errorDetails = errorDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(final Long batchId) {
		this.batchId = batchId;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(final String entity) {
		this.entity = entity;
	}

	public String getEntityEtlFlag() {
		return entityEtlFlag;
	}

	public void setEntityEtlFlag(final String etlFlag) {
		entityEtlFlag = etlFlag;
	}

	public String getEntityBk() {
		return entityBk;
	}

	public void setEntityBk(final String entityBk) {
		this.entityBk = entityBk;
	}

	public String getEntityPk() {
		return entityPk;
	}

	public void setEntityPk(final String entityPk) {
		this.entityPk = entityPk;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(final String record) {
		this.record = record;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(final String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
