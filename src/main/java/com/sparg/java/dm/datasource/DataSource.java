package com.sparg.java.dm.datasource;

import com.sparg.java.dm.entity.ExecutionHandler;
import com.sparg.java.dm.entity.ResultSetToObjectMapper;

import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 11/14/2014
 * Time: 11:34 PM
 */
public interface DataSource {

    public <T> Set<T> executeQuery(String query, ResultSetToObjectMapper<T> resultSetToObjectMapper);

    public int executeInserts(Class<?> entity, Set<?> rows, ExecutionHandler executionHandler);

    public int executeUpdates(Class<?> entity, Set<?> rows, ExecutionHandler executionHandler);

    public int executeDeletes(Class<?> entity, Set<?> rows, ExecutionHandler executionHandler);

    public void close();
}
