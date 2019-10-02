package com.springBootTutorial.dao;

import com.springBootTutorial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
