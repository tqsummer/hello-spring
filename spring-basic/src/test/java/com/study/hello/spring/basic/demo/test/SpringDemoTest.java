package com.study.hello.spring.basic.demo.test;

import com.study.hello.spring.basic.demo.beans.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoTest {

    @Test
    public void run() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context-test.xml");
        Person person = applicationContext.getBean(Person.class);
    }
}
