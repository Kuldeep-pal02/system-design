package com.practice.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleMySqlConnection {
    public static void main( String[] args){
        String jdbcUrl = "jdbc:mysql://localhost:3306/system_design";
        String username = "root";
        String password = System.getenv("MYSQL_PASSWORD");
        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database successfully!");
            connection.close();
        }catch ( Exception e ){
            e.printStackTrace();
            System.out.println("CANNOT Connected to the database!");
        }
    }
}
