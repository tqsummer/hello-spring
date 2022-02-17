package com.study.hello.spring.fw.framework;

/**
 *
 */
public class HelloAnnotationConfigApplicationContext {
    public HelloAnnotationConfigApplicationContext(Class configClazz) {
        //扫描启动类
        scan(configClazz);
    }

    /**
     * 扫描启动类
     * @param configClazz
     */
    private void scan(Class configClazz) {
    }
}
