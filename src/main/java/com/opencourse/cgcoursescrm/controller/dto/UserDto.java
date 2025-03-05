package com.opencourse.cgcoursescrm.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty("user_id")
    private final String userId;
    private final String role;
    @JsonProperty("first_name")
    private final String firstName;
    @JsonProperty("last_name")
    private final String secondName;
    private final String email;
    @JsonProperty("created_at")
    private final String createdAt;
    private final String password;



    public UserDto(String userId, String role, String firstName, String secondName, String email, String createdAt, String password) {
        this.userId = userId;
        this.role = role;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}