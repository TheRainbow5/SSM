package com.Rainbow.Controller;

import com.Rainbow.Pojo.User;
import com.Rainbow.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController
 *
 * @description
 * @author:Rainbow
 * @date:2023/6/24 0024 20:09
 * @version:1.0 1、查询所有的员工信息---/user--->get
 * 2、跳转到添加页面---/to/add--->get
 * 3、添加员工信息---/user--->post
 * 4、修改员工信息---/user--->put
 * 5、删除员工信息---/user/1--->delete
 */
@Controller("userController")  //设置bean的id
public class UserController {
    @Resource(name = "userService")
    private UserService userService;
    
    /**
     * @description:  显示所有员工信息
     **/
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(Model model) {
        //查询所用员工信息
        List<User> userList = userService.getAllUser();
        //将员工信息在请求域中共享数据
        model.addAttribute("userList", userList);
        return "user_list";  //跳转页面
    }
    /**
     * @description:添加新用户
     * @param:[user]
     **/
    @RequestMapping(value="/user",method = RequestMethod.POST)
    public String add(User user){
        System.out.println("添加："+user);
        userService.addUser(user);
        return "redirect:/user";
    }
    /**
     * @description:  跳转到修改页面
     * @param:[id, model]
     **/
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String toUpdateUser(@PathVariable("id") Integer id, Model model){
        //根据id查询员工信息
        User user = userService.getUserById(id);
        //将user信息共享到请求域
        model.addAttribute("user", user);
        //跳转到user_update.html
        return "user_update";
    }
    /**
     * @description:修改用户信息
     **/
    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public String updateUser(User user) {
        //修改用户信息
        userService.updateUser(user);
        return "redirect:/user";
    }
    @RequestMapping(value="user/{id}",method = RequestMethod.DELETE)

    public String deleteUser(@PathVariable("id")Integer id){
        //删除用户信息
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
