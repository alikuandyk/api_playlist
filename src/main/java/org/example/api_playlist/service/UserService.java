package org.example.api_playlist.service;

import lombok.RequiredArgsConstructor;
import org.example.api_playlist.model.User;
import org.example.api_playlist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {

    }
}
