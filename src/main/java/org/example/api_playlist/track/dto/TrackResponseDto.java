package org.example.api_playlist.track.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackResponseDto {
    int id;
    String name;
    String artist;
}
