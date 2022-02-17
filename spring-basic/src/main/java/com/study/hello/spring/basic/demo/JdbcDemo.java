package com.study.hello.spring.basic.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: fangxiangqian
 * @Date: 2021/11/16
 */
public class JdbcDemo {
    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://10.241.25.222:3306/op_huajinsc?useUnicode=true&characterEncoding=UTF-8&serverTimezone=CTT", "root", "123456");
    }
}
