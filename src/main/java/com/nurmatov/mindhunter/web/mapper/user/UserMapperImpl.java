package com.nurmatov.mindhunter.web.mapper.user;

import com.nurmatov.mindhunter.domain.entity.user.User;
import com.nurmatov.mindhunter.web.dto.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    @Override
    public List<UserDto> toDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user:users) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }
}
