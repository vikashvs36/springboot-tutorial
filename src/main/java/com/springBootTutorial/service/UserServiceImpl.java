package com.springBootTutorial.service;

import com.springBootTutorial.dao.UserDao;
import com.springBootTutorial.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(String id) {
        Optional<User> user = userDao.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(String id, String username, String password) {
        User user = findById(id);
        if (user == null) {
            return null;
        }
        user.setUsername(username);
        user.setPassword(password);
        return save(user);
    }

    @Override
    public void deleteById(String id) {
        Assert.notNull(id, "The given id must not be null!");
        userDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
