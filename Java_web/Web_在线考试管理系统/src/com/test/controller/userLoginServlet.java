package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/05  15:16
 */
public class userLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName, password;
        UserDao dao = new UserDao();

        //post对请求参数使用utf-8字符集进行重新编辑
        request.setCharacterEncoding("utf-8");
        //1调用【请求对象】从请求头获取【请求参数】，得到用户输入的信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        Users user = new Users(userName, password);
        //2【调用userDao】将用户信息填充到sql命令中并借助JDBC规范发送到数据库服务器
        int result = 0;
        result = dao.login(userName,password);
        //3【调用响应器对象】将【处理结果】以二进制形式写入响应体

        if (result == 1) {
            HttpSession session=request.getSession();
            response.sendRedirect("/myWeb/index.html");
        } else {
            response.sendRedirect("/myWeb/login_error.html");
        }
    }

}
