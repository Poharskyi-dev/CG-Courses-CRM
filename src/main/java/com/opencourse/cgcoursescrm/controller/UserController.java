package com.opencourse.cgcoursescrm.controller;

import com.opencourse.cgcoursescrm.controller.dto.CreateUserDto;
import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<String, UserDto> userMap = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<UserDto>> getPersons() {
        List<UserDto> userDtoList = new ArrayList<>();

        userMap.values()
                .forEach(userDto -> userDtoList.add(userDto));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDtoList);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        String userId = UUID.randomUUID().toString();

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setFirstName(createUserDto.getFirstName());
        userDto.setEmail(createUserDto.getEmail());
        userDto.setPassword(createUserDto.getPassword());

        userMap.put(userId, userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
}







