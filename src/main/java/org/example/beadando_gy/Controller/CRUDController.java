package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Eredmeny;
import org.example.beadando_gy.repository.EredmenyRepository;
import org.example.beadando_gy.repository.GpRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crud")
public class CRUDController {

    private final EredmenyRepository eredmenyRepo;
    private final GpRepository gpRepo;

    public CRUDController(EredmenyRepository eredmenyRepo, GpRepository gpRepo) {
        this.eredmenyRepo = eredmenyRepo;
        this.gpRepo = gpRepo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("eredmenyek", eredmenyRepo.findAll());
        return "crud/crud";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("eredmeny", new Eredmeny());
        model.addAttribute("gps", gpRepo.findAll());
        return "crud/crud-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Eredmeny eredmeny) {
        // Csak a basic mentés, nincs extra ellenőrzés
        eredmenyRepo.save(eredmeny);
        return "redirect:/crud";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("eredmeny", eredmenyRepo.findById(id).orElseThrow());
        model.addAttribute("gps", gpRepo.findAll());
        return "crud/crud-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        eredmenyRepo.deleteById(id);
        return "redirect:/crud";
    }
}
