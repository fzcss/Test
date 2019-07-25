package com.example.demo;

import com.example.demo.drom.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.FileHandler;


@RestController() //等价于requestmapping+responsebody+Contrller+restfuk
public class UserHandler {
    @RequestMapping("/login")
    public ModelAndView login(@Validated User user, BindingResult result) {
        System.out.println("正在登陆...");
//        if(result.hasErrors()){
//            List<FieldError> errors = result.getFieldErrors();
//        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/aaa.jsp");
        return modelAndView;
    }
}
