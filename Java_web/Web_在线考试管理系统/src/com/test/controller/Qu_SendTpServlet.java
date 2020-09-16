package com.test.controller;

import com.test.dao.QuDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/11  21:26
 */
public class Qu_SendTpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        List<Question> list=new ArrayList<>();
        QuDao dao=new QuDao();
        list=dao.sendTp();

        session.setAttribute("qu_sendTp",list);
        session.setAttribute("look",null);
        request.getRequestDispatcher("/JSP/exam.jsp").forward(request,response);
    }
}
