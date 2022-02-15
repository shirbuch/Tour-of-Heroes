package com.example.BackendTourOfHeroes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hero {
    private @Id
    @GeneratedValue
    Long id;
    private String name;

    Hero() {}

    public Hero(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Hero))
            return false;
        Hero hero = (Hero) o;
        return Objects.equals(this.id, hero.id) && Objects.equals(this.name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
