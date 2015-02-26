package com.sparg.java.dm.datasource;

import com.sparg.java.dm.entity.EntityManager;
import com.sparg.java.dm.entity.EntityManagerFactory;
import com.sparg.java.dm.entity.ExecutionHandler;
import com.sparg.java.dm.entity.ResultSetToObjectMapper;
import com.sparg.java.dm.util.JDBCUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


/**
 * @author: vimal.sengoden
 * Date: 2/19/14
 * Time: 11:17 AM
 */
public class DataSourceImpl implements DataSource {

    private static final Logger log = LogManager.getLogger(DataSourceImpl.class);
    private static final Logger queryLog = LogManager.getLogger("query.log");

    protected Connection connection;
    protected EntityManagerFactory entityManagerFactory;

    public DataSourceImpl(final String userName, final String password, final String url, EntityManagerFactory entityManagerFactory) {
        this.connection = JDBCUtil.getConnection(url, userName, password);
        this.entityManagerFactory = entityManagerFactory;
    }

    public <T> Set<T> executeQuery(String query, ResultSetToObjectMapper<T> resultSetToObjectMapper) {

        if(query == null || resultSetToObjectMapper == null) {
            throw new IllegalArgumentException("query and resultSetToObjectMapper cannot be null");
        }

        Statement statement = null;
        try {
            statement = connection.createStatement();
            queryLog.info(query);
            ResultSet rs = statement.executeQuery(query);
            return resultSetToObjectMapper.toObjects(rs);
        } catch (SQLException e) {
            log.error("Exception while executing query :\n" + query, e);
            throw new RuntimeException("Error while executing the query:\n" + query, e);
        } catch (Exception e) {
            log.error("Exception while processing results :\n" + query, e);
            throw new RuntimeException("Exception while processing results :\n" + query, e);
        } finally {
            JDBCUtil.closeStatement(statement);
        }
    }

    @Override
    public int executeInserts(final Class<?> entity, final Set<?> rows, final ExecutionHandler executionHandler) {
        int count = 0;

        if(entity == null || rows == null) {
            throw new IllegalArgumentException("'entity' and 'rows' cannot be null");
        } else if (CollectionUtils.isEmpty(rows)) {
            return count;
        }

        EntityManager<?> entityManager = entityManagerFactory.getInstance(entity);

        String insertQuery = entityManager.createInsertQuery();
        queryLog.info(insertQuery);

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            log.error("Exception while preparing insert query statement for " + insertQuery, e);
            throw new RuntimeException("Exception while preparing insert query statement for " + insertQuery, e);
        }

        try {
            for (Object row : rows) {
                try {
                    JDBCUtil.setStatementParams(statement, 1, row, entityManager.getTargetFields());
                    queryLog.info(statement);
                    statement.executeUpdate();

                    if(entityManager.isPkAutoGenerated()) {
                        JDBCUtil.updateGeneratedKey(row, entityManager.getPrimaryKey(), statement.getGeneratedKeys());
                    }
                    count++;
                } catch (Exception e) {
                    String errorMsg = String.format("Exception executing insert query %s OR setting autoGen Key", statement);
                    log.error(errorMsg, e);
                    if (executionHandler != null) {
                        executionHandler.onError(row, e);
                    } else {
                        throw new RuntimeException(errorMsg, e);
                    }
                }
            }
        } finally {
            JDBCUtil.closeStatement(statement);
        }

        return count;
    }

    @Override
    public int executeUpdates(final Class<?> entity, final Set<?> rows, final ExecutionHandler executionHandler) {
        int count = 0;

        if(entity == null || rows == null) {
            throw new IllegalArgumentException("'entity' and 'rows' cannot be null");
        } else if (CollectionUtils.isEmpty(rows)) {
            return count;
        }

        EntityManager<?> entityManager = entityManagerFactory.getInstance(entity);

        if (CollectionUtils.isEmpty(entityManager.getUpdateTargetFields())) {
            log.info("No fields to update (no fields marked as 'update=true') in entity class " + entity);
            return count;
        }

        String updateQuery = entityManager.createUpdateQuery();
        queryLog.info(updateQuery);

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(updateQuery);
        } catch (SQLException e) {
            log.error("Exception while preparing update query statement for " + updateQuery, e);
            throw new RuntimeException("Exception while preparing update query statement for " + updateQuery, e);
        }

        try {
            for (Object row : rows) {
                try {
                    List<Field> fields = new ArrayList<Field>();
                    fields.addAll(entityManager.getUpdateTargetFields());
                    fields.add(entityManager.getPrimaryKey());

                    JDBCUtil.setStatementParams(statement, 1, row, fields);
                    queryLog.info(statement);

                    statement.executeUpdate();
                    count++;
                } catch (Exception e) {
                    String errorMsg = String.format("Exception executing update %s query", statement);
                    log.error(errorMsg, e);
                    if (executionHandler != null) {
                        executionHandler.onError(row, e);
                    } else {
                        throw new RuntimeException(errorMsg, e);
                    }
                }
            }
        } finally {
            JDBCUtil.closeStatement(statement);
        }

        return count;
    }

    @Override
    public int executeDeletes(final Class<?> entity, final Set<?> rows, final ExecutionHandler executionHandler) {
        int count = 0;

        if(entity == null || rows == null) {
            throw new IllegalArgumentException("'entity' and 'rows' cannot be null");
        } else if (CollectionUtils.isEmpty(rows)) {
            return count;
        }

        EntityManager<?> entityManager = entityManagerFactory.getInstance(entity);

        String deleteQuery = entityManager.createDeleteQuery();
        queryLog.info(deleteQuery);

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deleteQuery);
        } catch (SQLException e) {
            log.error("Exception while preparing delete query statement for " + deleteQuery, e);
            throw new RuntimeException("Exception while preparing delete query statement for " + deleteQuery, e);
        }

        try {
            for (Object row : rows) {
                try {
                    JDBCUtil.setStatementParams(statement, 1, row, Arrays.asList(entityManager.getPrimaryKey()));
                    queryLog.info(statement);

                    statement.executeUpdate();
                    count++;
                } catch (Exception e) {
                    String errorMsg = String.format("Exception executing delete query statement %s", statement);
                    log.error(errorMsg, e);
                    if (executionHandler != null) {
                        executionHandler.onError(row, e);
                    } else {
                        throw new RuntimeException(errorMsg, e);
                    }
                }
            }
        } finally {
            JDBCUtil.closeStatement(statement);
        }

        return count;
    }

    public void close() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            log.error("Exception while closing connection", e);
        }
    }
}
