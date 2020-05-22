package com.jessica.proxy;

import com.jessica.proxy.service.TestService;

import java.util.Arrays;

public class ProxyTest {

	public static void main(String[] args) {
		TestService test = new TestService();
		test.testEcho1("test");
		test.testEcho2(Arrays.asList("1", "2", "3"));
	}
}
