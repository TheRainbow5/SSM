package com.jiejie.Proxy.Demo1.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @ClassName: AnnotationPointCut
 * @Author: jiejie
 * @Description: 注解形式来实现AOP
 * @Date: 2023/5/11 21:35
 * @Version: 1.0
 */

@Aspect  //切面
public class AnnotationPointCut {
    @Before("execution(* com.jiejie.Proxy.Demo1.Service.UserServiceImpl.*(..))")  //切入点
    public void before(){
        System.out.println("=====方法执行前=====");
    }
    @After("execution(* com.jiejie.Proxy.Demo1.Service.UserServiceImpl.*(..))") //切入点
    public void after(){
        System.out.println("=====方法执行后=====");
    }
    //在环绕增强中，可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.jiejie.Proxy.Demo1.Service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("===环绕前===");
        Object proceed = jp.proceed();
        System.out.println("==环绕后===");
    }
}
