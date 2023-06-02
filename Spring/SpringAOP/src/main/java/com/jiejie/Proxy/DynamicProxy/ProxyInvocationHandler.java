package com.jiejie.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: ProxyInvocationHandler
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/9 22:04
 * @Version: 1.0
 */
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object object;
    public void setRent(Object object){
        this.object=object;
    }
    /**
     * 生成代理对象类
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(),this);
    }
    /**
     * 处理代理实例，返回结果
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //动态代理的本质，就是使用反射机制实现
        seeHouse();
        Object invoke = method.invoke(object, objects); //执行接口中的方法
        fare();
        return invoke;
    }
    //中介的附属操作
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
