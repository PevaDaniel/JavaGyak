package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Eredmeny;
import org.example.beadando_gy.repository.EredmenyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChartController {

    private final EredmenyRepository eredmenyRepository;

    public ChartController(EredmenyRepository eredmenyRepository) {
        this.eredmenyRepository = eredmenyRepository;
    }

    @GetMapping("/chart")
    public String showChart(Model model) {
        List<Eredmeny> eredmenyek = eredmenyRepository.findAll();
        List<Integer> helyezesek = eredmenyek.stream()
                .map(Eredmeny::getHelyezes)
                .collect(Collectors.toList());
        model.addAttribute("helyezesek", helyezesek);
        return "chart/chart";
    }
}
