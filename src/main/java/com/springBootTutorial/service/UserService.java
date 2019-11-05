package com.springBootTutorial.service;

import com.springBootTutorial.domain.User;
import com.springBootTutorial.domain.vo.UserVo;

import java.util.Map;

public interface UserService {

    Map<String, User> list();

    User findById(String id);

    User save(UserVo userVo);

    User update(String id, UserVo userVo);

    User delete(String id);

}
