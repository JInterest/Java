package cn.JInterest.controller;

import cn.JInterest.model.Student;
import cn.JInterest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/07  17:11
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/query")
    @ResponseBody
    public ModelAndView query(Integer id){
        Student student = studentService.queryStudent(id);

        ModelAndView mv=new ModelAndView();
        if (student!= null){
            mv.addObject("student",student);
            mv.setViewName("showInfo");
        }else {
            mv.addObject("msg","该学生不存在");
            mv.setViewName("tip");
        }

        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ModelAndView add(Student student){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","学生"+student.getName()+"注册失败");

        int result = studentService.addStudent(student);
        if (result>0){
            mv.addObject("msg","学生"+student.getName()+"注册成功");
        }
        mv.setViewName("tip");
        return mv;
    }
    @RequestMapping("/del")
    @ResponseBody
    public ModelAndView del(Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","删除失败");

        int result = studentService.delStudent(id);
        if (result>0){
            mv.addObject("msg","删除成功");
        }
        mv.setViewName("tip");
        return mv;
    }
}
