package com.opencourse.cgcoursescrm.domain.service;

import com.opencourse.cgcoursescrm.domain.model.User;

import java.util.*;

public interface UserService {
    User createUser(User user);

    List<User> getUsers();

    User getUserById(UUID userId);

    User updateUser(UUID userId, User userToUpdateFrom);

    void deleteUser(UUID userId);
}




