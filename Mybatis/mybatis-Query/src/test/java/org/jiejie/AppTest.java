package org.jiejie;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.session.SqlSession;
import org.jiejie.myEntity.User;
import org.jiejie.myMapper.UserMapper;
import org.jiejie.myUtils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testGetUserById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void testGetAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testGetUserByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userByMap = mapper.getUserByMap(1);
        System.out.println(userByMap);
    }

    @Test
    public void testGetAllUserByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //方式1
        //List<Map<String, Object>> allUserByMap = mapper.getAllUserByMap();
        //方式2
        Map<String, Object> allUser=mapper.getAllUserByMap();
        System.out.println(allUser);
    }
    @Test
    public void testGetAllUserByMohu() throws IOException{
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userByMohu = mapper.getUserByMohu("r");
        userByMohu.forEach(System.out::println);
    }

    /**
     * 批量删除数据
     * @throws IOException
     */
    @Test
    public void deleteMore() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteMore("4,5");
    }
    /**
     * 动态设置表名，查询数据
     * @throws IOException
     */
    @Test
    public void testGetAllUserFromDifTable() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getAllUserFromDifTable("user");
        user.forEach(System.out::println);
    }

}
