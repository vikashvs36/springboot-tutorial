package com.springBootTutorial.dao;

import com.springBootTutorial.domain.User;

import java.util.Map;

public interface UserDao {

    void save(User user);

    Map<String, User> findAll();

    User findById(String id);

    void update(User user);

    void delete(String id);


}
