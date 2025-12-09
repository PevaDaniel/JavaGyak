package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Message;
import org.example.beadando_gy.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ChartController {

    private final MessageRepository messageRepository;

    public ChartController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/chart")
    public String chartPage(Model model) {
        List<Message> messages = messageRepository.findAll();

        Map<String, Long> countByEmailDomain = messages.stream()
                .collect(Collectors.groupingBy(
                        msg -> {
                            String email = msg.getEmail();
                            int atIndex = email.indexOf("@");
                            return atIndex != -1 ? email.substring(atIndex + 1) : "unknown";
                        },
                        Collectors.counting()
                ));

        model.addAttribute("labels", countByEmailDomain.keySet());
        model.addAttribute("data", countByEmailDomain.values());

        return "chart";
    }
}
