package com.text.pack01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/22  21:56
 */
public class test01 {
    @Test
    public void test(){

        String config="pack01/applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student");

        System.out.println(student);

    }

}
