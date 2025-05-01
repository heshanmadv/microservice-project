package com.M1project.user.service.controller;

import com.M1project.user.service.model.User;
import com.M1project.user.service.repositary.UserRepositary;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserRepositary userRepositary;

    @PostMapping("/api/users")
    public String createUser(@RequestBody  @Valid User user) {
        return userRepositary.save(user).toString();
    }
    @GetMapping("/api/users")
    public List<User> getUsers() {

        return userRepositary.findAll();
    }

    @PutMapping("/api/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepositary.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            return userRepositary.save(existingUser).toString();
        }
        return "User not found";
    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        User existingUser = userRepositary.findById(id).orElse(null);
        if (existingUser != null) {
            userRepositary.delete(existingUser);
            return "User deleted successfully";
        }
        return "User not found";
    }



}
