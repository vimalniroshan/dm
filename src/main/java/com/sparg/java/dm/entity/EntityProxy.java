package com.sparg.java.dm.entity;

import com.sparg.java.dm.model.ETLFlag;
import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

/**
 * @author: vimal.sengoden
 * Date: 11/19/2014
 * Time: 2:44 PM
 */
public class EntityProxy implements MethodHandler {

    private ETLFlag etlFlag = ETLFlag.INSERT;

    @Override
    public Object invoke(final Object self,
                         final Method thisMethod,
                         final Method proceed,
                         final Object[] args) throws Throwable {
        return proceed.invoke(self, args);
    }

    public ETLFlag getEtlFlag() {
        return etlFlag;
    }

    public void setEtlFlag(final ETLFlag etlFlag) {
        this.etlFlag = etlFlag;
    }
}
