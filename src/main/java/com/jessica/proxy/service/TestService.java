package com.jessica.proxy.service;

import com.jessica.proxy.annotation.EchoProxy;
import com.jessica.proxy.api.TestApi;
import com.jessica.proxy.injector.ProxyInjector;

import java.util.List;

public class TestService {
    @EchoProxy
    private TestApi testApi;

    public TestService() {
        ProxyInjector.initProxyForTarget(this);
    }

    public void testEcho1(String str) {
        this.testApi.echoStr(str);
    }

    public void testEcho2(List<String> strList) {
        this.testApi.echoStrList(strList);
    }
}
