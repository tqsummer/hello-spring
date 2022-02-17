package com.study.hello.spring.boot.controllers;

import com.study.hello.spring.boot.model.HelloAO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: fangxiangqian
 * @Date: 2022/1/18
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/world")
    public String sayHi(){
        return "hello world fxq2";
    }

    @GetMapping("/world2")
    public String sayHi2(@Validated HelloAO helloAO){
        return "hello world 2";
    }

    @GetMapping("/world3")
    public String sayHi3(@Validated HelloAO helloAO, BindingResult bindingResult){
        System.out.println(bindingResult);
        return "hello world 3";
    }
}
