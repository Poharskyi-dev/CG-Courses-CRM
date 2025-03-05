package com.opencourse.cgcoursescrm.domain.repository;

import com.opencourse.cgcoursescrm.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(UUID id);

    void delete(User user);

}
