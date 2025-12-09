package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Message;
import org.example.beadando_gy.repository.MessageRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@Valid @ModelAttribute("message") Message message,
                                    BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }
        message.setCreatedAt(LocalDateTime.now());
        messageRepository.save(message);
        model.addAttribute("successMessage", "Az üzenet elküldve!");
        model.addAttribute("message", new Message()); // új űrlap
        return "contact";
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String listMessages(Model model) {
        List<Message> messages = messageRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("messages", messages);
        return "messages";
    }
}
