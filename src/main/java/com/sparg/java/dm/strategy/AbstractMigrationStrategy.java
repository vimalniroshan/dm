package com.sparg.java.dm.strategy;

import com.sparg.java.dm.context.MigrationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 * @author: vimal.sengoden
 * Date: 11/13/2014
 * Time: 2:52 PM
 */
public abstract class AbstractMigrationStrategy implements Strategy {

    private static final Logger log = LogManager.getLogger(AbstractMigrationStrategy.class);

    protected Properties config;
    protected MigrationContext migrationContext;

    protected AbstractMigrationStrategy(Properties config) {
        this.config = config;
        this.migrationContext = MigrationContext.getInstance(config);
    }

    public void execute() {
        try {
            init();
            migrate();
        } finally {
            close();
        }
    }

    protected void init() {}

    protected abstract void migrate();

    protected void close() {}
}
