package com.example.webshop.controller;

import com.example.webshop.entity.User;
import com.example.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Create operation
    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // Read operations
    @GetMapping("/users/{id}")
    public User fetchUser(@PathVariable("id") Long id) {
        return userService.fetchUser(id);
    }

    @GetMapping("/users")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    // Update operation
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.updateUser(user, id);
    }

    // Delete operation
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
