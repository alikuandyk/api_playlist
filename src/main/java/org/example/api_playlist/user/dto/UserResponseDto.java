package org.example.api_playlist.user.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
    int id;
    String name;
    String email;
    LocalDateTime created;
}
