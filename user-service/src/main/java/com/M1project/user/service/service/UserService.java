package com.M1project.user.service.service;

import java.util.List;

import com.M1project.user.service.exception.UserException;
import com.M1project.user.service.model.User;

public interface UserService  {
    User createUser(User user) ;
    User getUserById(Long id) throws Exception;
    User updateUser(Long id, User user) throws Exception;
    void deleteUser(Long id) throws UserException;
    List<User> getAllUsers() ;
    
}
  