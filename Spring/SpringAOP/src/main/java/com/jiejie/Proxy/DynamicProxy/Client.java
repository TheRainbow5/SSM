package com.jiejie.Proxy.DynamicProxy;

/**
 * @ClassName: Client
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/9 22:07
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //房东
        Host host = new Host();
        //中介
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //通过调用程序处理来处理我们调用的接口对象
        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent)proxyInvocationHandler.getProxy();//生成代理对象
        proxy.rent();
    }
}
