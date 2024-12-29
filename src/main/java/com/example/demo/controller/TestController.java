package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {

    @GetMapping("/Kathy")
    public String Kathy(Model model){
        model.addAttribute("message","您好 JAVA Spring!");
        model.addAttribute("description", "這是學習的時光!");
        return "Kathy"; //return到 Kathy.jsp去show出messag的文字在頁面上
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error"; //return到error的jsp頁面
    }

    @GetMapping("/example")
    public String example(Model model){
        return "example"; 
    }
}
