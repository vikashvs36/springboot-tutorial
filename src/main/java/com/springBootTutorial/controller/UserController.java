package com.springBootTutorial.controller;

import com.springBootTutorial.domain.User;
import com.springBootTutorial.domain.vo.UserVo;
import com.springBootTutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Map<String, User> list() {
        System.out.println("com.springBootTutorial.controller.UserController.list - Date : "+new Date());
        return userService.list();
    }

    @GetMapping(value = "/users/{id}")
    public User findById(@PathVariable String id) {
        System.out.println("com.springBootTutorial.controller.UserController.findById - Date : "+new Date());
        return userService.findById(id);
    }

    @PostMapping(value = "/users")
    public User save(@RequestBody UserVo userVo) {
        System.out.println("com.springBootTutorial.controller.UserController.save - Date : "+new Date());
        return userService.save(userVo);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable String id, @RequestBody UserVo userVo) {
        System.out.println("com.springBootTutorial.controller.UserController.update - Date : "+new Date());
        return userService.update(id, userVo);
    }

    @DeleteMapping("/users/{id}")
    public User delete(@PathVariable String id) {
        System.out.println("com.springBootTutorial.controller.UserController.delete - Date : "+new Date());
        return userService.delete(id);
    }

}
