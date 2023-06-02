package org.jiejie.myMapper;


import org.apache.ibatis.annotations.Param;
import org.jiejie.myEntity.User;

import java.util.Map;
import java.util.Objects;

public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 使用Map集合存储数据
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertNewUser(User user);

    /**
     * 通过注解形式传入参数
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username")String username,@Param("password") String password);
}
