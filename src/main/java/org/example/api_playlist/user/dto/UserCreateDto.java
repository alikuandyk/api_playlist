package org.example.api_playlist.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateDto {
    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String name;

    @NotBlank(message = "Почта пользователя не может быть пустым")
    @Email(message = "Почта пользователя должна быть в формате \"user@mail.com\"")
    private String email;

    LocalDateTime created = LocalDateTime.now();
}
