package org.example.beadando_gy.Controller;

import org.example.beadando_gy.repository.GpRepository;
import org.example.beadando_gy.repository.PilotaRepository;
import org.example.beadando_gy.repository.EredmenyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabaseController {

    private final EredmenyRepository eredmenyRepository;
    private final GpRepository gpRepository;
    private final PilotaRepository pilotaRepository;

    public DatabaseController(EredmenyRepository eredmenyRepository, GpRepository gpRepository, PilotaRepository pilotaRepository) {
        this.eredmenyRepository = eredmenyRepository;
        this.gpRepository = gpRepository;
        this.pilotaRepository = pilotaRepository;
    }

    @GetMapping("/database")
    public String showDatabase(Model model) {
        model.addAttribute("eredmenyek", eredmenyRepository.findAll());
        model.addAttribute("gpList", gpRepository.findAll());
        model.addAttribute("pilotaList", pilotaRepository.findAll());
        return "database/database";
    }
}
