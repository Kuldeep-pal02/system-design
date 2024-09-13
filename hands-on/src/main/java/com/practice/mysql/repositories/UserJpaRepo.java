package com.practice.mysql.repositories;

import com.practice.mysql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends JpaRepository<User, Long> {
}
