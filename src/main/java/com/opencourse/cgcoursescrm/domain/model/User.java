package com.opencourse.cgcoursescrm.domain.model;

import lombok.Setter;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class User {

    @Setter
    private UUID userId;
    private String role;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private Instant createdAt;

    public User(UUID userId, String role, String firstName, String secondName, String email, String password, Instant createdAt) {
        this.userId = userId;
        this.role = role;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole() {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName() {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void update(User user) {
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.email = user.getEmail();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User userDto = (User) o;
        return Objects.equals(userId, userDto.userId)
                && Objects.equals(firstName, userDto.firstName)
                && Objects.equals(secondName, userDto.secondName)
                && Objects.equals(email, userDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, secondName, email);
    }

}
