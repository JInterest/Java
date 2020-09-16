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
 * @Date: 2020/05/04  19:50
 */
public class UserFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //【调用DAO】将查询命令推送到数据库服务器上，得到所有用户信息【List】
        List<Users> usersList = new ArrayList<>();
        UserDao dao = new UserDao();
        usersList = dao.select();
        //【调用响应对象】将用户信息结合<table>标签命令以二进制形式写入到响应体中
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<th>用户编号</th>");
        out.print("<th>用户姓名</th>");
        out.print("<th>用户密码</th>");
        out.print("<th>用户性别</th>");
        out.print("<th>用户邮箱</th>");
        out.print("<th>操作</th>");
        out.print("</tr>");
        for (Users user : usersList
        ) {
            out.print("<form action='/myWeb/user/Del' >");
            out.print("<tr>");
            out.print("<td><input type='text' name='userid' value='"+ user.getUserID() +"' readonly > </td>");
            out.print("<td>" + user.getUserName() + "</td>");
            out.print("<td>******</td>");
            out.print("<td>" + user.getSex() + "</td>");
            out.print("<td>" + user.getEmail() + "</td>");
            out.print("<td>" +
                            "<input type='submit' value='删除' >" +
                      "</td>");
            out.print("</tr>");
            out.print("</form>");
        }
        out.print("</table>");
    }
}
