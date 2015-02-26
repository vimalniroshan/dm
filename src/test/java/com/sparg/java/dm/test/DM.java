package com.sparg.java.dm.test;

import com.sparg.java.dm.strategy.MigrationStrategy;
import com.sparg.java.dm.strategy.Strategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;

/**
 * @author: vimal.sengoden
 * Date: 11/13/2014
 * Time: 2:44 PM
 */
public class DM {

    private static final Logger log = LogManager.getLogger(DM.class);

    static {
        try {
            System.getProperties().load(
                    new FileReader(new File(Thread.currentThread()
                            .getContextClassLoader()
                            .getResource("dm.properties")
                            .toURI())));
        } catch (Exception e) {
            log.error("Exception while loading dm.properties", e);
        }
    }

    public static void main(String[] args) {
        log.info("################################### Migration Started ######################################");
        Strategy migrationStrategy = new MigrationStrategy(System.getProperties());
        migrationStrategy.execute();
        log.info("################################### Migration Completed ######################################");
    }

}
