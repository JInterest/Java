package com.test.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  14:16
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    // 解决资源争抢问题.
    public static ThreadLocal<SqlSession> localSessions = new ThreadLocal<>();

    private SqlSessionUtil() {}

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        // 获取Session对象
    public static SqlSession getSession(){
        SqlSession session = localSessions.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            localSessions.set(session);
        }
       return session;
    }
    // 关闭session的方法
    public static void closeSession(SqlSession session){
        if (session != null) {
            session.close();
            //保证
            localSessions.remove();
        }
    }
}
