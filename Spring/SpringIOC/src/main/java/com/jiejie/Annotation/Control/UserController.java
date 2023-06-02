package com.jiejie.Annotation.Control;

import com.jiejie.Annotation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("controller")  //控制层组件
public class UserController {
//    @Resource(name="userService")
    private UserService userService;  //默认bean的id
    @Resource(name="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
    public UserService getUserService() {
        return userService;
    }
}
