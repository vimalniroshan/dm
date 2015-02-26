package com.sparg.java.dm.entity;

import com.sparg.java.dm.annotation.Table;
import com.sparg.java.dm.datasource.DataSource;
import com.sparg.java.dm.model.ETLFlag;
import javassist.util.proxy.ProxyObject;

/**
 * @author: vimal.sengoden
 * Date: 11/14/2014
 * Time: 11:42 PM
 */
public class EntityUtils {

    /**
     *
     * @param clazz
     * @return
     * @throws IllegalArgumentException
     */
    public static Table getTable(final Class<?> clazz) throws IllegalArgumentException{
        Table a = clazz.getAnnotation(Table.class);
        if(a == null) {
            throw new IllegalArgumentException("Class: " + clazz.getName() + " not annotated with @Table");
        }
        return a;
    }

    public static void setETLFlag(final Object row, ETLFlag etlFlag) {
        try {
            ((EntityProxy)((ProxyObject) row).getHandler()).setEtlFlag(etlFlag);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("This row object is not created through %s and cannot be checked for %s",
                    DataSource.class.getSimpleName(), ETLFlag.class.getSimpleName()), e);
        }
    }

    public static ETLFlag getETLFlag(final Object row) {
        try {
            return ((EntityProxy)((ProxyObject) row).getHandler()).getEtlFlag();
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("This row object is not created through %s and cannot be checked for %s",
                    DataSource.class.getSimpleName(), ETLFlag.class.getSimpleName()), e);
        }
    }

}
