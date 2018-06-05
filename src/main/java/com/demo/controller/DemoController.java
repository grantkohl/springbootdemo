package com.demo.controller;

import com.demo.annotation.AnnotationMethod;
import com.demo.service.DemoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lee on 2018/4/22.
 */

@RestController
@RequestMapping(value = "/")
public class DemoController {

    @Resource
    DemoService demoService;

//    @AnnotationMethod(value = "/index请求")
    @RequestMapping(value = "/index",method = {RequestMethod.GET, RequestMethod.POST},produces = "application/json;charset=UTF-8")
//    @Transactional
    public String index(){
        System.out.println("hello xxxxxx world!");

        try{
            demoService.insert();
//            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
            //捕获异常后加这一句可以回滚
            //如果方法未加Transactional，则不会回滚
            //纵然是exception,设置如下也可以回滚，而不必设定rollbackfor
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }


        return "hello xxxxx";
    }

//    @RequestMapping("/log")
//    public Object log() {
//        return "log";
//    }
//
//    @RequestMapping("/doError")
//    public Object error() {
//        return 1/0;
//    }
}
