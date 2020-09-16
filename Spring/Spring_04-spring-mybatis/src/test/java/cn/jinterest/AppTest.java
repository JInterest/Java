package cn.jinterest;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void doSome(){

        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[]=ctx.getBeanDefinitionNames();
        for (String name:names
             ) {
            System.out.println("容器对象"+name+"----"+ctx.getBean(name));
        }
    }

}
