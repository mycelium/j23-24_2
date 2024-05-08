package ru.spbstu.java.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.spbstu.java.spring.components.Cat;
import ru.spbstu.java.spring.repositories.CatRepository;

import java.util.List;
import java.util.Map;

@RestController
public class CatController {
    @Autowired
    private CatRepository catRepository;

    private static Map<String, Cat> cats = Map.of(new String("Black"), new Cat("Boris", 15, "Black"));

    @GetMapping("/cats")
    public List<ru.spbstu.java.spring.entities.Cat> getCats() {
        return catRepository.findAll();
    }

    @GetMapping("/cat")
    public String getCat(@RequestParam(value = "color") String color) {
        return cats.get(color).toJSON();
    }
}
