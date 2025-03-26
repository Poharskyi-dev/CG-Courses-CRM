package com.opencourse.cgcoursescrm.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public class UserDto {

    @JsonProperty(value = "user_id", access = JsonProperty.Access.READ_ONLY)
    private final String userId;
    private final String role;
    @JsonProperty("first_name")
    private final String firstName;
    @JsonProperty("last_name")
    private final String secondName;
    private final String email;
    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private final Instant createdAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String password;



    public UserDto(String userId, String role, String firstName, String secondName, String email, Instant createdAt, String password) {
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

    public Instant getCreatedAt() {
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