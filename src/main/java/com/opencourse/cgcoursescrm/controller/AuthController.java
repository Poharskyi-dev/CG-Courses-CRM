package com.opencourse.cgcoursescrm.controller;

import com.opencourse.cgcoursescrm.controller.dto.AuthTokenDto;
import com.opencourse.cgcoursescrm.controller.dto.ErrorDto;
import com.opencourse.cgcoursescrm.controller.dto.LoginDto;
import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.domain.service.LoginService;
import com.opencourse.cgcoursescrm.domain.service.UserService;
import com.opencourse.cgcoursescrm.exception.PasswordIncorrectException;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import com.opencourse.cgcoursescrm.mapper.UserMapper;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserMapper userMapper;
    private final UserService userService;
    private final LoginService loginService;

    @Autowired
    public AuthController(UserMapper userMapper, UserService userService, LoginService loginService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody UserDto userDto) {

        User user = userMapper.toDomain(userDto);

        try {
            userService.createUser(user);
        } catch (Exception exception) {
            log.error(
                    "Error creating person with email {} and first name {}.",
                    userDto.getEmail(),
                    userDto.getFirstName(),
                    exception);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RateLimiter(name = "myRateLimiter")
    @PostMapping("/login")
    public ResponseEntity<AuthTokenDto> login(@RequestBody LoginDto loginDto) {

        String token = loginService.login(loginDto.getEmail(), loginDto.getPassword());

        return ResponseEntity.ok(new AuthTokenDto(token));

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handlePersonNotFoundException(UserNotFoundException e) {
        ErrorDto errorDto = new ErrorDto("Wrong credentials");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<ErrorDto> handlePasswordIncorrectException(PasswordIncorrectException e) {
        ErrorDto errorDto = new ErrorDto("Wrong credentials");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<ErrorDto> handleRequestNotPermittedException(RequestNotPermitted e) {
        ErrorDto errorDto = new ErrorDto("Rate limit exceeded");

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(errorDto);
    }
}