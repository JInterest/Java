package com.test.test;

import com.test.domain.Student;
import com.test.service.StudentService;
import com.test.service.StudentServiceImpl;
import com.test.util.ServiceFactory;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  14:13
 */
public class Test1 {
    public static void main(String[] args) {
        //StudentService ss=new StudentServiceImpl();
        StudentService ss= (StudentService) ServiceFactory.getService(new StudentServiceImpl());

/*        Student student =new Student();
        student.setAge(23);
        student.setName("sad");
        student.setId("A0006");

        ss.addStu(student);*/

        Student student = ss.selectById("A0001");
        System.out.println(student);
    }
}
