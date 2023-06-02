import com.jiejie.Proxy.Demo1.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: test
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/11 11:38
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-AOP.xml");
        //动态代理的是接口：注意点，返回的是接口类型
        UserService userService =(UserService) applicationContext.getBean("userServiceImpl");
        userService.add();
    }
}
