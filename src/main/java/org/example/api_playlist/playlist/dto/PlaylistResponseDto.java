package org.example.api_playlist.playlist.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.api_playlist.track.dto.TrackResponseDto;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistResponseDto {
    int id;
    List<TrackResponseDto> tracks;
    int author;
}
