package cn.JInterest.controller;

import cn.JInterest.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    /**
     * 逐个接收请求参数：
     *   要求： 处理器（控制器）方法的形参名和请求中参数名必须一致。
     *          同名的请求参数赋值给同名的形参
     * 框架接收请求参数
     *   1. 使用request对象接收请求参数
     *      String strName = request.getParameter("name");
     *      String strAge = request.getParameter("age");
     *   2. springmvc框架通过 DispatcherServlet 调用 MyController的doSome()方法
     *      调用方法时，按名称对应，把接收的参数赋值给形参
     *      doSome（strName，Integer.valueOf(strAge)）
     *      框架会提供类型转换的功能，能把String转为 int ，long ， float， double等类型。
     *
     *  400状态码是客户端错误， 表示提交请求参数过程中，发生了问题。
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name, Integer age){
        System.out.println("doSome, name="+name+"   age="+age);
        //可以在方法中直接使用 name ， age
        //....service调用处理完成了。

        //处理some.do请求。
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",Integer.valueOf(age));
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }
    /**
     * 处理器方法形参是java对象， 这个对象的属性名和请求中参数名一样的
     * 框架会创建形参的java对象， 给属性赋值。 请求中的参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/receiveObject.do")
    public ModelAndView doOrder(Student student) {
        System.out.println("receiveParam, name="+student.getName()+"   age="+student.getAge());
        //可以在方法中直接使用 name ， age
        //...处理service

        //处理some.do请求了
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myName",student.getName());
        mv.addObject("myAge",student.getAge());
        mv.addObject("myStudent",student);
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }
}
