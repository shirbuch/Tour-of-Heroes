package com.example.BackendTourOfHeroes.repositories;

import com.example.BackendTourOfHeroes.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
