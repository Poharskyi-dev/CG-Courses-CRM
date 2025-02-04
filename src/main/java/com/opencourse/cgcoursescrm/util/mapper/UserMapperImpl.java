package com.opencourse.cgcoursescrm.util.mapper;

import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.repository.entity.UserEntity;
import com.opencourse.cgcoursescrm.service.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setLastName(user.getSecondName());
        userDto.setFirstName(user.getFirstName());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

    @Override
    public User toDomain(UserEntity userEntity) {
        User user = new User();
        user.setUserId(userEntity.getUserId().toString());
        user.setRole(userEntity.getRole());
        user.setFirstName(userEntity.getFirstName());
        user.setSecondName(userEntity.getSecondName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setCreatedAt(userEntity.getCreatedAt());
        return user;
    }
}
