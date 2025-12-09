package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Message;
import org.example.beadando_gy.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class ContactController {

    private final MessageRepository messageRepository;

    public ContactController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute("message") Message message,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }
        messageRepository.save(message);
        return "redirect:/contact?success";
    }
}
