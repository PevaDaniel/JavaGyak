package org.example.beadando_gy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Rivendell Racing");
        model.addAttribute("welcomeMessage", "Üdvözöljük a Rivendell Racing weboldalán!");
        return "home/home";
    }
}
