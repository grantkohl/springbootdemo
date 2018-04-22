package com.demo.util;


import com.demo.annotation.AnnotationMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by lee on 2018/4/22.
 * Aspect AOP切面
 */

@Aspect
@Component
public class LogAspectWithAnnotationMehod {

    //切入点
    @Pointcut(value = "@annotation(com.demo.annotation.AnnotationMethod)")
    private void pointcut(){

    }

    //方法执行前后
    @Around(value = "pointcut() && @annotation(annotationMethod)")
    public Object around(ProceedingJoinPoint point, AnnotationMethod annotationMethod){

        System.out.println("执行around方法====》begin");

        String value=annotationMethod.value();

        Class clazz=point.getTarget().getClass();

        Method method=((MethodSignature)point.getSignature()).getMethod();

        System.out.println("执行了 类:" + clazz + " 方法:" + method + " 自定义请求地址:" + value);

        try {
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }

    }

    @AfterReturning(value="pointcut() && @annotation(method)",returning = "result")
    public Object afterReturning(JoinPoint point,AnnotationMethod method,Object result){

        System.out.println("执行afterReturning方法====》begin");

        System.out.println("执行结果："+result);

        return result;
    }

    @AfterThrowing(value = "pointcut() && @annotation(method)", throwing = "e")
    public void afterThrowing(JoinPoint point,AnnotationMethod method,Exception e){
        System.out.println("执行afterThrowing方法====》begin");
    }
}
