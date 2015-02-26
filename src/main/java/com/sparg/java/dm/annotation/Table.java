package com.sparg.java.dm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: vimal.sengoden
 * Date: 3/28/14
 * Time: 5:22 PM
 */

@Documented
@Retention(value= RUNTIME)
@java.lang.annotation.Target(value={TYPE})
public @interface Table {
    String name();
    String sourceQuery() default "";
    String sourceQueryFile() default "";
}
