package org.jiejie.myUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: SqlSessionUtil
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/13 16:35
 * @Version: 1.0
 */
public class SqlSessionUtil {
    public static SqlSession getSqlSession() throws IOException {
        SqlSession sqlSession;
        //获取核心配置文件的输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        //获取sql会话对象，用于操作数据库的对象
        sqlSession = sqlSessionFactory.openSession(true); //设置自动提交
        return sqlSession;
    }
}
