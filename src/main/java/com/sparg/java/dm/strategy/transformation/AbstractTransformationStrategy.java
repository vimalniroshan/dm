package com.sparg.java.dm.strategy.transformation;

import com.sparg.java.dm.context.MigrationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 4/22/14
 * Time: 5:57 PM
 */
public abstract class AbstractTransformationStrategy {

    private static final Logger log = LogManager.getLogger(AbstractTransformationStrategy.class);

    private MigrationContext context;
    private Set<Class<?>> entities;

    protected AbstractTransformationStrategy() {
        context = MigrationContext.getInstance();
        entities = MigrationContext.getInstance().getEntities();
    }

    protected void resolveForeignKeys() {

    }

}
