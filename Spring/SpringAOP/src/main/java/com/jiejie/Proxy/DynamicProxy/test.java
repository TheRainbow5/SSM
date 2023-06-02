package com.jiejie.Proxy.DynamicProxy;

/**
 * @ClassName: test
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/9 22:25
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        A a=new B();
        a.hi();
        System.out.println(a.getClass());
    }
}
interface A{
    public void hi();
}
class B implements  A{
    private String name="jiejie";
    @Override
    public void hi() {
        System.out.println("hello world");
    }
}
