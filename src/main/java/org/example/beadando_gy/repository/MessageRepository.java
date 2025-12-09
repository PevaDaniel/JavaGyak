package org.example.beadando_gy.repository;

import org.example.beadando_gy.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
