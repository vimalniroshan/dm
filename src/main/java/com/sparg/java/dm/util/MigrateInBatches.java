package com.sparg.java.dm.util;

import java.util.Set;

public abstract class MigrateInBatches<T> {
    protected int batchSize;

    public void migrate() {
        int index = 0;

        while(true){
            Set<T> records = pullRecordsForBatch(index, batchSize);
            if(records == null || records.isEmpty()) {
                break;
            } else {
                migrateRecords(records);
                index+=records.size();
            }
        }
    }

    public abstract Set<T> pullRecordsForBatch(int fromIndex, int batchSize);
    public abstract void migrateRecords(Set<T> records);
}