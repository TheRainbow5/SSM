package com.jiejie.Autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: testAutowire
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/6 21:21
 * @Version: 1.0
 */
public class testAutowire {
    public static void main(String[] args) {
        /*通过IOC获取对象*/
        System.out.println("=====通过IOC获取对象=====");
        //加载配置文件-传入配置文件的文件名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        //获取对象
    }
}
