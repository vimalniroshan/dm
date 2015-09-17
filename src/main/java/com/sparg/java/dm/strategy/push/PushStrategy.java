package com.sparg.java.dm.strategy.push;

import com.sparg.java.dm.context.MigrationContext;
import com.sparg.java.dm.jdbc.DmJdbcTemplate;
import com.sparg.java.dm.strategy.Strategy;

import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 11/13/2014
 * Time: 5:58 PM
 */
public class PushStrategy extends  AbstractPushStrategy implements Strategy {

    private MigrationContext context;
    private Set<Class<?>> entities;

    public PushStrategy(DmJdbcTemplate target) {
        super(target);
        context = MigrationContext.getInstance();
        entities = MigrationContext.getInstance().getEntities();
    }


    @Override
    public void execute() {
        for(Class<?> entity : entities) {
            Set<?> entityRows = context.getEntityRows(entity);
            pushEntityRows(entity, entityRows);
        }
    }

}
