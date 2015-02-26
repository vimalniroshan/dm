package com.sparg.java.dm.context;

import com.sparg.java.dm.entity.EntityManagerFactory;
import com.sparg.java.dm.util.Utils;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author: vimal.sengoden
 * Date: 11/13/2014
 * Time: 2:56 PM
 */
public class MigrationContext {

    private static MigrationContext context;

    private Properties config;
    private Map<Class<?>, Set<?>> entitiesAndRows = new LinkedHashMap<Class<?>, Set<?>>();
    private EntityManagerFactory entityManagerFactory;

    private MigrationContext(Properties config) {
        this.config = config;
        init();
    }

    public static synchronized MigrationContext getInstance(final Properties config) {
        if(context == null) {
            try {
                context = new MigrationContext(config);
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to initialize MigrationContext with provided config", e);
            }
        }

        return context;
    }

    public static MigrationContext getInstance() {
        if(context == null) {
            throw new IllegalStateException("MigrationContext never initialized");
        }

        return context;
    }

    protected void init() {
        try {
            String factoryClassName = config.getProperty("dm.entity.manager.factory.class"
                    , "com.sparg.java.dm.entity.EntityManagerFactory");
            Class<EntityManagerFactory> factoryClass = Utils.loadClass(factoryClassName);
            this.entityManagerFactory = factoryClass.newInstance();

            String[] domainClasses = config.getProperty("domainClasses").split(",");
            for(String className : domainClasses) {
                try {
                    Class<?> clazz = Utils.loadClass(StringUtils.trim(className));
                    entitiesAndRows.put(clazz, null);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(String.format("Unable to load class %s", className), e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception while initializing MigrationContext", e);
        }
    }

    public Set<Class<?>> getEntities() {
        return entitiesAndRows.keySet();
    }

    public void putEntityRows(final Class<?> clazz, final Set<?> rows) {
        entitiesAndRows.put(clazz, rows);
    }

    public Set<?> getEntityRows(final Class<?> clazz) {
        return entitiesAndRows.get(clazz);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
