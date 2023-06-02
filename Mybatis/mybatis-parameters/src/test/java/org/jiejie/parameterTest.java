package org.jiejie;

import org.apache.ibatis.session.SqlSession;
import org.jiejie.myEntity.User;
import org.jiejie.myMapper.UserMapper;
import org.jiejie.myUtils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: parameterTest
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/16 15:57
 * @Version: 1.0
 */
public class parameterTest {
    @Test
    public void testGetUserByUserName() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserByUserName("admin");
        System.out.println(user);
    }
    @Test
    public void testCheckLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.checkLogin("admin","112233");
        System.out.println(user);
    }
    @Test
    public void testCheckLoginByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","112233");
        User user=mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsertNewUser() throws IOException{
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //创建User对象
        User user=new User(null,"root","123123",22,"女","23@qq.com");
        mapper.insertNewUser(user);
    }
    @Test
    public void testCheckLoginByParam() throws IOException{
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.checkLoginByParam("root","123123");
        System.out.println(user);
    }
}
