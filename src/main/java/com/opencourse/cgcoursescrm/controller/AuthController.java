package com.opencourse.cgcoursescrm.controller;

import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.domain.service.UserService;
import com.opencourse.cgcoursescrm.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public AuthController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody UserDto userDto) {

        User user = userMapper.toDomain(userDto);

        try {
            userService.createUser(user);
        } catch (Exception e) {
            log.error(
                    "Error creating person with email {} and first name {}.",
                    userDto.getEmail(),
                    userDto.getFirstName());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
