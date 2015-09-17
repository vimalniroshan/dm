package com.sparg.java.dm.strategy;

import com.sparg.java.dm.context.MigrationContext;
import com.sparg.java.dm.entity.EntityManagerFactory;
import com.sparg.java.dm.jdbc.DataSourceHandler;
import com.sparg.java.dm.jdbc.DmJdbcTemplate;
import com.sparg.java.dm.jdbc.DmJdbcTemplateImpl;
import com.sparg.java.dm.jdbc.JDBCUtil;
import com.sparg.java.dm.strategy.pull.PullStrategy;
import com.sparg.java.dm.strategy.push.PushStrategy;
import com.sparg.java.dm.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author: vimal.sengoden
 * Date: 11/13/2014
 * Time: 2:51 PM
 */
public class MigrationStrategy extends AbstractMigrationStrategy {

    private static final Logger log = LogManager.getLogger(MigrationStrategy.class);

    private DmJdbcTemplate source;
    private DmJdbcTemplate target;
    private PullStrategy pullStrategy;
    private List<Strategy> strategies = new ArrayList<Strategy>();
    private PushStrategy pushStrategy;

    public MigrationStrategy(final Properties config) {
        super(config);
    }

    @Override
    protected void init() {
        EntityManagerFactory entityManagerFactory = MigrationContext.getInstance().getEntityManagerFactory();

        source = new DmJdbcTemplateImpl(new DataSourceHandler() {
            @Override
            public Connection getConnection() {
                return JDBCUtil.getConnection(config.getProperty("source.db.url"), config.getProperty("source.db.username"), config.getProperty("source.db.password"));
            }

            @Override
            public void releaseConnection(final Connection connection) {
                JDBCUtil.closeConnection(connection);
            }
        }, entityManagerFactory);

        target = new DmJdbcTemplateImpl(new DataSourceHandler() {
            @Override
            public Connection getConnection() {
                return JDBCUtil.getConnection(config.getProperty("target.db.url"), config.getProperty("target.db.username"), config.getProperty("target.db.password"));
            }

            @Override
            public void releaseConnection(final Connection connection) {
                JDBCUtil.closeConnection(connection);
            }

        }, entityManagerFactory);

        pullStrategy = new PullStrategy(source);
        String[] strategies = config.getProperty("dm.strategies").split(",");
        for(String strategy : strategies) {
            try {
                Class<Strategy> strategyClass = Utils.loadClass(strategy);
                this.strategies.add(strategyClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(String.format("Unable to load/create instance of strategy class '%s'"), e);
            }
        }

        pushStrategy = new PushStrategy(target);
    }

    @Override
    protected void migrate() {
        pullStrategy.execute();
        for(Strategy strategy : strategies) {
            strategy.execute();
        }
        pushStrategy.execute();
    }
}
