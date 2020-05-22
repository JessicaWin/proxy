package com.jessica.proxy.annotation;

import java.lang.annotation.*;

/**
 * 作用于类的接口成员变量上
 * 用于作为是否要为类的接口成员变量进行代理的标识
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EchoProxy {
}
