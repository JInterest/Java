package com.test.listener;

import com.test.util.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/09  20:27
 * 演示 监听器的作用
 */
public class Onelistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //在http服务器启动时创建 20个Connection连接通道
        Map map=new HashMap();
        for (int i = 0; i <20 ; i++) {
            try {
                Connection conn=DBUtil.getConnection();
                //System.out.println("生成conn"+conn);
                map.put(conn,true);//true表示空闲，false表示载使用
                //保存到全局作用域中
                ServletContext application=sce.getServletContext();
                application.setAttribute("lsnMap",map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //在http服务器关闭时 销毁 20个Connection连接通道
        ServletContext application=sce.getServletContext();
        Map map=(Map)application.getAttribute("lsnMap");
        Iterator it = map.keySet().iterator();
        Connection conn;
        while (it.hasNext()){
            conn = (Connection) it.next();
            if (conn != null) {
                DBUtil.close(conn);
               // System.out.println("关闭！"+conn);
            }
        }
    }
}
