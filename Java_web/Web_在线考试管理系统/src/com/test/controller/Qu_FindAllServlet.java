package com.test.controller;

import com.test.dao.QuDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/10  22:46
 */
public class Qu_FindAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Question qu=null;
        QuDao dao=new QuDao();
        List<Question> list =new ArrayList<>();
        list=dao.findAll();
        //将数据放到请求作用域，交给jsp处理输出结果
        request.setAttribute("qu_find",list);
        request.getRequestDispatcher("/JSP/qu_find.jsp").forward(request,response);

    }
}
