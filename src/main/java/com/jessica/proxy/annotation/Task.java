package com.jessica.proxy.annotation;

import java.lang.annotation.*;

/**
 * 作用于接口的方法上
 * 用于标识方法所属的任务类型
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Task {
    String type() default "";
}
