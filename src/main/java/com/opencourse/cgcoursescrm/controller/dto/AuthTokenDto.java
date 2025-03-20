package com.opencourse.cgcoursescrm.controller.dto;

public class AuthTokenDto {
    private String token;

    public AuthTokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
