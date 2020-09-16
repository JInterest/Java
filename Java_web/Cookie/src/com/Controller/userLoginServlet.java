package com.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/06  16:26
 */
@WebServlet("/login")
public class userLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,balance;
        userName=request.getParameter("userName");
        balance=request.getParameter("money");
        Cookie cookie1=new Cookie("userName",userName);
        Cookie cookie2=new Cookie("money",balance);
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        response.sendRedirect("order.html");
    }
}
