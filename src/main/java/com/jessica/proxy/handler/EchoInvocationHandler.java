package com.jessica.proxy.handler;

import com.jessica.proxy.annotation.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class EchoInvocationHandler implements InvocationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoInvocationHandler.class);

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Stream.of(objects).forEach(arg -> {
            LOGGER.debug("arg is {}", arg.toString());
            Task task = method.getAnnotation(Task.class);
            if (task != null) {
                LOGGER.debug("task type is {}", task.type());
            }
        });
        return null;
    }
}
