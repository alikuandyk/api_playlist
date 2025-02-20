package org.example.api_playlist.playlist;

import lombok.RequiredArgsConstructor;
import org.example.api_playlist.exception.ForbiddenException;
import org.example.api_playlist.exception.NotFoundException;
import org.example.api_playlist.track.Track;
import org.example.api_playlist.track.TrackRepository;
import org.example.api_playlist.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;
    private final UserRepository userRepository;

    public Playlist create(int userId, String playlistName) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistName);
        playlist.setAuthor(userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Пользователь с ID " + userId + " не найден")));

        return playlistRepository.save(playlist);
    }

    public Playlist findById(int playlistId) {
        return playlistRepository.findById(playlistId).orElseThrow();
    }

    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    public Playlist addTracks(int playlistId, List<Integer> tracksId, int userId) {
        if (checkAuthorOfPlaylist(playlistId, userId)) {
            throw new ForbiddenException("В плейлист может добавлять только автор");
        }
        Playlist playlist = findById(playlistId);

        List<Track> tracks = trackRepository.findAllById(tracksId);
        playlist.getTracks().addAll(tracks);
        playlistRepository.save(playlist);

        return playlist;
    }

    public void deleteTracksInPlaylist(int playlistId, List<Integer> tracksId, int userId) {
        if (checkAuthorOfPlaylist(playlistId, userId)) {
            throw new ForbiddenException("Удалять треки может только автор");
        }
        Playlist playlist = findById(playlistId);

        playlist.getTracks().removeIf(track -> tracksId.contains(track.getId()));
        playlistRepository.save(playlist);
    }

    public boolean checkAuthorOfPlaylist(int playlistId, int userId) {
        Playlist playlist = findById(playlistId);
        return !playlist.getAuthor().equals(userRepository.findById(userId).orElseThrow());
    }
}
