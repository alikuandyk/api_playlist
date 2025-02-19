package org.example.api_playlist.user.dto;

import org.example.api_playlist.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User fromCreate(UserCreateDto userCreateDto) {
        User user = new User();

        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
//        user.setCreated(userCreateDto.getCreated());
        return user;
    }

    public UserResponseDto toResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
//        userResponseDto.setCreated(user.getCreated());

        return userResponseDto;
    }
}
