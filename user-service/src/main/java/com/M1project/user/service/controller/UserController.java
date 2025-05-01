package com.M1project.user.service.controller;

import com.M1project.user.service.exception.UserException;
import com.M1project.user.service.model.User;

import com.M1project.user.service.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody  @Valid User user) {
       User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
        
    }

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) throws Exception {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) throws Exception{
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.ACCEPTED);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
