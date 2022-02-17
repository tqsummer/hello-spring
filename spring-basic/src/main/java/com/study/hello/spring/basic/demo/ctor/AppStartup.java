package com.study.hello.spring.basic.demo.ctor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/1
 */
public class AppStartup {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(UserService.class);
		OrderService orderService = new OrderService();
		System.out.println(orderService);
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(orderService);
		context.registerBeanDefinition("userService",beanDefinition);
		context.refresh();
		context.getBean("userService");
	}
}
