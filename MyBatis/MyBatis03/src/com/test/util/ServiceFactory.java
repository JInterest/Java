package com.test.util;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  15:19
 */
public class ServiceFactory {
    //传递真实对象 获取代理对象
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
