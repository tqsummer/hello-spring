package com.study.hello.spring.basic.test;

import com.study.hello.spring.basic.beans.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoTest {

    @Test
    public void run() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context-test.xml");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person.getName());
    }
}
