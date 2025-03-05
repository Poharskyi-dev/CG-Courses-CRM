package com.opencourse.cgcoursescrm.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID userId) {
        super("Person with ID: " + userId + " not found");
    }

    public UserNotFoundException(String email) {
        super("Person with email: " + email + " not found");
    }
}
