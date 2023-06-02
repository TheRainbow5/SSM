import com.jiejie.Annotation.Control.UserController;
import com.jiejie.Annotation.Dao.UserDao;
import com.jiejie.Annotation.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Component：将类标记为普通组件
 * @Controller：将类标记为控制层组件
 * @Service：将类标记为业务层组件
 * @Repository：将类标记为持久层组件
 *
 * @通过注解+扫描所配置的bean的id，默认值为类名的首字母小写
 * @可以通过标识组件的注解的value属性值设置bean的自定义id
 *
 * @Autowire：实现自动装载功能的注解
 * @1、@Autowire注解能够标识位置
 * @a、标识在成员变量上，此时不需要设置成员变量的set方法
 * @b、标识在set方法上
 * @c、标识在成员变量的有参构造上
 *
 * @Autowire：实现自动装载功能的原理
 * 默认bean的id是属性名
 * 1、默认通过byType的方式，在IOC容器中通过类型匹配对应的bean的id，为属性赋值。
 * 2、如同时有多个满足条件的bean，此时会自动转换为byName的匹配方式，实现自动装载
 * 3、如果byType和byName两种方式都无法实现自动装配，
 *   需要通过添加@Qualifer(value)指定某个bean的id。
 */
public class AnnotationTest {
    /**
     * @1、默认通过byType的方式，在IOC容器中通过类型匹配某个Bean为属性赋值
     * @2、
     */
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-annotation.xml");
        UserDao userDao =(UserDao) ioc.getBean("dao");
        userDao.testValueAnnotation();
    }
}
