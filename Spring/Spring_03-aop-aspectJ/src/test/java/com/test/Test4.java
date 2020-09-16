package com.test;

import com.test.service.pack04.OneServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/27  14:40
 */
public class Test4 {
    @Test
    public void test(){
        String config= "pack04/applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        OneServiceImpl oneService = (OneServiceImpl) ctx.getBean("oneService");

        //目标类没有接口，使用的是cglib动态代理，spring框架会自动应用cglib
        //com.test.service.pack04.OneServiceImpl$$EnhancerBySpringCGLIB$$eb85df45
        System.out.println(oneService.getClass().getName());

        oneService.sayHi();
    }
}
