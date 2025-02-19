package org.example.api_playlist.track;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.api_playlist.playlist.Playlist;

import java.util.List;

@Entity
@Table(name = "tracks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Track {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    int id;

    String name;

    String artist;

    @ManyToMany(mappedBy = "tracks")
    List<Playlist> playlists;
}
