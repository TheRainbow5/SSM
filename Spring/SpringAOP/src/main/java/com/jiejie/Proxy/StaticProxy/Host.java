package com.jiejie.Proxy.StaticProxy;

/**
 * @ClassName: Host
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/9 20:41
 * @Version: 1.0
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要租房子");
    }
}
