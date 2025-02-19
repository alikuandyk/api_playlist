package org.example.api_playlist.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.api_playlist.user.dto.UserCreateDto;
import org.example.api_playlist.user.dto.UserMapper;
import org.example.api_playlist.user.dto.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public UserResponseDto create(
            @Valid @RequestBody UserCreateDto userCreateDto
    ) {
        User user = userMapper.fromCreate(userCreateDto);
        return userMapper.toResponse(userService.create(user));
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable int id) {
        User user = userService.findById(id);
        return userMapper.toResponse(user);
    }

    @GetMapping
    public List<UserResponseDto> findAll() {
        List<UserResponseDto> userResponseDtos =
                userService.findAll().stream()
                        .map(userMapper::toResponse)
                        .toList();

        return userResponseDtos;
    }
}
