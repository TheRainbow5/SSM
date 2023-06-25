package com.Rainbow.Service.Impl;

import com.Rainbow.Pojo.User;
import com.Rainbow.Service.UserService;
import com.Rainbow.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService
 *
 * @description
 * @author:Rainbow
 * @date:2023/6/24 0024 20:14
 * @version:1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private int id;
    /**
     * @description: 将所有用户信息封装在Collection集合
     **/
    @Override
    public List<User> getAllUser() {
        List<User> allUser = userMapper.getAllUser();
        User user = allUser.get(allUser.size() - 1);
        this.id=user.getId()+1;
        return userMapper.getAllUser();
    }
    /**
     * @description:添加新用户
     * @param:[user]
     **/
    @Override
    public void addUser(User user) {
        user.setId(id);
        userMapper.addUser(user);
    }

    @Override
    public User getUserById(int id){
        User user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
