package org.example.api_playlist.service;

import lombok.RequiredArgsConstructor;
import org.example.api_playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;


}
