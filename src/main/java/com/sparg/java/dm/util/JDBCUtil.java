package com.sparg.java.dm.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author: vimal.sengoden
 * Date: 2/18/14
 * Time: 11:13 AM
 */
public class JDBCUtil {

    private static final Logger log = LogManager.getLogger(JDBCUtil.class);

    /**
     * Returns a new connection based on the credentials and data source url passed.
     * @param url
     * @param userName
     * @param password
     * @return
     */
    public static Connection getConnection(String url, String userName, String password) {
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting the connection", e);
        }
    }

    public static void closeStatement(final Statement statement) {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            log.error("Exception while closing statement", e);
        }
    }

    public static void setStatementParams(final PreparedStatement statement, int paramIndex, final Object row, final List<? extends Field> fields) {
        for (int i = 0; i < fields.size(); i++, paramIndex++) {
            try {
                statement.setObject(paramIndex, PropertyUtils.getProperty(row, fields.get(i).getName()));
            } catch (Exception e) {
                log.error("Exception while setting query param values for " + fields.get(i).getName(), e);
                throw new RuntimeException("Exception while setting query param values for " + fields.get(i).getName(), e);
            }
        }
    }

    public static void updateGeneratedKey(final Object row, final Field autoGenField, final ResultSet generatedKeys) {
        if (autoGenField == null) {
            return;
        }

        try { //Expecting always only one generated key (PK) column per table
            if (!generatedKeys.next()) {
                throw new RuntimeException("Unable to get generated keys for records");
            }
            PropertyUtils.setProperty(row, autoGenField.getName(), generatedKeys.getObject("GENERATED_KEY"));
        } catch (Exception e) {
            log.error("Unable to set generated key to row: " + row + " generatedKey: " + generatedKeys, e);
            throw new RuntimeException("Unable to set generated key to row: " + row + " generatedKey: " + generatedKeys, e);
        }
    }

}
