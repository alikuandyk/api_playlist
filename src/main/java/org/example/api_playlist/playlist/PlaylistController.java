package org.example.api_playlist.playlist;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.api_playlist.playlist.dto.PlaylistMapper;
import org.example.api_playlist.playlist.dto.PlaylistResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


}
