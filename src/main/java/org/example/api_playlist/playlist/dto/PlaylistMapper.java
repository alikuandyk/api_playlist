package org.example.api_playlist.playlist.dto;

import org.example.api_playlist.playlist.Playlist;
import org.example.api_playlist.track.dto.TrackMapper;
import org.example.api_playlist.track.dto.TrackResponseDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PlaylistMapper {
    private final TrackMapper trackMapper;

    public PlaylistMapper(TrackMapper trackMapper) {
        this.trackMapper = trackMapper;
    }

    public PlaylistResponseDto toResponse(Playlist playlist) {
        PlaylistResponseDto playlistResponseDto = new PlaylistResponseDto();

        playlistResponseDto.setId(playlist.getId());
        playlistResponseDto.setAuthor(playlist.getAuthor().getId());

        List<TrackResponseDto> tracks = playlist.getTracks() != null
                ? playlist.getTracks().stream().map(trackMapper::toResponse).toList()
                : Collections.emptyList();

        playlistResponseDto.setTracks(tracks);

        return playlistResponseDto;
    }
}
