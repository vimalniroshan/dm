package com.sparg.java.dm.model;

import com.sparg.java.dm.annotation.PK;
import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.annotation.Target;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: vimal.sengoden
 * Date: 4/16/14
 * Time: 3:30 PM
 */

@Table(name = "etl_batch_entity")
public class ETLBatchEntity {

    @PK
    @Target(name = "id")
    private Long id;
    @Target(name = "etl_batch_id")
    private Long batchId;
    @Target(name = "timestamp")
    private Timestamp timestamp;
    @Target(name = "entity")
    private String entity;
    @Target(name = "message")
    private String message;

    public ETLBatchEntity(Class entity, String message) {
        this.timestamp = new Timestamp(new Date().getTime());
        //this.batchId = AbstractMigrationContext.getInstance().getEtlBatch().getId();
        this.entity = entity.getName();
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
