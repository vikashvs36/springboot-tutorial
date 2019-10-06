package com.springBootTutorial.service;

import com.springBootTutorial.domain.User;

import java.util.List;

public interface UserService {

    User findById(String id);

    List<User> findAll();

    User save(User user);

    User update(String id, String username, String password);

    void deleteById(String id);

    void deleteAll();
}
