package com.study.hello.spring.basic.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/1
 */
public class AppStartup {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloAopService helloAopService = (HelloAopService) applicationContext.getBean("helloAopService");
		System.out.println(helloAopService);
		if(helloAopService!=null){
			helloAopService.say();
		}
	}
}
