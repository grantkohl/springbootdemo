package com.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {

    //切入点
    @Pointcut(value = "@annotation(com.demo.config.DataSource)")
    private void pointcut(){

    }

    @Around(value = "pointcut() && @annotation(dataSource)")
    public void beforeSwitchDS(ProceedingJoinPoint point, DataSource dataSource){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();

        System.out.println("========="+methodName);

        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSourceName = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                // 取出注解中的数据源名
                dataSourceName = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDB(dataSourceName);
    }

    @After(value = "@annotation(DataSource)")
    public void afterSwitchDS(JoinPoint point){

        System.out.println("++++++++++++++++++++");

        DataSourceContextHolder.clearDB();
    }
}
