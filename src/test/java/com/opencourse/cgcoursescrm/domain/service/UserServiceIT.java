package com.opencourse.cgcoursescrm.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")

/*
 * @Transactional Ensures that each test runs in a transaction
 * that is rolled back after the test,
 * keeping the database in a clean state.
 */
@Transactional
class UserServiceIT {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldCreateUserAndEncodePassword() {
        // given: a new User with a plain password
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("plainPassword");

        // when: creating the user
        User savedUser = userService.createUser(user);

        // then: the user is saved and the password is encoded
        assertNotNull(savedUser.getUserId(), "User ID should not be null after saving");
        assertNotEquals("plainPassword", savedUser.getPassword(), "Password should be encoded");
        assertTrue(
                passwordEncoder.matches("plainPassword", savedUser.getPassword()),
                "Encoded password should match the raw password");
    }

    @Test
    void shouldRetrieveUserById() {
        // given: a saved user
        User user = new User();
        user.setEmail("retrieve@example.com");
        user.setPassword("password123");
        User savedUser = userService.createUser(user);

        // when: retrieving the user by ID
        User foundUser = userService.getUserById(savedUser.getUserId());

        // then: the retrieved user matches the saved user
        assertNotNull(foundUser, "Retrieved user should not be null");
        assertEquals(savedUser.getUserId(), foundUser.getUserId(), "IDs should match");
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        // given: a random UUID that does not exist
        UUID randomId = UUID.randomUUID();

        // then: getUserById throws UserNotFoundException
        assertThrows(
                UserNotFoundException.class,
                () -> userService.getUserById(randomId),
                "Expected UserNotFoundException for non-existing ID");
    }

    @Test
    void shouldUpdateUser() {
        // given: a saved user
        User user = new User();
        user.setEmail("update@example.com");
        user.setPassword("oldPassword");
        User savedUser = userService.createUser(user);

        // Prepare updated data
        User updateInfo = new User();
        updateInfo.setEmail("updated@example.com");

        // when: updating the user
        User updatedUser = userService.updateUser(savedUser.getUserId(), updateInfo);

        // then: the user has updated fields
        assertEquals("updated@example.com", updatedUser.getEmail(), "Email should be updated");
    }

    @Test
    void shouldDeleteUser() {
        // given: a saved user
        User user = new User();
        user.setEmail("delete@example.com");
        user.setPassword("passwordToDelete");
        User savedUser = userService.createUser(user);

        // when: deleting the user
        userService.deleteUser(savedUser.getUserId());

        // then: retrieving the user should throw UserNotFoundException
        assertThrows(
                UserNotFoundException.class,
                () -> userService.getUserById(savedUser.getUserId()),
                "Expected exception when retrieving deleted user");
    }

    @Test
    void shouldRetrieveAllUserss() {
        // given: create two users
        User user1 = new User();
        user1.setFirstName("First Name 1");
        user1.setSecondName("Last Name 1");
        user1.setEmail("user1@example.com");
        user1.setPassword("pass1");

        User user2 = new User();
        user2.setFirstName("First Name 2");
        user2.setSecondName("Last Name 2");
        user2.setEmail("user2@example.com");
        user2.setPassword("pass2");

        userService.createUser(user1);
        userService.createUser(user2);

        // when: retrieving all users
        List<User> users = userService.getUsers();

        // then: the list should contain at least 2 users
        assertTrue(users.size() >= 2, "There should be at least 2 users in the database");
    }
}