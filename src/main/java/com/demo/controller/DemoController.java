package com.demo.controller;

import com.demo.annotation.AnnotationMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lee on 2018/4/22.
 */

@RestController
@RequestMapping(value = "/")
public class DemoController {

    @AnnotationMethod(value = "/index请求")
    @RequestMapping(value = "/index",method = {RequestMethod.GET, RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public String index(){
        System.out.println("hello world!");
        return "hello";
    }

    @RequestMapping("/log")
    public Object log() {
        return "log";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1/0;
    }
}
