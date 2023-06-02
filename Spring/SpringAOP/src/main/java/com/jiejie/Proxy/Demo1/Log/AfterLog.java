package com.jiejie.Proxy.Demo1.Log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName: AfterLog
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/11 11:24
 * @Version: 1.0
 */
public class AfterLog implements AfterReturningAdvice {
    /**
     * @param o：返回值
     * @param method：
     * @param objects
     * @param o1
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName()+"方法，返回结果="+o);
    }
}
