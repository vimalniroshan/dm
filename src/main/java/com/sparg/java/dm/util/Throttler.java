package com.sparg.java.dm.util;

import java.util.List;

/**
 * @author: vimal.sengoden
 * Date: 4/26/14
 * Time: 5:23 PM
 */
public abstract class Throttler<T> {
    protected int batchSize;
    protected List<T> inputs;

    public Throttler(int batchSize, List<T> inputs) {
        if(batchSize <= 0) {
            this.batchSize = inputs.size();
        } else {
            this.batchSize = batchSize;
        }
        this.inputs = inputs;
    }

    public void execute() {
        int totalSize = inputs.size();
        for(int startIdx = 0, endIdx = batchSize; startIdx < totalSize; endIdx+=batchSize) {
            executeForInputs(inputs.subList(startIdx, Math.min(endIdx, totalSize)));
            startIdx = endIdx;
        }
    }

    public abstract void executeForInputs(List<T> inputs);
}
