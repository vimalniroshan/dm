package com.sparg.java.dm.entity;

import java.sql.ResultSet;
import java.util.Set;

/**
* @author: vimal.sengoden
* Date: 2/25/2015
* Time: 1:21 PM
*/
public class SourceFieldMapper<T> implements ResultSetToObjectMapper<T> {
    private EntityManager<T> entityManager;
    private Filter filter;
    private DuplicateHandler duplicateHandler;

    public SourceFieldMapper(final EntityManager<T> entityManager) {
        this.entityManager = entityManager;
    }

    public SourceFieldMapper(final EntityManager<T> entityManager, final Filter filter) {
        this.entityManager = entityManager;
        this.filter = filter;
    }

    public SourceFieldMapper(final EntityManager<T> entityManager, final DuplicateHandler duplicateHandler) {
        this.entityManager = entityManager;
        this.duplicateHandler = duplicateHandler;
    }

    public SourceFieldMapper(final EntityManager<T> entityManager, final Filter filter, final DuplicateHandler duplicateHandler) {
        this.entityManager = entityManager;
        this.filter = filter;
        this.duplicateHandler = duplicateHandler;
    }

    @Override
    public Set<T> toObjects(final ResultSet rs) throws Exception {
        return entityManager.resultSetToSource(rs, filter, duplicateHandler);
    }
}
