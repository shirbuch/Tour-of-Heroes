package com.example.BackendTourOfHeroes.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.BackendTourOfHeroes.models.Hero;
import com.example.BackendTourOfHeroes.exceptions.HeroNotFoundException;
import com.example.BackendTourOfHeroes.repositories.HeroRepository;

import java.util.List;

@RestController
public class HeroController {
    private final HeroRepository repository;

    HeroController(HeroRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/heroes")
    List<Hero> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/heroes")
    Hero newHero(@RequestBody Hero newHero) {
        return repository.save(newHero);
    }

    // Single item

    @GetMapping("/heroes/{id}")
    Hero one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new HeroNotFoundException(id));
    }

    @PutMapping("/heroes/{id}")
    Hero replaceHero(@RequestBody Hero newHero, @PathVariable Long id) {

        return repository.findById(id)
                .map(hero -> {
                    hero.setName(newHero.getName());
                    return repository.save(hero);
                })
                .orElseGet(() -> {
                    newHero.setId(id);
                    return repository.save(newHero);
                });
    }

    @DeleteMapping("/heroes/{id}")
    void deleteHero(@PathVariable Long id) {
        repository.deleteById(id);
    }
}