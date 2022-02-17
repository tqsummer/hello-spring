package com.study.hello.spring.basic.demo.aop;

import com.study.hello.spring.basic.demo.annotation.Hello;
import org.springframework.stereotype.Component;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/2
 */
@Component
public class HelloAopService {
	@Hello
	private HelloActionService helloActionService;

	public void say() {
		helloActionService.sayHello();
	}
}
