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
 * @Date: 2020/05/10  21:14
 */
public class Qu_AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  title,optionA,optionB,optionC,optionD,answer;
        int result=0;
        Question qu=null;
        QuDao dao=new QuDao();
        //1【调用请求对象】读取【请求头】参数信息，得到信息
        title =request.getParameter("title");
        optionA= request.getParameter("optionA");
        optionB =request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD =request.getParameter("optionD");
        answer= request.getParameter("answer");
        qu=new Question(null,title,optionA,optionB,optionC,optionD,answer);
        //2【调用QuestionDao】将用户信息填充到insert令中并借助JDBC规范发送到数据库服务器
        result=dao.add(qu);
        //3 通过请求转发，向Tomcat索要info.jsp将处理结果写入响应体
        if (result==1){
            request.setAttribute("info","试题添加成功！");
        }else {
            request.setAttribute("info","试题添加失败！");
        }
        request.getRequestDispatcher("/JSP/info.jsp").forward(request,response);
    }
}
