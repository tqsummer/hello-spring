package com.study.hello.spring.basic.demo.ctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/13
 */
//@Component
public class UserService {

//    public UserService() {
//    }

    public UserService(OrderService orderService) {
        System.out.println(orderService);
    }

    public UserService(OrderService orderService,OrderService orderService1) {
    }
}
