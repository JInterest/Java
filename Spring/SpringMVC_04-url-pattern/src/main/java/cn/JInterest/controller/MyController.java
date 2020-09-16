package cn.JInterest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @RequestMapping:
 *    value ： 所有请求地址的公共部分，叫做模块名称
 *    位置： 放在类的上面
 */
@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(HttpServletRequest request , String name, Integer age){
        System.out.println("doSome name="+name+"   age="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        mv.setViewName("show");

       // RequestDispatcher rd =request.getRequestDispatcher("/show.jsp");
       // rd.forward(request,null);

       // request.getRequestDispatcher("/show.jsp").forward(request,null);

        return mv;
    }



}
