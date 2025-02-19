package org.example.api_playlist.track;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public Track create(Track track) {
        return trackRepository.save(track);
    }

    public Track findById(int trackId) {
        return trackRepository.findById(trackId).orElseThrow();
    }

    public List<Track> findAll() {
        return trackRepository.findAll();
    }
}
