package com.jiejie.Proxy.Demo1.DiyLog;

/**
 * @ClassName: DiyPointCut
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/11 21:06
 * @Version: 1.0
 */
public class DiyPointCut {
    public void before(){
        System.out.println("=====方法执行前=====");
    }
    public void after(){
        System.out.println("=====方法执行后=====");
    }
}
