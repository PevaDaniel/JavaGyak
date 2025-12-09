package org.example.beadando_gy.Controller;

import org.example.beadando_gy.Entity.ExampleEntity;
import org.example.beadando_gy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/example")
public class ApiController {
    @Autowired
    private ExampleService service;

    @GetMapping
    public List<ExampleEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ExampleEntity get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ExampleEntity create(@RequestBody ExampleEntity entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ExampleEntity update(@PathVariable Long id, @RequestBody ExampleEntity entity) {
        entity.setId(id);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
