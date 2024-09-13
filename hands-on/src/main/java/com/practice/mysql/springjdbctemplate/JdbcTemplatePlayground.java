package com.practice.mysql.springjdbctemplate;

import com.practice.mysql.entities.User;
import com.practice.mysql.service.UserService;
import com.practice.mysql.springjdbctemplate.configs.AppConfig;
import com.practice.mysql.springjdbctemplate.configs.DataSourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.beancontext.BeanContext;

public class JdbcTemplatePlayground {


    public static void main( String[] args){
        //UserService userService = null;

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, DataSourceConfig.class);

        // Get the UserService bean from the Spring context
        UserService userService = context.getBean(UserService.class);

        userService.createUser( new User(1L, "john_doe", "newemail@example.com") );
        System.out.println( "Create used after getting is "+ userService.getUserById( 1L ));
    }
}
