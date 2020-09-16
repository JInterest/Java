package com.test;

import com.test.service.pack02.OneService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/23  21:49
 */
public class Test2 {
    @Test
    public void test(){
        String config= "pack02/applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        OneService oneService = (OneService) ctx.getBean("oneService");

        oneService.sayHi("张三",20);
    }
}
