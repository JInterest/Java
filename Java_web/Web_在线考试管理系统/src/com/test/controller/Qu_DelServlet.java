package com.test.controller;

import com.test.dao.QuDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/10  23:54
 */
public class Qu_DelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionID=request.getParameter("questionID");
        QuDao dao=new QuDao();
        int result=dao.delete(questionID);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        if (result==1){
            out.print("<center><font color='red' size='45px'>删除成功！</font></center>");
            out.print("<a href=\"/myWeb/qu_findAll\">\n" +
                    "            <button>返回</button>\n" +
                    "        </a>");
        }else {
            out.print("<center><font color='red' size='45px'>删除失败！</font></center>");
            out.print("<a href=\"/myWeb/qu_findAll\">\n" +
                    "            <button>返回</button>\n" +
                    "        </a>");
        }
    }
}
