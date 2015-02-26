package com.sparg.java.dm.entity;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author: vimal.sengoden
 * Date: 11/21/2014
 * Time: 3:16 PM
 */
public class EntityManagerFactory {

    private Map<Class<?>, EntityManager<?>> entityManagers = new WeakHashMap<Class<?>, EntityManager<?>>();

    public <T> EntityManager<T> getInstance(Class<T> entity) {

        EntityManager<T> entityManager = (EntityManager<T>) entityManagers.get(entity);
        if(entityManager == null) {
            entityManager = new EntityManagerImpl<T>(entity);
            entityManagers.put(entity, entityManager);
        }

        return entityManager;
    }
}
