package com.practice.mysql.springjdbctemplate.configs;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.practice.mysql.models.DatabaseConstants.*;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    public DataSource mysqlDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl( JDBC_URL);
        driverManagerDataSource.setUsername( USERNAME );
        driverManagerDataSource.setPassword( System.getenv( MYSQL_PASSWORD ) );
        return driverManagerDataSource;
    }

    @Bean
    public DataSource hikariPoolDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl( JDBC_URL );
        hikariDataSource.setUsername( USERNAME );
        hikariDataSource.setPassword( System.getenv( MYSQL_PASSWORD ) );
        hikariDataSource.setPoolName( "Hikari-Pool-1" );
        return hikariDataSource;
    }

    @Bean
    @Primary
    public JdbcTemplate myJdbcTemplate( DataSource dataSource ){
        return new JdbcTemplate( dataSource );
    }

    @Bean
    public JdbcTemplate myJdbcTemplateWithPooling( @Qualifier("hikariPoolDataSource")  DataSource dataSource ){
        return new JdbcTemplate( dataSource );
    }
}
