package com.practice.mysql;

import java.sql.*;

import static com.practice.mysql.models.DatabaseConstants.*;

public class SimpleMySqlConnection {
    public static void main( String[] args){
        String jdbcUrl = JDBC_URL;
        String username = USERNAME ;
        String password = System.getenv( MYSQL_PASSWORD );
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
