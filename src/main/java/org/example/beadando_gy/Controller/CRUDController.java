package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.ExampleEntity;
import org.example.beadando_gy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crud")
public class CrudController {
    @Autowired
    private ExampleService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", service.findAll());
        return "crud/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new ExampleEntity());
        return "crud/form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ExampleEntity item) {
        service.save(item);
        return "redirect:/crud";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", service.findById(id));
        return "crud/form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute ExampleEntity item) {
        service.save(item);
        return "redirect:/crud";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/crud";
    }
}
