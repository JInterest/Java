package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        Users users = null;
        int result = 0;
        //1【调用请求对象】读取【请求头】参数信息，得到用户注册信息
        String userName, password, sex, email;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        users = new Users(null, userName, password, sex, email);
        //2【调用userDao】将用户信息填充到insert令中并借助JDBC规范发送到数据库服务器
        Long begin = System.currentTimeMillis();
        Date da = new Date();
        //result = dao.add(users);
        result = dao.add(users, request); //使用监听器前运行速度得到优化
        Long end = System.currentTimeMillis();
        System.out.println("注册消耗时间"+(end - begin)+"毫秒");
        //3【调用响应器对象】将【处理结果】以二进制形式写入响应体
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (result == 1) {
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        } else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
    }
    //Tomcat 负责销毁【请求对象】和【响应对象】
    //Tomcat 负责将Http响应协议包推送到发起请求的浏览器上
    //浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
    //浏览器将编辑后结果显示在窗口中展示给用户【结束】
}
