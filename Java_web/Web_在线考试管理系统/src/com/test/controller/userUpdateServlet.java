package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/04  21:09
 */
public class userUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        Users users = null;
        int result = 0;
        //1【调用请求对象】读取【请求头】参数信息，得到用户修改信息
        String userName, sex, email, userid;
        userName = request.getParameter("userName");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        userid = request.getParameter("userid");
        //2【调用userDao】将用户信息填充到update令中并借助JDBC规范发送到数据库服务器
        users = new Users(Integer.valueOf(userid), userName, sex, email);
        result = dao.upDate(users);
        //3【调用响应器对象】将【处理结果】以二进制形式写入响应体
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (result == 1) {
            
            out.print("<font style='color:red;font-size:40' >用户信息更新成功</font>");
            out.print(
                    "<a href='/myWeb/user/Find2' >" +
                            "<input type=button value='返回' onclick='window.location.href('/myWeb/user/Find2')' >" +
                            "</a>");
        } else {
            out.print("<font style='color:red;font-size:40' >用户信息更新失败</font>");
            out.print(
                    "<a href='/myWeb/user/Find2' >" +
                            "<input type=button value='返回' onclick='window.location.href('/myWeb/user/Find2')' >" +
                            "</a>");
        }
    }

}
