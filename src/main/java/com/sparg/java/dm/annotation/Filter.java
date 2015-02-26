package com.sparg.java.dm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: vimal.sengoden
 * Date: 5/20/14
 * Time: 3:31 PM
 */

@Documented
@Retention(value= RUNTIME)
@java.lang.annotation.Target(value={FIELD})
public @interface Filter {
    String columnName() default "";
}
