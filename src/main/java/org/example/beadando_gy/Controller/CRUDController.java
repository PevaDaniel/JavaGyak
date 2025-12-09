package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.Eredmeny;
import org.example.beadando_gy.repository.EredmenyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crud")
public class CRUDController {

    private final EredmenyRepository eredmenyRepository;

    public CRUDController(EredmenyRepository eredmenyRepository) {
        this.eredmenyRepository = eredmenyRepository;
    }

    @GetMapping
    public String list(Model model) {
        List<Eredmeny> eredmenyek = eredmenyRepository.findAll();
        model.addAttribute("eredmenyek", eredmenyek);
        model.addAttribute("eredmeny", new Eredmeny());
        return "crud/crud";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Eredmeny eredmeny) {
        eredmenyRepository.save(eredmeny);
        return "redirect:/crud";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Eredmeny eredmeny) {
        eredmeny.setId(id);
        eredmenyRepository.save(eredmeny);
        return "redirect:/crud";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        eredmenyRepository.deleteById(id);
        return "redirect:/crud";
    }
}
