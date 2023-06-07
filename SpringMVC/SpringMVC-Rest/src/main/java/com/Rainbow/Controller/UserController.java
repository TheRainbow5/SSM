package com.Rainbow.Controller;

import com.Rainbow.Dao.UserDao;
import com.Rainbow.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @ClassName: UserController
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/6/7 13:55
 * @Version: 1.0
 */

@Controller("userController")
public class UserController {
    @Resource(name="userDao")
    private UserDao userDao;

    /**
     * 查询所有用户信息
     * @param model
     * @return
     */
    @RequestMapping(value = "user",method = RequestMethod.GET)
    public String getAllUser(Model model){
        Collection<User> allUser = userDao.getAllUser();
        model.addAttribute("allUsers",allUser);  //共享数据
        return "user_list";
    }

    /**
     * 跳转到addUser页面
     * @param user
     * @return
     */
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public String addUser(User user){  //spring MVC将数据自动封装为User实体类
        userDao.saveUser(user);
        //重定向到用户信息页面:/user
        return "redirect:/user";
    }

    /**
     * 跳转到update页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public String toUpdateUser(@PathVariable("id") Integer id,Model model){
        //根据id查询员工信息
        User user = userDao.getUserById(id);
        //将user信息共享到请求域
        model.addAttribute("user",user);
        //跳转到user_update.html
        return "user_update";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "user",method = RequestMethod.PUT)
    public String updateUser(User user){
        //修改用户信息
        userDao.saveUser(user);
        return "redirect:/user";
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        //删除用户信息
        userDao.deleteUser(id);
        return "redirect:/user";
    }
}
