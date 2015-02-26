package com.sparg.java.dm.strategy.pull;

import com.sparg.java.dm.context.MigrationContext;
import com.sparg.java.dm.datasource.DataSource;
import com.sparg.java.dm.entity.EntityManager;
import com.sparg.java.dm.entity.EntityManagerFactory;
import com.sparg.java.dm.entity.ResultSetToObjectMapper;
import com.sparg.java.dm.strategy.Strategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 4/18/14
 * Time: 4:41 PM
 */
public abstract class AbstractPullStrategy implements Strategy {

    private static final Logger log = LogManager.getLogger(AbstractPullStrategy.class);

    protected DataSource source;
    protected EntityManagerFactory entityManagerFactory;

    protected AbstractPullStrategy(final DataSource source) {
        this.source = source;
        this.entityManagerFactory = MigrationContext.getInstance().getEntityManagerFactory();
    }

    protected <T> Set<T> pullEntityRows(Class<T> entity) {
        final EntityManager entityManager = entityManagerFactory.getInstance(entity);
        return source.executeQuery(entityManager.getSourceQuery(), new ResultSetToObjectMapper<T>() {
            @Override
            public Set<T> toObjects(final ResultSet rs) throws Exception {
                return entityManager.resultSetToSource(rs);
            }
        });
    }

    protected <T> Set<T> pullEntityRows(Class<T> entity, ResultSetToObjectMapper<T> resultSetToObjectMapper) {
        return source.executeQuery(entityManagerFactory.getInstance(entity).getSourceQuery(), resultSetToObjectMapper);
    }

}
