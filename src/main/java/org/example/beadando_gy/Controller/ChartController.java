package org.example.beadando_gy.Controller;

import org.example.beadando_gy.repository.EredmenyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    private final EredmenyRepository eredmenyRepository;

    public ChartController(EredmenyRepository eredmenyRepository) {
        this.eredmenyRepository = eredmenyRepository;
    }

    @GetMapping("/chart")
    public String showChart(Model model) {
        model.addAttribute("eredmenyek", eredmenyRepository.findAll());
        return "chart/chart";
    }
}
