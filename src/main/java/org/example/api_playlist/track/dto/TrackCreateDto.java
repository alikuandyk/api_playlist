package org.example.api_playlist.track.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackCreateDto {
    @NotBlank(message = "Песня не может без названия")
    String name;

    String artist;
}
