package com.text.pack02;

import com.text.pack02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/22  22:27
 */
public class test02 {
    @Test
    public void test(){

        String config="pack02/applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);

    }
}
