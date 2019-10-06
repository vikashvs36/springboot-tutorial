package com.springBootTutorial.controller;

import com.springBootTutorial.domain.User;
import com.springBootTutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.update(id, user.getUsername(),user.getPassword());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        userService.deleteAll();
    }

}
