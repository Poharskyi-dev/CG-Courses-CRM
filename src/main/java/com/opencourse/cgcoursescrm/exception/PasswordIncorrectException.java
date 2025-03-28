package com.opencourse.cgcoursescrm.exception;

public class PasswordIncorrectException extends RuntimeException {

    public PasswordIncorrectException(String userEmail) {
        super("Password was incorrect for user " + userEmail);
    }
}
