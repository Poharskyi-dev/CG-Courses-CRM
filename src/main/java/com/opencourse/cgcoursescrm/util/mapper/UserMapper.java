package com.opencourse.cgcoursescrm.util.mapper;

import com.opencourse.cgcoursescrm.controller.dto.UserDto;
import com.opencourse.cgcoursescrm.service.domain.User;

public interface UserMapper {
    UserDto toDto(User user);
    User toDomain(UserDto userDto);
}

