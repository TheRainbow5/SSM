package org.jiejie;

import org.apache.ibatis.session.SqlSession;
import org.jiejie.myEntity.User;
import org.jiejie.myMapper.UserMapper;
import org.jiejie.myUtils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: test
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/13 15:27
 * @Version: 1.0
 */
public class test {
    private SqlSession sqlSession;

    @Test
    public void testInsert() throws IOException {
        //获取sql会话对象，用于操作数据库的对象
        sqlSession = SqlSessionUtil.getSqlSession();
        //获取UserMapper的代理实现类对象（主要的不同）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口的方法，实现添加用户信息功能
        int result = mapper.insertUser();
        System.out.println("结果" + result);
        //关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testQuery() throws IOException {
        sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testQueryAllUser() throws IOException {
        sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }
}
