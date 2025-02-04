package com.opencourse.cgcoursescrm.controller;

import com.opencourse.cgcoursescrm.controller.dto.ErrorDto;
import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import com.opencourse.cgcoursescrm.service.UserService;
import com.opencourse.cgcoursescrm.service.domain.User;
import com.opencourse.cgcoursescrm.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> userList = userService.getUsers();

        List<UserDto> userDtoList = userList
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDtoList);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) throws UserNotFoundException {

        User user = userService.getUserById(userId);

        UserDto userDto = userMapper.toDto(user);

        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

        userService.deleteUser(userId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody UserDto updatedUser) {
            userService.updateUser(
                    userId,
                    updatedUser.getFirstName(),
                    updatedUser.getSecondName(),
                    updatedUser.getEmail(),
                    updatedUser.getPassword(),
                    updatedUser.getRole()
            );

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        userService.createUser(userDto.getFirstName(), userDto.getPassword(), userDto.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}