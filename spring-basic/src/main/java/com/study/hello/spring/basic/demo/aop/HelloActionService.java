package com.study.hello.spring.basic.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/2
 */
@Component
public class HelloActionService {

	public void sayHello() {
		System.out.println("hello");
	}
}
