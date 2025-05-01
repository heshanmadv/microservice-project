package com.M1project.user.service.service.impl;

import java.util.List;
import java.util.Optional;

import com.M1project.user.service.exception.UserException;
import com.M1project.user.service.model.User;
import com.M1project.user.service.repositary.UserRepositary;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.M1project.user.service.service.UserService;


@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    
    private final UserRepositary userRepositary;
    @Override
    public User createUser(User user) {
        return userRepositary.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
       Optional<User> otp = userRepositary.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new UserException("user not found");
    }

    @Override
    public User updateUser(Long id, User user) throws Exception {
        Optional <User> otp = userRepositary.findById(id);
        if (otp.isEmpty()) {
            throw new Exception("user not found with id"+id);
        }
        User existingUser = otp.get();
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            existingUser.setPassword(user.getPassword());
            existingUser.setUserName(user.getUserName());
        return userRepositary.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) throws UserException {
      Optional<User> otp = userRepositary.findById(id);
        if (otp.isEmpty()) {
            throw new UserException("User not found with id: " + id);
        }
        userRepositary.deleteById(otp.get().getId());
      
        
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositary.findAll();
    }
    
}
