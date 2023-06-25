package com.Rainbow.mapper;

import com.Rainbow.Pojo.User;

import java.util.List;

/**
 * UserMapper
 *
 * @description
 * @author:Rainbow
 * @date:2023/6/24 0024 20:23
 * @version:1.0
 */
public interface UserMapper {
    /**
     * @description: 查询所用用户信息，存储至List集合
     **/
    List<User> getAllUser();
    /**
     * @description:添加新用户
     **/
    int addUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
