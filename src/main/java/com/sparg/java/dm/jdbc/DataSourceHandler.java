package com.sparg.java.dm.jdbc;

import java.sql.Connection;

/**
 * @author: vimal.sengoden
 * Date: 9/15/2015
 * Time: 4:53 PM
 */
public interface DataSourceHandler {

    public Connection getConnection();

    public void releaseConnection(Connection connection);

}
