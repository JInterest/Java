package com.test.controller;

import com.test.dao.QuDao;
import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/11  0:30
 */
public class Qu_FindByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  questionID;
        Question qu=null;
        QuDao dao=new QuDao();
        //1【调用请求对象】读取【请求头】参数信息，得到信息
        questionID=request.getParameter("questionID");
        //2【调用QuestionDao】将用户信息填充到sql命令中并借助JDBC规范发送到数据库服务器
        qu=dao.findById(questionID);
        //3 通过请求转发，向Tomcat索要.jsp将处理结果写入响应体
        request.setAttribute("qu_findById",qu);
        request.getRequestDispatcher("/JSP/qu_findById.jsp").forward(request,response);

    }
}
