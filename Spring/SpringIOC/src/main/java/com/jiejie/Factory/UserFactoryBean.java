package com.jiejie.Factory;

import com.jiejie.Entity.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: UserFactoryBean
 * @Author: jiejie
 * @Description:FactoryBean是一个接口，需要创建一个类实现该接口
 * @其中有三个方法：
 * @getObject()：通过一个对象交给IOC容器
 * @getObjectType()：设置所提供对象的类型
 * @isSingleton()：所提供的对象是否单例
 * @当把FactoryBean的实现类配置为Bean时，会将当前类中getObject()所返回的对象交给IOC容器
 * @Date: 2023/5/19 20:46
 * @Version: 1.0
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        User user = new User("zhangsan", 23, 170);
        return user;
    }
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
