package com.sparg.java.dm.strategy;

import com.sparg.java.dm.context.MigrationContext;
import com.sparg.java.dm.datasource.DataSource;
import com.sparg.java.dm.datasource.DataSourceImpl;
import com.sparg.java.dm.entity.EntityManagerFactory;
import com.sparg.java.dm.strategy.pull.PullStrategy;
import com.sparg.java.dm.strategy.push.PushStrategy;
import com.sparg.java.dm.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private DataSource source;
    private DataSource target;
    private PullStrategy pullStrategy;
    private List<Strategy> strategies = new ArrayList<Strategy>();
    private PushStrategy pushStrategy;

    public MigrationStrategy(final Properties config) {
        super(config);
    }

    @Override
    protected void init() {
        EntityManagerFactory entityManagerFactory = MigrationContext.getInstance().getEntityManagerFactory();
        source = new DataSourceImpl(config.getProperty("source.db.username"),
                 config.getProperty("source.db.password"),
                 config.getProperty("source.db.url"), entityManagerFactory);

        target = new DataSourceImpl(config.getProperty("target.db.username"),
                 config.getProperty("target.db.password"),
                 config.getProperty("target.db.url"), entityManagerFactory);

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

    @Override
    protected void close() {
        if(source != null) {
            source.close();
        }
        if(target != null) {
            target.close();
        }
    }
}
