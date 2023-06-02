package com.jiejie.Proxy.StaticProxy;

/**
 * @ClassName: Client
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/9 20:42
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Host host=new Host();
        Proxy proxy = new Proxy(host);
        //房东的主要目的
        proxy.rent();
        //中介的其他操作
        proxy.seeHouse();
        proxy.fare();
    }
}
