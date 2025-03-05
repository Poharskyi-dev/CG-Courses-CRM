package com.opencourse.cgcoursescrm.controller;

import com.opencourse.cgcoursescrm.controller.dto.ErrorDto;
import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.domain.service.UserService;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import com.opencourse.cgcoursescrm.mapper.UserMapper;
import com.opencourse.cgcoursescrm.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    // Spring Security: admin
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.toDomain(userDto);

        User createdUser = userService.createUser(user);

        UserDto createdUserDto = userMapper.toDto(createdUser);

        return ResponseEntity.ok(createdUserDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();

        List<UserDto> userDtos = users.stream().map(userMapper::toDto).toList();

        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
        UUID userUUID = UUID.fromString(userId);

        User user = userService.getUserById(userUUID);

        UserDto userDto = userMapper.toDto(user);

        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable String userId, @RequestBody UserDto userDto) {
        UUID userUUID = UUID.fromString(userId);
        User user = userMapper.toDomain(userDto);

        User updatedUser = userService.updateUser(userUUID, user);

        UserDto updatedUserDto = userMapper.toDto(updatedUser);

        return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        UUID userUUID = UUID.fromString(userId);

        userService.deleteUser(userUUID);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException e) {
        ErrorDto errorDto = new ErrorDto(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}
