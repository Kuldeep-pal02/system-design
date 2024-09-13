package com.practice.mysql.repositories;

import com.practice.mysql.entities.User;
import com.practice.mysql.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoWithPooling {

    @Qualifier("myJdbcTemplateWithPooling")
    private final JdbcTemplate jdbcTemplate;

    public UserRepoWithPooling(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User save(User user ){
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail());
        return user;
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }
}
