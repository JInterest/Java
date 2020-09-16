package com.test;

import com.test.service.pack01.OneService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/23  21:49
 */
public class Test1 {
    @Test
    public void test(){
        String config= "pack01/applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        OneService oneService = (OneService) ctx.getBean("oneService");
        //实际上是调用的是jdk的动态代理
        System.out.println(oneService.getClass().getName());//com.sun.proxy.$Proxy10

        oneService.sayHi();
    }
}
