package org.example.api_playlist.repository;

import org.example.api_playlist.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {

}
