package com.supra.petdbgemini.service;

import com.supra.petdbgemini.model.User;
import com.supra.petdbgemini.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Enforce data integrity (e.g., check for valid email format, password strength)
        if (user.getUsername() == null || user.getPassword() == null || user.getFirstName() == null ||
                user.getLastName() == null || user.getCounty() == null) {
            throw new IllegalArgumentException("Invalid user data");
        }

        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public void updateUser(String username, User user) {
        User existingUser = userRepository.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setCounty(user.getCounty());
        // Consider updating other fields as needed

        userRepository.save(existingUser);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void toggleUserLock(String username) {
        User existingUser = userRepository.findById(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setLocked(!existingUser.isLocked());
        userRepository.save(existingUser);
    }
}
