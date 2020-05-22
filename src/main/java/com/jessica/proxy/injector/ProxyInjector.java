package com.jessica.proxy.injector;

import com.jessica.proxy.annotation.EchoProxy;
import com.jessica.proxy.handler.EchoInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

public class ProxyInjector {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyInjector.class);

    public static void initProxyForTarget(Object target) {
        Field[] fields = target.getClass().getDeclaredFields();
        Stream.of(fields).forEach(field -> {
            if (field.isAnnotationPresent(EchoProxy.class)) {
                try {
                    Object proxy = Proxy.newProxyInstance(field.getType().getClassLoader(), new Class[]{field.getType()}, new EchoInvocationHandler());
                    field.setAccessible(true);
                    field.set(target, proxy);
                } catch (Exception exception) {
                    LOGGER.error(exception.getMessage());
                    throw new RuntimeException(exception);
                }
            }
        });

    }
}
