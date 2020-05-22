package com.jessica.proxy.injector;

import com.jessica.proxy.annotation.EchoProxy;
import com.jessica.proxy.handler.EchoInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

/**
 * 用于为类中的带有EchoProxy注解类成员变量自动生成代理，并将成员变量赋值为代理类
 */
public class ProxyInjector {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProxyInjector.class);

	public static void initProxyForTarget(Object target) {
		Field[] fields = target.getClass().getDeclaredFields();
		Stream.of(fields).forEach(field -> {
			Class<?> fieldType = field.getType();
			// 只为带EchoProxy注解的接口类型的成员变量生成代理类
			if (field.isAnnotationPresent(EchoProxy.class) && fieldType.isInterface()) {
				try {
					//生成代理类
					Object proxy = Proxy.newProxyInstance(fieldType.getClassLoader(), new Class[]{fieldType}, new EchoInvocationHandler());
					// 设置成员变量的值为代理类
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
