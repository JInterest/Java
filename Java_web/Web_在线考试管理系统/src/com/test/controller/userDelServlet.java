package com.test.controller;

import com.test.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/06  14:33
 */
public class userDelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        UserDao dao = new UserDao();
        int result = dao.delete(userid);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if (result == 1) {
            out.print("<center>");
            out.print("<font style='color:red;font-size:40' >用户信息删除成功</font>");
            out.print(
                    "<a href='/myWeb/user/find' >" +
                            "<input type=button value='返回' onclick='window.location.href('/myWeb/user/find')' >" +
                            "</a>");
            out.print("</center>");
        } else {
            out.print("<center>");
            out.print("<font style='color:red;font-size:40' >用户信息删除失败</font>");
            out.print(
                    "<a href='/myWeb/user/find' >" +
                            "<input type=button value='返回' onclick='window.location.href('/myWeb/user/find')' >" +
                            "</a>");
            out.print("</center>");
        }

    }
}
