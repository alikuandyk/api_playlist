package org.example.api_playlist.track.dto;

import org.example.api_playlist.track.Track;
import org.springframework.stereotype.Component;

@Component
public class TrackMapper {
    public Track fromCreate(TrackCreateDto trackCreateDto) {
        Track track = new Track();
        track.setName(trackCreateDto.getName());
        track.setArtist(trackCreateDto.getArtist());

        return track;
    }

    public TrackResponseDto toResponse(Track track) {
        TrackResponseDto trackResponseDto = new TrackResponseDto();
        trackResponseDto.setId(track.getId());
        trackResponseDto.setName(track.getName());
        trackResponseDto.setArtist(track.getArtist());

        return trackResponseDto;
    }
}
