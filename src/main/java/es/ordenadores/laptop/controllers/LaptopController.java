package es.ordenadores.laptop.controllers;


import es.ordenadores.laptop.entities.Laptop;
import es.ordenadores.laptop.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;
    @GetMapping
    public List<Laptop> findAll(){
        return laptopService.findAll();
    }
    @GetMapping("/{id}")
    public Laptop findById(@PathVariable Long id) {
        return laptopService.findById(id);
    }

    @PostMapping
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopService.create(laptop);
    }

    @PutMapping("/{id}")
    public Laptop update(@PathVariable Long id, @RequestBody Laptop laptop) {
        return laptopService.update(id, laptop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        laptopService.delete(id);
    }

}
