package com.opencourse.cgcoursescrm.domain.service;

import com.opencourse.cgcoursescrm.domain.model.User;

public interface TokenService {

    String createToken(User user);

    boolean isValidToken(String token);

    String getCurrentUserId(String token);
}