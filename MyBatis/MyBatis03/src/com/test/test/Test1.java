package com.test.test;

import com.test.domain.Student;
import com.test.service.StudentService;
import com.test.service.StudentServiceImpl;
import com.test.util.ServiceFactory;

import java.util.List;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  14:13
 */
public class Test1 {
    public static void main(String[] args) {
        //StudentService ss=new StudentServiceImpl();
        StudentService ss= (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        //添加
/*        Student student =new Student();
        student.setAge(23);
        student.setName("sad");
        student.setId("A0006");
        ss.addStu(student);*/
/*
        //查单条
        Student student = ss.selectById("A0001");
        System.out.println(student);*/

        //查所有
/*        List<Student> students = ss.selectAll();
        for (Student s:students
             ) {
            System.out.println(s);
        }*/

        //根据id删除
        //ss.delById("A0006");

        //更新studentInfo
        /*Student student =new Student();
        student.setAge(18);
        student.setName("gx");
        student.setId("A0005");
        ss.updateStu(student);*/

        //查所有2
/*        List<Student> students = ss.selectAll2();
        for (Student s:students
        ) {
            System.out.println(s);
        }*/

        //动态sql where if 标签 ，模糊查询
       /* Student s=new Student();
        s.setName("l");
        s.setAddress("a");
        List<Student> students = ss.find(s);
        for (Student stu:students
        ) {
            System.out.println(stu);
        }*/

        //动态sql foreach标签 ，根据多个id查询
        String [] stuArr={"A0001","A0003","A0004"};
        List<Student> students = ss.selectById2(stuArr);
        for (Student stu:students
        ) {
            System.out.println(stu);
        }
    }
}





















