package com.sparg.java.dm.model;

import com.sparg.java.dm.annotation.PK;
import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.annotation.Target;
import com.sparg.java.dm.context.MigrationState;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: vimal.sengoden
 * Date: 4/16/14
 * Time: 3:15 PM
 */

@Table(name = "etl_batch")
public class ETLBatch {
    @PK
    @Target(name = "id")
    private Long id;
    @Target(name = "batch_start_time")
    private Timestamp startTime;
    @Target(name = "context")
    private String context;
    @Target(name = "state", update = true)
    private String stateString;
    @Target(name = "customer_numbers")
    private String customerNumbers;
    @Target(name = "batch_end_time", update = true)
    private Timestamp endTime;
    private MigrationState state;

    public ETLBatch() {
    }

    public ETLBatch(String context) {
        this.context = context;
        this.startTime = new Timestamp(new Date().getTime());
        this.setState(MigrationState.INITIALIZED);
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

    public void setStartTime(final Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getStateString() {
        return stateString;
    }

    public void setStateString(final String stateString) {
        this.state = MigrationState.valueOf(stateString);
        this.stateString = stateString;
    }

    public void setState(final MigrationState state) {
        this.state = state;
        this.stateString = state.name();
    }

    public MigrationState getState() {
        return state;
    }

    public String getCustomerNumbers() {
        return customerNumbers;
    }

    public void setCustomerNumbers(final String customerNumbers) {
        this.customerNumbers = customerNumbers;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(final Timestamp endTime) {
        this.endTime = endTime;
    }
}
