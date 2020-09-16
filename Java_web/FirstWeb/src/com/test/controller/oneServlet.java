package com.test.controller;

import com.test.entity.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class oneServlet extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student1=new Student(01,"张三","男","高三一班");
        Student student2=new Student(02,"李四","男","高三一班");
        Student student3=new Student(03,"王五","男","高三二班");
        List list = new ArrayList();
        list.add(student1);
        list.add(student2);
        //引用类型转换成json格式
        JSONArray jsonArray= JSONArray.fromObject(list);
        JSONObject jsonObject = JSONObject.fromObject(student3);

        response.setContentType(" text/html; charset=utf-8");
        response.getWriter().print(jsonArray);
        response.getWriter().print(jsonObject);

        System.out.println(jsonArray);
        System.out.println(jsonObject);
    }
}
