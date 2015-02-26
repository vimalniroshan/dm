package com.sparg.java.dm.util;

/**
 * @author: vimal.sengoden
 * Date: 5/19/14
 * Time: 1:34 PM
 */
public interface Predicate<T, K> {
    public boolean evaluate(T t, K k);
}
