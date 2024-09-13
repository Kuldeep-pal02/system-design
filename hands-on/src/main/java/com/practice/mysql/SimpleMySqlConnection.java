package com.practice.mysql;

import java.sql.*;

public class SimpleMySqlConnection {
    public static void main( String[] args){
        String jdbcUrl = "jdbc:mysql://localhost:3306/system_design";
        String username = "root";
        String password = System.getenv("MYSQL_PASSWORD");
        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database successfully!");
            playWithJDBCConnection( connection );
            connection.close();
        }catch ( Exception e ){
            e.printStackTrace();
            System.out.println("CANNOT Connected to the database!");
        }
    }
    private static  void playWithJDBCConnection ( Connection connection ) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("Show Databases");

        while (rs.next()) {
            System.out.println("==" + rs.getString(1));
        }
    }
}
