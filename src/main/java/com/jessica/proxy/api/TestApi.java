package com.jessica.proxy.api;

import com.jessica.proxy.annotation.Task;

import java.util.List;

/**
 * 被代理的接口
 */
public interface TestApi {
    /**
     *
     * @param str
     * @return
     */
    @Task(type = "echoStr")
    void echoStr(String str);

    /**
     *
     * @param strList
     * @return
     */
    @Task(type = "echoStrList")
    void echoStrList(List<String> strList);
}
