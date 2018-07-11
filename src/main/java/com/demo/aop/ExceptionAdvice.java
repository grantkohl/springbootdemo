package com.demo.aop;

import com.demo.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;

public class ExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        Result result;

        try {
            result = (Result) pjp.proceed();
            LOGGER.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private Result handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result result = new Result(false);
        pjp.getArgs();

        // 已知异常
        if (e instanceof BindException) {
            result.setErrorMessage(((BindException) e).getMessage());
        } else {
            LOGGER.error(pjp.getSignature() + " error ", e);
            //@TODO 添加统一非包装日志提示
            result.setErrorMessage("程序未知错误!");
        }

        return result;
    }
}

