package com.study.hello.spring.basic.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: fangxiangqian
 * @Date: 2021/11/16
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("a"));
        System.out.println(set.add("a"));
    }
}
