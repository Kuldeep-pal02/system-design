package com.practice.mysql.springjdbctemplate.configs;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.practice.mysql.models.DatabaseConstants.*;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource mysqlDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl( JDBC_URL);
        driverManagerDataSource.setUsername( USERNAME );
        driverManagerDataSource.setPassword( System.getenv( MYSQL_PASSWORD ) );
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate myJdbcTemplate( DataSource dataSource ){
        return new JdbcTemplate( dataSource );
    }
}
