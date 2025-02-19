package org.example.api_playlist.playlist.dto;

import org.example.api_playlist.playlist.Playlist;
import org.example.api_playlist.track.Track;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaylistMapper {
    public Playlist fromCreate(PlaylistCreateDto playlistCreateDto) {
        Playlist playlist = new Playlist();
        playlist.setAuthor(playlistCreateDto.getAuthor());

        return playlist;
    }

    public PlaylistResponseDto toResponse(Playlist playlist) {
        PlaylistResponseDto playlistResponseDto = new PlaylistResponseDto();
        playlistResponseDto.setId(playlist.getId());
        playlistResponseDto.setAuthor(playlist.getAuthor());
        playlist.setTracks(playlist.getTracks());

        return playlistResponseDto;
    }

    public Playlist fromUpdate(PlaylistUpdateDto playlistUpdateDto) {
        Playlist playlist = new Playlist();

        playlist.setTracks(playlistUpdateDto.getTracks());
        return playlist;
    }

    public void merge(Playlist existingPlaylist, PlaylistUpdateDto updateDto) {
        if (updateDto.getTracks() != null && !updateDto.getTracks().isEmpty()) {
            existingPlaylist.setTracks(updateDto.getTracks());
        }    }
}
