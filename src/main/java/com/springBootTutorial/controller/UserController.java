package com.springBootTutorial.controller;

import com.springBootTutorial.domain.User;
import com.springBootTutorial.domain.vo.UserVo;
import com.springBootTutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findOne(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value ="/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody @Valid UserVo userVo) {
        return userService.save(userVo);
    }

    @RequestMapping(value ="/users/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User update(@PathVariable Long id, @RequestBody @Valid UserVo userVo) {
        return userService.update(id, userVo);
    }

    @RequestMapping(value ="/users", method = RequestMethod.DELETE)
    public void deleteALL() {
        userService.deleteAll();
    }

    @RequestMapping(value ="/users/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }
}