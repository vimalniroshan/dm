package com.sparg.java.dm.util;

/**
 * @author: vimal.sengoden
 * Date: 11/13/2014
 * Time: 2:12 PM
 */
public class CollectionUtils {

    public static <T,K> T find(final Iterable<T> iterable, final Predicate<T, K> predicate, K id) {
        if(iterable != null && predicate != null) {
            for(T item : iterable) {
                if(predicate.evaluate(item, id)) {
                    return item;
                }
            }
        }

        return null;
    }
}
