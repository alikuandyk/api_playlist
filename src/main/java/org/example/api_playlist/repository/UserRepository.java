package org.example.api_playlist.repository;

import org.example.api_playlist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
