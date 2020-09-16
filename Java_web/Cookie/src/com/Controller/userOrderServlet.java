package com.Controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/06  16:39
 */
@WebServlet("/order")
public class userOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int JZ = 10;
        int MT = 5;
        int LYT = 30;
        int balance = 0, consumption = 0;
        String userName = null;
        Cookie newCookie = null;

        String values[] = request.getParameterValues("food");
        //遍历计算消费金额
        for (String value : values
        ) {
            if ("饺子".equals(value)) {
                consumption += JZ;
            } else if ("面条".equals(value)) {
                consumption += MT;
            } else if ("老鸭汤".equals(value)) {
                consumption += LYT;
            }
        }
        Cookie cookie[] = request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (request.getCookies() != null) {
            for (Cookie c : cookie
            ) {
                if ("userName".equals(c.getName())) {
                    userName = c.getValue();
                } else if ("money".equals(c.getName())) {
                    balance = Integer.valueOf(c.getValue());
                    if (consumption > balance) {
                        out.print("<font size='40px' color='red' >余额不足！</font>");
                    } else {
                        balance -= consumption;
                        out.print("<font size='40px' color='red' >用户" + userName +
                                "本次消费:" + consumption +
                                "余额:" + balance + "</font>");
                        //要想修改Cookie只能使用一个同名的Cookie来覆盖原来的Cookie，
                        // 达到修改的目的。删除时只需要把maxAge修改为0即可。
                        //key相同的会被覆盖掉，将消费后的余额发送到客户端
                        newCookie = new Cookie("money", balance + "");
                        response.addCookie(newCookie);
                    }
                }
            }
        } else {
            out.print("<font size='40px' color='red' >余额不足！</font>");
        }


    }
}
