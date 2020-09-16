package com.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/15  21:09
 */
@WebServlet("/download")
public class DownServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String file = request.getParameter("file"); //客户端传递的需要下载的文件名
        String path = request.getServletContext().getRealPath("") + "/images/" + file; //默认认为文件在当前项目的根目录
        System.out.println(path);
        FileInputStream fis = new FileInputStream(path);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + file);
        ServletOutputStream out = response.getOutputStream();
        byte[] bt = new byte[1024];
        int length = 0;
        while ((length = fis.read(bt)) != -1) {
            out.write(bt, 0, length);
        }
        out.close();
    }
}