package com.lize.test;

import com.lize.utils.JDBCTools;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = JDBCTools.getConnection();
        System.out.println(connection);
    }
}
