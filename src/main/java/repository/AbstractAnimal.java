package repository;

import repository.Animal;

import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {
    public String breed;
    public String name;
    public Double cost;
    public String character;
    public LocalDate birthDate;

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }
}
