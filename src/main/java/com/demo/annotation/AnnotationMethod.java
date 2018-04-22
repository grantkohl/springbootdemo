package com.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by lee on 2018/4/22.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnotationMethod {

    String value() default "";

}
