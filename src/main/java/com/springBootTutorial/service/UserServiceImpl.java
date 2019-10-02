package com.springBootTutorial.service;

import com.springBootTutorial.dao.UserDao;
import com.springBootTutorial.domain.User;
import com.springBootTutorial.domain.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public User findById(@NotNull Long id) {
        Optional<User> user = userDao.findById(id);
        return user.isPresent() ? user.get(): null;
    }

    @Override
    public User save(@NotNull User user) {
        return userDao.save(user);
    }

    @Override
    public User save(@NotNull UserVo userVo) {
        return userDao.save(new User(userVo.getUsername(), userVo.getPassword()));
    }

    @Override
    public User update(@NotNull Long id, @NotNull UserVo userVo) {
        User user = findById(id);
        if (user == null) {
            return null;
        }
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        return save(user);
    }

    @Override
    public void delete(@NotNull Long id) {
        userDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
