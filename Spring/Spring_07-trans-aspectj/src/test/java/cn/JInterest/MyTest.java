package cn.JInterest;

import cn.JInterest.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/29  14:26
 */

public class MyTest {

    @Test
    public void test() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //从容器获取service
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");

        //调用方法
        service.buy(1002, 10);
    }
}