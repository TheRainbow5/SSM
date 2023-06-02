package com.jiejie.Annotation.Dao.impl;

import com.jiejie.Annotation.Dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("dao")  //持久层
public class UserDaoImpl implements UserDao {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.macActive}")
    private int maxActive;
    public void testValueAnnotation() {
        System.out.println("driverClassName：" + driverClassName);
        System.out.println("url：" + url);
        System.out.println("username：" + username);
        System.out.println("password：" + password);
        System.out.println("maxActive：" + maxActive);
    }
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
