package com.study.hello.spring.basic.demo.selector;

import com.study.hello.spring.basic.demo.beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/1
 */
public class AppStartup {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = (Person) applicationContext.getBean(Person.class);
		System.out.println(person);
	}
}
