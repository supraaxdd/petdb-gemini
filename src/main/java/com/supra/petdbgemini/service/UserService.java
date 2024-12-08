package com.supra.petdbgemini.service;

import com.supra.petdbgemini.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    void updateUser(String username, User user);
    void deleteUserByUsername(String username);
    void toggleUserLock(String username);
}