package com.Rainbow.Controller;

import com.Rainbow.Entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: dowLoadAndUploadController
 * @Author: Rainbow
 * @Description: Ajax请求
 * @Date: 2023/6/9 20:55
 * @Version: 1.0
 * @RestController：@Controller+@ResponseBody
 *      @Controller：注册bean对象，
 *      @ResponseBody：将java对象转为json格式响应给浏览器
 */
@RestController("ajaxController")
public class ajaxController {
    /**
     * ajax普通参数绑定
     *
     * @param id
     * @param response
     * @throws IOException
     */
    @RequestMapping("testAjax")
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id=" + id);
        response.getWriter().write("hello world");
    }

    /**
     * 获取ajax请求体
     *
     * @param id
     * @throws IOException
     * @RequestBody：将请求体中的内容和控制器方法的形参进行绑定 1、需要导入jackson依赖，将json格式的请求参数转为java对象
     * 2、在SpringMVC.xml开启注解驱动
     * 3、在处理请求的控制器方法形参位置，直接设置json格式的请
     */
    @RequestMapping("testAjaxRequestBody")
    public void testAjaxRequestBody(Integer id,
//                       @RequestBody String requestBody
//                       @RequestBody User user  //封装为user对象
                                    @RequestBody Map<String, Object> userMap  //封装为map集合
    ) throws IOException {
        System.out.println("id=" + id);
//        System.out.println(user);
        System.out.println("userMap:" + userMap);
    }

    /**
     * @ResponseBody 将java类型的数据转为json格式，返回个客户端
     * 1、普通user对象
     * 2、Map集合对象
     * 3、List集合对象
     */
    @RequestMapping("testAjaxResponseBody")
//    public User testAjaxResponseBody(){
//        User user = new User(1,"zhangsan","112233");
//        return user;
//    }
    public Map<Integer, Object> testAjaxResponseBody() {
        User user1 = new User(1, "zhangsan", "112233");
        User user2 = new User(2, "zhangsan", "112233");
        User user3 = new User(3, "zhangsan", "112233");
        Map<Integer, Object> userMap = new HashMap<Integer, Object>();
        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
        userMap.put(user3.getId(), user3);
        return userMap;
    }

//        public List<User> testAjaxResponseBody(){
//        User user1 = new User(1,"zhangsan","112233");
//        User user2 = new User(2,"zhangsan","112233");
//        User user3 = new User(3,"zhangsan","112233");
//        List<User> userList= Arrays.asList(user1,user2,user3);
//        return userList;
//    }
}
