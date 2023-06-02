package com.jiejie.Proxy.Demo1.Log;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * @ClassName: log
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/11 11:22
 * @Version: 1.0
 */
public class log implements MethodBeforeAdvice {
    /**
     *
     * @param method：要执行的目标对象（房东）的方法
     * @param objects：参数
     * @param o：目标对象（房东）
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+"的"+method.getName()+"被执行了");
    }
}
