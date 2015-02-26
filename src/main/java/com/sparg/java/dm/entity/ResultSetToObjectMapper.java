package com.sparg.java.dm.entity;

import java.sql.ResultSet;
import java.util.Set;

/**
* @author: vimal.sengoden
* Date: 11/18/2014
* Time: 11:37 AM
*/
public interface ResultSetToObjectMapper<T> {
    public Set<T> toObjects(ResultSet rs) throws Exception;
}
