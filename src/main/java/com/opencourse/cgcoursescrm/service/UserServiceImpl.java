package com.opencourse.cgcoursescrm.service;

import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import com.opencourse.cgcoursescrm.service.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        userMap.values()
                .forEach(user -> userList.add(user));

        return List.of();
    }

    @Override
    public User getUserById(String userId) throws UserNotFoundException {
        User user = userMap.get(userId);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }


        return userMap.get(userId);
    }

    @Override
    public void deleteUser(String userId) throws UserNotFoundException {
        if (userMap.containsKey(userId)) {
            userMap.remove(userId);
        }
        throw new UserNotFoundException("User with ID " + userId + " not found and cannot be deleted");
    }

    @Override
    public User createUser(String firstName, String email, String password) {
        String userId = UUID.randomUUID().toString();

        User user = new User();
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(password);
        return userMap.put(userId, user);
    }

    @Override
    public User updateUser(String userId, String firstName, String secondName, String email, String password, String role) throws UserNotFoundException {
        User user = userMap.get(userId);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }

        boolean isFirstNameUpdated = firstName != null && !firstName.equals(user.getFirstName());
        boolean isEmailUpdated = email != null && !email.equals(user.getEmail());
        boolean isPasswordUpdated = password != null && !password.equals(user.getPassword());
        boolean isRoleUpdated = role != null && !role.equals(user.getRole());
        boolean isSecondNameUpdated = firstName != null && !secondName.equals(user.getFirstName());


        //
        if (!isFirstNameUpdated && !isEmailUpdated && !isPasswordUpdated) {
            throw new IllegalStateException("No fields were updated. All values are the same.");
        }

        // Обновляем поля
        if (isFirstNameUpdated) {
            user.setFirstName(firstName);
        }
        if (isEmailUpdated) {
            user.setEmail(email);
        }
        if (isPasswordUpdated) {
            user.setPassword(password);
        }
        if (isRoleUpdated) {
            user.setRole(role);
        }
        if (isSecondNameUpdated) {
            user.setSecondName(secondName);
        }

        return userMap.put(userId, user);
    }
}



