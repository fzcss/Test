package com.example.demo.drom.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StudentHandler {

    @RequestMapping("/all")
    public String allStu(){
        System.out.println("dd");
        return "/aaa.jsp";
    }
}
