package com.nurmatov.mindhunter.web.mapper.user;

import com.nurmatov.mindhunter.domain.entity.user.User;
import com.nurmatov.mindhunter.web.dto.user.UserDto;

import java.util.List;

public interface UserMapper {
    UserDto toDto(User user);
    List<UserDto> toDtos(List<User> user);
}
