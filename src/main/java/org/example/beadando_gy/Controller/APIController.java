package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Message;
import org.example.beadando_gy.repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private final MessageRepository messageRepository;

    public APIController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        return messageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) {
        return messageRepository.findById(id)
                .map(message -> {
                    message.setName(updatedMessage.getName());
                    message.setEmail(updatedMessage.getEmail());
                    message.setContent(updatedMessage.getContent());
                    return ResponseEntity.ok(messageRepository.save(message));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        return messageRepository.findById(id)
                .map(message -> {
                    messageRepository.delete(message);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
