package com.bickyraj.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class DemoController {
    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "Welcome to stock market new world heheeh haha heheheheheheheheheh";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld()
    {
        return "Hello World!";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        String test = "test";
        return "Hello World with test";
    }
}
