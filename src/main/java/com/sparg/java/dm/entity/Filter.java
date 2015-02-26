package com.sparg.java.dm.entity;

import java.sql.ResultSet;

/**
* @author: vimal.sengoden
* Date: 2/25/2015
* Time: 1:21 PM
*/
public interface Filter {
    public boolean evaluate(ResultSet rs) throws Exception;
}
