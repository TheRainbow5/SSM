package com.Rainbow.Dao;


import com.Rainbow.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("userDao")
public class UserDao {
    private static Map<Integer, User> userMap=new HashMap<Integer,User>();
    static {
        userMap.put(1001,new User(1001,"zhangsan","male"));
        userMap.put(1002,new User(1002,"lisi","female"));
        userMap.put(1003,new User(1003,"wangwu","male"));
    }
    private static Integer initId=1004;

    /**
     * 获取所有用户信息
     * @return
     */
    public Collection<User> getAllUser(){
        return userMap.values();
    }

    /**
     * 根据id获取指定用户信息
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        return userMap.get(id);
    }

    /**
     * 添加新用户信息
     * @param user
     */
    public void saveUser(User user){
        if(user.getId()==null){
            user.setId(initId++);
        }
        //如果键相同，新数据覆盖旧数据
        userMap.put(user.getId(),user);
    }

    /**
     * 删除用户信息
     * @param id
     */
    public void deleteUser(Integer id){
        userMap.remove(id);
    }
}
