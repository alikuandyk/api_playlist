package org.example.api_playlist.track;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.api_playlist.track.dto.TrackCreateDto;
import org.example.api_playlist.track.dto.TrackMapper;
import org.example.api_playlist.track.dto.TrackResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;
    private final TrackMapper trackMapper;

    @PostMapping
    public TrackResponseDto create(
            @Valid @RequestBody TrackCreateDto createDto
    ) {
        Track track = trackMapper.fromCreate(createDto);
        return trackMapper.toResponse(trackService.create(track));
    }

    @PostMapping("/{id}")
    public TrackResponseDto findById(@PathVariable int id) {
        Track track = trackService.findById(id);
        return trackMapper.toResponse(track);
    }

    @GetMapping
    public List<TrackResponseDto> findAll() {
        List<TrackResponseDto> responseDtos =
                trackService.findAll().stream()
                        .map(trackMapper::toResponse)
                        .toList();

        return responseDtos;
    }

}
