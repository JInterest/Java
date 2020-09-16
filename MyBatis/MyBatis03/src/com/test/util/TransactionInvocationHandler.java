package com.test.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/17  14:54
 */
public class TransactionInvocationHandler implements InvocationHandler {
	//目标对象
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }
    //代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;

        try {
            session= SqlSessionUtil.getSession();
            //处理业务逻辑

            //真实对象的业务方法
            obj=method.invoke(target,args);

            //处理业务逻辑完毕
            session.commit();
        } catch (Exception e) {
            //异常回滚
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSession(session);
        }
        return obj;
    }
	
	//获取代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
