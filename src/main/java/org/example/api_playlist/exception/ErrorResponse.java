package org.example.api_playlist.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {
    private final String message;
    private final HttpStatus status;
}
