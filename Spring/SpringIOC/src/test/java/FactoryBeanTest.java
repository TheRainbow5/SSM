import com.jiejie.Entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: FactoryBeanTest
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/19 20:50
 * @Version: 1.0
 */
public class FactoryBeanTest {
    @Test
    public void testItem1(){
        //加载配置文件-传入配置文件的文件名
        ApplicationContext ioc =new ClassPathXmlApplicationContext("spring-autowire.xml");
        //返回的是Object类型，需要向下转型，获取实体类对象
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
