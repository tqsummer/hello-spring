package com.study.hello.spring.basic.demo.selector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/1
 */
@ComponentScan("com.study.hello.spring.basic.demo.selector")
@Configuration
@Import(HelloDeferredImportSelector.class)
public class AppConfig {
}
