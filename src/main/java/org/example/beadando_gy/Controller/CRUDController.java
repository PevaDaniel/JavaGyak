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
        return "crud";
    }

    @PostMapping("/create")
    public String saveOrUpdate(@ModelAttribute Eredmeny eredmeny) {
        if (eredmeny.getId() != null) {
            // Edit
            Eredmeny existing = eredmenyRepository.findById(eredmeny.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + eredmeny.getId()));
            existing.setDatum(eredmeny.getDatum());
            existing.setPilotaaz(eredmeny.getPilotaaz());
            existing.setHelyezes(eredmeny.getHelyezes());
            existing.setHiba(eredmeny.getHiba());
            existing.setCsapat(eredmeny.getCsapat());
            existing.setTipus(eredmeny.getTipus());
            existing.setMotor(eredmeny.getMotor());
            eredmenyRepository.save(existing);
        } else {
            // Új rekord
            eredmenyRepository.save(eredmeny);
        }
        return "redirect:/crud";
    }

    // Törlés
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        eredmenyRepository.deleteById(id);
        return "redirect:/crud";
    }
}
