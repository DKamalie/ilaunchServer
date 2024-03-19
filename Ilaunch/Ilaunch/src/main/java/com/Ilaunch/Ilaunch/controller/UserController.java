package com.Ilaunch.Ilaunch.controller;

import com.Ilaunch.Ilaunch.domain.User;
import com.Ilaunch.Ilaunch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @GetMapping("/read/{id}")
    public User read(@PathVariable String id) {
        return userService.read(id);
    }
    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }
    @RequestMapping({"/getall"})
    public Set<User> getall() {
        return userService.getAll();
    }

}
