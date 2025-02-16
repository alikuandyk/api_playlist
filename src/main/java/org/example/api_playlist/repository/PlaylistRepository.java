package org.example.api_playlist.repository;

import org.example.api_playlist.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
