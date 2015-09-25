package com.sparg.java.dm.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: vimal.sengoden
 * Date: 3/28/14
 * Time: 11:00 AM
 */

@Documented
@Retention(value = RUNTIME)
@java.lang.annotation.Target(value = {FIELD})
public @interface FK {
    Class reference() default Object.class;     //FK referring class (Java Class)

    String field() default "";        //FK field in the java class

    String targetQuery() default "";

}
