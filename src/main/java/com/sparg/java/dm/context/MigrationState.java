package com.sparg.java.dm.context;

/**
* @author: vimal.sengoden
* Date: 4/21/14
* Time: 10:30 AM
*/
public enum MigrationState {
    INITIALIZED,
    PULL_COMPLETE,
    VALIDATION_COMPLETE,
    TRANSFORMATION_COMPLETE,
    PUSH_COMPLETE;
}
