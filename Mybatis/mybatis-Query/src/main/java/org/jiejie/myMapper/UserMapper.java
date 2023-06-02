package org.jiejie.myMapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.jiejie.myEntity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 根据id获取单个用户信息
     * @return
     */
    User getUserById(@Param("id") int id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByMap(@Param("id") int id);

    /**
     * @查询所有数据，存放值Map集合中
     * @一个用户对应一个map集合，map集合是不能嵌套的，
     * @1、可以将多个map集合放入List集合中
     * @2、创建一个大的Map集合，需要用到注解
     * @return
     */
    //方式1
    //List<Map<String,Object>> getAllUserByMap();
    @MapKey("id") //id为大Map集合的键
    Map<String,Object> getAllUserByMap();

    /**
     * 模糊查询
     */
    List<User> getUserByMohu(@Param("mohu") String mohu);

    /**
     * 根据id范围，批量删除用户信息
     */
    void deleteMore(@Param("ids") String ids);

    /**
     * 动态查询表中所所有数据
     * @param tableName
     */
    List<User> getAllUserFromDifTable(@Param("tableName") String tableName);

}
