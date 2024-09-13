package com.practice.mysql.springjdbctemplate;

import com.practice.mysql.Utils.RandomStringGenerator;
import com.practice.mysql.entities.User;
import com.practice.mysql.service.UserService;
import com.practice.mysql.springjdbctemplate.configs.AppConfig;
import com.practice.mysql.springjdbctemplate.configs.DataSourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.beancontext.BeanContext;
import java.util.Random;
import java.util.UUID;

public class JdbcTemplatePlayground {


    public static void main( String[] args){
        //UserService userService = null;

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, DataSourceConfig.class);

        // Get the UserService bean from the Spring context
        UserService userService = context.getBean(UserService.class);

        Random random = new Random();
        Long id = random.nextLong();
        userService.createUser( new User( id , UUID.randomUUID().toString(), "44444@example.com") );
        perfWithJDBC( userService );
        System.out.println( "Create used after getting is "+ userService.getUserById( 4L ));
    }

    private static void  perfWithJDBC( UserService userService){

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Long id = random.nextLong();
            userService.createUser( new User( id , UUID.randomUUID().toString(), RandomStringGenerator.generateRandomString()+"@example.com") );
        }

        long endTime = System.currentTimeMillis();
        System.out.println("JDBC without pooling took: " + (endTime - startTime) + " ms");

    }private static void  perfWithHikariPooling( UserService userService){

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Long id = random.nextLong();
            userService.createUser( new User( id , UUID.randomUUID().toString(), RandomStringGenerator.generateRandomString()+"@example.com") );
        }

        long endTime = System.currentTimeMillis();
        System.out.println("JDBC without pooling took: " + (endTime - startTime) + " ms");

    }


}
