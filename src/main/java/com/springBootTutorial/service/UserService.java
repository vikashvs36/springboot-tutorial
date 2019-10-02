package com.springBootTutorial.service;

import com.springBootTutorial.domain.User;
import com.springBootTutorial.domain.vo.UserVo;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserService {

    List<User> list();

    User findById(@NotNull Long id);

    User save(@NotNull User user);

    User save(@NotNull UserVo userVo);

    User update(@NotNull Long id, @NotNull UserVo userVo);

    void delete(@NotNull Long id);

    void deleteAll();
}