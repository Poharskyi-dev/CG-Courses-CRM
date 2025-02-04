package com.opencourse.cgcoursescrm.service;

import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import com.opencourse.cgcoursescrm.service.domain.User;

import java.util.List;

public interface UserService {

    User createUser(String firstName, String email, String password);

    List<User> getUsers();

    User getUserById(String userId) throws UserNotFoundException;

    void deleteUser(String userId) throws UserNotFoundException;

    User updateUser(String userId, String firstName, String secondName, String email, String password, String role) throws UserNotFoundException;
}
