package org.example.api_playlist.playlist;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.api_playlist.playlist.dto.PlaylistMapper;
import org.example.api_playlist.playlist.dto.PlaylistResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
@Validated
public class PlaylistController {
    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;

    @PostMapping
    public PlaylistResponseDto create(@RequestHeader("X-USER-ID") int userId,
                                      @NotNull(message = "Плейлист не может быть без названий") @RequestParam String playlistName
    ) {
        return playlistMapper.toResponse(playlistService.create(userId, playlistName));
    }

    @GetMapping("/{id}")
    public PlaylistResponseDto findById(@PathVariable int id) {
        return playlistMapper.toResponse(playlistService.findById(id));
    }

    @GetMapping
    public List<PlaylistResponseDto> findAll() {
        return playlistService.findAll().stream()
                .map(playlistMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public PlaylistResponseDto addTracks(
            @RequestHeader("X-USER-ID") int userId,
            @PathVariable int id,
            @RequestParam List<Integer> tracksId
    ) {
        return playlistMapper.toResponse(playlistService.addTracks(id, tracksId, userId));
    }

    @DeleteMapping("/{id}")
    public void deleteTracks(
            @RequestHeader("X-USER-ID") int userId,
            @PathVariable int id,
            @RequestParam List<Integer> tracksId
    ) {
        playlistService.deleteTracksInPlaylist(id, tracksId, userId);
    }
}
