package com.test.controller;

import com.test.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/11  23:32
 */
public class Qu_ExamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得请求参数信息
        String className, name, uAnswer;
        int score = 0;
        int i = 1;
        HttpSession session = request.getSession(false);
        className = request.getParameter("className");
        name = request.getParameter("name");
        List<Question> list = (List<Question>) session.getAttribute("qu_sendTp");
        Map examInfoMap = new HashMap();
        for (Question qu : list
        ) {
            //题号对应 考生回答结果
            uAnswer = request.getParameter("uAnswer_" + qu.getQuestionID());
            if (uAnswer != null) {
                uAnswer = uAnswer.toUpperCase();
            }
            //将考生回答结果存到session，后期查看试卷!
            if (uAnswer.equals(qu.getAnswer())) {
                score += 25;
                session.setAttribute("uAnswer" + i, qu.getAnswer());
            } else if (uAnswer == null) {
                session.setAttribute("uAnswer" + i, null);
            } else {
                session.setAttribute("uAnswer" + i, uAnswer);
            }
            i++;
        }
        session.setAttribute("className", className);
        session.setAttribute("name", name);
        session.setAttribute("score", score);
        //设置查看考试结果令牌 （可以用过滤器）
        session.setAttribute("look","随便加什么");
        request.getRequestDispatcher("/JSP/score.jsp").forward(request, response);
    }
}
