package com.opencourse.cgcoursescrm.mapper;

import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.repository.entity.UserEntity;
import com.opencourse.cgcoursescrm.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(
                user.getUserId().toString(),
                user.getRole(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getPassword());
    }

    public User toDomain(UserDto userDto) {
        return new User(
                null,
                userDto.getRole(),
                userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getCreatedAt());
    }

    public User toDomain(String userId, UserDto userDto) {
        return new User(
                UUID.fromString(userId),
                userDto.getRole(),
                userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getCreatedAt());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getUserId(),
                userEntity.getRole(),
                userEntity.getFirstName(),
                userEntity.getSecondName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCreatedAt());
    }

    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(user.getUserId());
        userEntity.setRole(user.getRole());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setSecondName(user.getSecondName());
        userEntity.setEmail(user.getEmail());
        userEntity.setCreatedAt(user.getCreatedAt());
        userEntity.setPassword(user.getPassword());

        return userEntity;
    }
}
//        return new UserEntity(
//                user.getUserId(),
//                user.getRole(),
//                user.getFirstName(),
//                user.getSecondName(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getCreatedAt(),
//                Collections.emptyList());
