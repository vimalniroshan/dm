package com.sparg.java.dm.strategy.push;

import com.sparg.java.dm.jdbc.DmJdbcTemplate;
import com.sparg.java.dm.entity.EntityUtils;
import com.sparg.java.dm.entity.ExecutionHandler;
import com.sparg.java.dm.model.ETLFlag;
import com.sparg.java.dm.strategy.Strategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 4/21/14
 * Time: 9:28 AM
 */
public abstract class AbstractPushStrategy implements Strategy {

    private static final Logger log = LogManager.getLogger(AbstractPushStrategy.class);

    protected DmJdbcTemplate target;

    protected AbstractPushStrategy(final DmJdbcTemplate target) {
        this.target = target;
    }

    protected void pushEntityRows(final Class<?> entity, final Set<?> entityRows) {

        Set<Object> inserts = new LinkedHashSet<Object>();
        Set<Object> updates = new LinkedHashSet<Object>();
        Set<Object> deletes = new LinkedHashSet<Object>();

        for(Object row : entityRows) {
            ETLFlag etlFlag = EntityUtils.getETLFlag(row);

            switch (etlFlag) {
                case INSERT:
                    inserts.add(row);
                    break;
                case UPDATE:
                    updates.add(row);
                    break;
                case DELETE:
                    deletes.add(row);
            }
        }

        insertEntityRows(entity, inserts, new CommonExecutionHandler(ETLFlag.INSERT));
        updateEntityRows(entity, updates, new CommonExecutionHandler(ETLFlag.UPDATE));
        deleteEntityRows(entity, deletes, new CommonExecutionHandler(ETLFlag.DELETE));
    }

    protected void insertEntityRows(final Class<?> entity, final Set<?> inserts, final ExecutionHandler executionHandler) {
        if(!inserts.isEmpty()) {
            int count = target.executeInserts(entity, inserts, executionHandler);
            log.debug("Inserted {} record of {} object", count, entity.getName());
        }
    }

    protected void updateEntityRows(final Class<?> entity, final Set<?> updates, final ExecutionHandler executionHandler) {
        if(!updates.isEmpty()) {
            int count = target.executeUpdates(entity, updates, executionHandler);
            log.debug("Updated {} record of {} object", count, entity.getName());
        }
    }

    protected void deleteEntityRows(final Class<?> entity, final Set<?> deletes, final ExecutionHandler executionHandler) {
        if(!deletes.isEmpty()) {
            int count = target.executeDeletes(entity, deletes, executionHandler);
            log.debug("Deleted {} record of {} object", count, entity.getName());
        }
    }

    public static class CommonExecutionHandler implements ExecutionHandler {
        private ETLFlag etlFlag;

        public CommonExecutionHandler(final ETLFlag etlFlag) {
            this.etlFlag = etlFlag;
        }

        @Override
        public void onError(final Object record, final Exception e) {
            log.error("Error {}-ing record '{}', Exception: {}", etlFlag, record, e);
        }
    }
}
