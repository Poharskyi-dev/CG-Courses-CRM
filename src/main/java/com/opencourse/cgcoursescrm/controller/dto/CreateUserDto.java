package com.opencourse.cgcoursescrm.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserDto {

    private String firstName;
    private String email;
    private String password;

    public CreateUserDto() {
    }

    public CreateUserDto(String password, String email, String firstName) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CreateUserDto{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}