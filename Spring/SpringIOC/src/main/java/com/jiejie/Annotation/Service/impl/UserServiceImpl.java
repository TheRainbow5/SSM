package com.jiejie.Annotation.Service.impl;

import com.jiejie.Annotation.Dao.UserDao;
import com.jiejie.Annotation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service("userService")  //设置bean的id
@Scope("singleton")  //单例
public class UserServiceImpl implements UserService {
    @Autowired  //自动装载
    private UserDao userDao;
    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
