package com.springBootTutorial.service;

import com.springBootTutorial.dao.UserDao;
import com.springBootTutorial.domain.User;
import com.springBootTutorial.domain.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, User> list() {
        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        if(id == null) throw  new NullPointerException("Id cann't be null");
        return userDao.findById(id);
    }

    @Override
    public User save(UserVo userVo) {
        User user = new User(userVo.getName());
        userDao.save(user);
        return userDao.findById(user.getId());
    }

    @Override
    public User update(String id, UserVo userVo) {
        userDao.update(new User(id, userVo.getName()));
        return userDao.findById(id);
    }

    @Override
    public User delete(String id) {
        User user = findById(id);
        if (user !=null ) userDao.delete(id);
        return user;
    }
}
