package com.sparg.java.dm.strategy.pull;

import com.sparg.java.dm.context.MigrationContext;
import com.sparg.java.dm.datasource.DataSource;
import com.sparg.java.dm.entity.SourceFieldMapper;

import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 11/18/2014
 * Time: 2:37 PM
 */
public class PullStrategy extends AbstractPullStrategy {

    private MigrationContext context;
    private Set<Class<?>> entities;

    public PullStrategy(DataSource source) {
        super(source);
        context = MigrationContext.getInstance();
        entities = MigrationContext.getInstance().getEntities();
    }

    @Override
    public void execute() {
        for(Class<?> entity : entities) {
            Set<?> entityRows = pullEntityRows(entity, new SourceFieldMapper(entityManagerFactory.getInstance(entity)));
            context.putEntityRows(entity, entityRows);
        }
    }
}
