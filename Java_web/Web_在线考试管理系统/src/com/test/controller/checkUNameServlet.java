package com.test.controller;

import com.test.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/14  23:51
 */
public class checkUNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        UserDao dao=new UserDao();
        int result=dao.findByName(userName);
        response.getWriter().print(result);
    }
}
