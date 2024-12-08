package com.supra.petdbgemini;

import com.supra.petdbgemini.model.User;
import com.supra.petdbgemini.repository.UserRepository;
import com.supra.petdbgemini.service.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

//    @Test
//    public void testCreateUser() {
//        User user = User.builder()
//                .username("testuser")
//                .password("password")
//                .firstName("John")
//                .lastName("Doe")
//                .county("Dublin")
//                .role(User.Role.USER)
//                .build();
//
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        when(passwordEncoder.encode(user.getPassword())).thenReturn("$2a$10$/.specT6WemgxsnB.XpRcMuu/Eq29XZhGL9bwDO1v2R.jGOcJ12vH6."); // Example hash
//
//        User createdUser = userService.createUser(user);
//
//        assertEquals(user, createdUser);
//        verify(userRepository, times(1)).save(any(User.class));
//        verify(passwordEncoder, times(1)).encode(user.getPassword());
//    }

    @Test
    public void testGetUserByUsername() {
        User user = User.builder()
                .username("testuser")
                .password("password")
                .firstName("John")
                .lastName("Doe")
                .county("Dublin")
                .role(User.Role.USER)
                .build();

        when(userRepository.findById("testuser")).thenReturn(Optional.of(user));

        User foundUser = userService.getUserByUsername("testuser");

        assertEquals(user, foundUser);
    }

    @Test
    public void testGetUserByUsernameNotFound() {
        when(userRepository.findById("nonexistentuser")).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.getUserByUsername("nonexistentuser"));
    }

}