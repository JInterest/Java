package com.test;


import com.test.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //定义Spring的配置文件
        String config="applicationContext.xml";

        //创建Spring的容器对象，根据Spring配置文件的位置，使用接口的不同实现类
        //如果Spring配置文件位置是在类路径下（classpath）,使用ClassPathXmlApplicationContext
        //根目录下    FileSystemXmlApplicationContext(config);
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);

        //创建容器对象时，就把配置文件的所有对象都创建出来，放到容器中，需要时再取出来
        SomeService service= (SomeService) ctx.getBean("someService");
        //调用业务的方法
        service.doSome();
    }
}
