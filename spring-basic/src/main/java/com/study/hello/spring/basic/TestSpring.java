package com.study.hello.spring.basic;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context-test.xml");
        com.study.hello.spring.basic.beans.Person person = applicationContext.getBean(com.study.hello.spring.basic.beans.Person.class);
        System.out.println(person.getName());
    }

}
