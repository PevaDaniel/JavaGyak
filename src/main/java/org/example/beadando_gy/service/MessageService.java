package org.example.beadando_gy.service;

import org.example.beadando_gy.Entity.Message;
import org.example.beadando_gy.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {
        message.setCreatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getAllMessagesDesc() {
        return messageRepository.findAllByOrderByCreatedAtDesc();
    }
}
