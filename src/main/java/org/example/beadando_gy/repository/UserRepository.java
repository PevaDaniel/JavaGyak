package org.example.beadando_gy.repository;
import org.example.beadando_gy.Entity.User;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SecurityProperties.User, Long> {
    Optional<User> findByUsername(String username);
}
