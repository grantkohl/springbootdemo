package com.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    public String processException(Exception e){
        String msg = "all exception "+e.getMessage();
        System.out.println(msg);
        return msg;
    }

}
