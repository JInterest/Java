package cn.JInterest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/06/07  12:23
 */
@Controller
public class indexController {

    @RequestMapping("/index")
    @ResponseBody
    public String say(Model model){
        model.addAttribute("msg","msg");
        return "hello world" +model.getAttribute("msg");
    }
}
