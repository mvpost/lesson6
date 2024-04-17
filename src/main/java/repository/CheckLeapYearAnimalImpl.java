package repository;

import exception.InvalidAnimalException;

public class CheckLeapYearAnimalImpl implements CheckLeapYearAnimal {
    public boolean checkLeapYearAnimal(Animal animal) {
        if (animal == null)
            throw new InvalidAnimalException("Invalid animal");
        return animal.getBirthDate().isLeapYear();
    }
}
