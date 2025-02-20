package org.example.api_playlist.playlist;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.api_playlist.track.Track;
import org.example.api_playlist.user.User;

import java.util.List;

@Entity
@Table(name = "playlists")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Playlist {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    int id;

    String name;

    @ManyToMany
    @JoinTable(name = "tracks_playlists",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))
    List<Track> tracks;

    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;
}
