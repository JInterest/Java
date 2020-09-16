package com.test.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.Date;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/05/23  21:28
 */
@Aspect//定义切面类
public class Advice {
    //增强功能的方法
    @Before(value = "execution(public void com.test.service.pack01.OneServiceImpl.sayHi())")
    //属性value表示切面执行的位置
    public void Before(){
        System.out.println("在目标方法执行之前，例如输出日志");
    }
    @Before(value = "execution(* * ..pack04.OneServiceImpl.sayHi())")
    public void Before2(){
        System.out.println("见面时间"+new Date());
    }

    //后置通知
    /* returning是目标方法的返回值，命名与目标方法的形参名一致
        相当于 Object obj = sayHi(String,Integer)
          AfterReturning(obj)
        可以修改这个返回值，影响最后调用的结果
     */
    @AfterReturning(value = "execution(* *..OneServiceImpl.sayHi(String,Integer))",returning = "obj")
    public void AfterReturning(JoinPoint jp,Object obj){
        /*指定通知方法中的参数: JoinPoint
          JoinPoint（连接点）代表业务方法，要加入切面功能的业务方法 如sayHi
            作用是：可以在通知方法中获取方法执行时的信息，例如方法的名称，方法的实参。
            如果你的切面功能中需要用到方法的信息，就加入JoinPoint。
            这个JointPoint参数的值是有框架赋予，必须是第一个位置的参数
         */
        /*
        System.out.println("方法的签名（定义）="+jp.getSignature());
        System.out.println("方法的名称 ="+jp.getSignature().getName());
        //获取方法的实参
        Object args[] = jp.getArgs();
        for (Object arg:args
             ) {
            System.out.println("参数="+arg);
        }*/
        if(obj!=null){
            System.out.println("见面时间"+new Date());
        }
    }

    //环绕通知
    /*
        @Around: 环绕通知
          属性：value 切入点表达式
          位置；在方法的定义上面
         特点：
          1.它是功能最强的通知
          2.在目标方法的前和后都能增强功能
          3.控制目标方法是否被调用执行
          4.修改原来的目标方法的执行结果，影响最后调用的结果
         环绕通知等同与jdk动态代理的，InvocationHandler接口
            返回值就是目标方法的执行结果，可以被修改。
     */
    @Around(value = "Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        Object obj=null;

        //目标方法前加入功能
        System.out.println("见面时间"+new Date());
        //目标方法的调用
        pjp.proceed();//method.invoke();

        //目标方法后加入功能
        System.out.println("提交事务");
        return obj;
    }
    //throwing属性 用于指定发生的异常对象
    //相当于try{目标方法}catch(){ myAfterThrowing(ex) }
    @AfterThrowing(value = "execution(* *..OneServiceImpl.sayHi(String,Integer))",throwing = "ex")
    public void myAfterThrowing(Throwable ex){
        //记录异常信息
        System.out.println("异常通知：异常发生时执行"+ex.getMessage());

    }
    //相当于 try{}catch(){}finally{ myAfter() }
    @After(value="execution(* *..OneServiceImpl.sayHi(String,Integer))")
    public void myAfter(){
        System.out.println("最终通知");
    }
    /*
       @Pointcut : 定义和管理切入点，如果你的项目中有多个切入点表达式是重复的，可以复用的。
                        可以使用@Pointcut,统一管理切入点表达式。
           属性: value 切入点表达式
           位置: 在自定义的方法上面
          特点:
           当使用@Pointcut定义在一个方法的上面，此时这个方法就是切入点表达式的别名
           其他的通知中，value就可以使用这个方法代替切入点表达式。

    * */
    @Pointcut(value = "execution(* *..OneServiceImpl.sayHi(String,Integer))")
    private void Pointcut(){
        //无需代码
    }
}
