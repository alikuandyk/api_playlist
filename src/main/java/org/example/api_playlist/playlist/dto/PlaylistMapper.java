package org.example.api_playlist.playlist.dto;

import org.example.api_playlist.playlist.Playlist;
import org.example.api_playlist.track.Track;
import org.example.api_playlist.track.dto.TrackMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        playlistResponseDto.setTracks(playlist.getTracks().stream()
                .map(trackMapper::toResponse)
                .toList());

        return playlistResponseDto;
    }
}
