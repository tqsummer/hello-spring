package com.study.hello.spring.boot.model;

import javax.validation.constraints.NotNull;

/**
 * @Author: fangxiangqian
 * @Date: 2022/1/26
 */
public class HelloAO {
    @NotNull
    private String param1;
    private String param2;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
