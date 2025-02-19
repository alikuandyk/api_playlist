package org.example.api_playlist.user;

import lombok.RequiredArgsConstructor;
import org.example.api_playlist.exception.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        Optional<User> optional = userRepository.findByEmail(user.getEmail());
        if (optional.isPresent()) {
            throw new UserAlreadyExistException("Пользователь с такой почтой уже существует");
        }

        return userRepository.save(user);
    }

    public User findById(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
