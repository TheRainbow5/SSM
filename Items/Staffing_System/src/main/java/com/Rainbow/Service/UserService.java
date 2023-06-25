package com.Rainbow.Service;

import com.Rainbow.Pojo.User;

import java.util.List;

/**
 * UserService
 *
 * @description
 * @author:Rainbow
 * @date:2023/6/24 0024 21:20
 * @version:1.0
 */
public interface UserService {
    /**
     * @description:将查询后的数据存储至List集合
     **/
    List<User> getAllUser();

    void addUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
