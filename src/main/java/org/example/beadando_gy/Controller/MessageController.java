package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Message;
import org.example.beadando_gy.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String listMessages(Model model) {
        model.addAttribute("messages", messageService.getAllMessagesDesc());
        return "messages/messages";
    }

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("message", new Message());
        return "contact/contact";
    }

    @PostMapping("/contact")
    public String sendMessage(@ModelAttribute("message") Message message, Model model) {
        messageService.saveMessage(message);
        model.addAttribute("successMessage", "Üzenet elküldve!");
        return "contact/contact";
    }
}
