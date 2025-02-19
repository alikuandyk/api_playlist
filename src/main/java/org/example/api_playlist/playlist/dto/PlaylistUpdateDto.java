package org.example.api_playlist.playlist.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.api_playlist.track.Track;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistUpdateDto {
    List<Track> tracks;
}
