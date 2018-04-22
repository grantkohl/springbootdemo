package com.demo.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by lee on 2018/4/21.
 * Target 作用范围
 * Retention 注解的生命周期
 * ElementType RetentionPolicy 枚举类
 * TYPE 标明该注解可以用于类、接口或enum
 * RUNTIME 注解信息将在运行期(JVM)也保留，因此可以通过反射机制读取注解的信息
 *
 * Documented 表明这个注解应该被 javadoc工具记录
 * Component 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface AnnotationDemo {

    String value() default "";

}

