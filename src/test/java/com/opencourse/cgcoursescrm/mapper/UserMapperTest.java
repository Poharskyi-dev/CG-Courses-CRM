package com.opencourse.cgcoursescrm.mapper;

import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.repository.entity.UserEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper = new UserMapper();

    @Test
    void shouldMapDomainToDto() {
        //given
        User user = new User(
                UUID.fromString("77663953-df75-4e22-be44-50599698e1d7"),
                "admin",
                "Andrii",
                "P",
                "asd@asd.com",
                "12345678",
                null);
        //when
        UserDto userDto = userMapper.toDto(user);
        //then
        assertEquals(user.getUserId().toString(), userDto.getUserId());
        assertEquals(user.getRole(), userDto.getRole());
        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getSecondName(), userDto.getSecondName());
        assertEquals(user.getEmail(), userDto.getEmail());
        assertEquals(null, userDto.getPassword());
    }

    @Test
    void shouldMapDtoToDomain() {
        //given
        UserDto userDto = new UserDto(
                "77663953-df75-4e22-be44-50599698e1d7",
                "admin",
                "Andrii",
                "P",
                "asd@asd.com",
                "12345678",
                null);
        //when
        User user = userMapper.toDomain(userDto);
        //then
        assertEquals(null, user.getUserId().toString());
        assertEquals(userDto.getRole(), user.getRole());
        assertEquals(userDto.getFirstName(), user.getFirstName());
        assertEquals(userDto.getSecondName(), user.getSecondName());
        assertEquals(userDto.getEmail(), user.getEmail());
        assertEquals(userDto.getPassword(), user.getPassword());
    }

    @Test
    void shouldMapEntityToDomain() {
        //given
        UserEntity userEntity = new UserEntity(
                UUID.fromString("77663953-df75-4e22-be44-50599698e1d7"),
                "admin",
                "Andrii",
                "P",
                "asd@asd.com",
                "12345678",
                null);
        //when
        User user = userMapper.toDomain(userEntity);
        //then
        assertEquals(userEntity.getUserId(), user.getUserId());
        assertEquals(userEntity.getRole(), user.getRole());
        assertEquals(userEntity.getFirstName(), user.getFirstName());
        assertEquals(userEntity.getSecondName(), user.getSecondName());
        assertEquals(userEntity.getEmail(), user.getEmail());
        assertEquals(userEntity.getPassword(), user.getPassword());
    }

    @Test
    void shouldMapDomainToEntity() {
        //given
        User user = new User(
                UUID.fromString("77663953-df75-4e22-be44-50599698e1d7"),
                "admin",
                "Andrii",
                "P",
                "asd@asd.com",
                "12345678",
                null);
        //when
        UserEntity userEntity = userMapper.toEntity(user);
        //then
        assertEquals(user.getUserId(), userEntity.getUserId());
        assertEquals(user.getRole(), userEntity.getRole());
        assertEquals(user.getFirstName(), userEntity.getFirstName());
        assertEquals(user.getSecondName(), userEntity.getSecondName());
        assertEquals(user.getEmail(), userEntity.getEmail());
        assertEquals(userEntity.getPassword(), userEntity.getPassword());
    }
}