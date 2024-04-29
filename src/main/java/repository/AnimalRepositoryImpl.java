package repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalRepositoryImpl implements AnimalRepository {
    CheckLeapYearAnimalImpl checkLeapYearAnimalImpl = new CheckLeapYearAnimalImpl();

    public Map<String, LocalDate> findLeapYearNames (List<Animal> animals) {
        Map<String, LocalDate> animalsMap = new HashMap<>();

        for (Animal animal : animals) {
            if (checkLeapYearAnimalImpl.checkLeapYearAnimal(animal)) {
                animalsMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), animal.getBirthDate());
            }
        }

        return animalsMap;
    }

    public Map<String, Integer> findOlderAnimal(List<Animal> animals, Integer years) {
        Map<String, Integer> animalsMap = new HashMap<>();
        int maxAge = 0;

        for (Animal animal : animals) {
            int age = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            maxAge = Math.max(age, maxAge);

            if (age >= years) {
                if (age > maxAge) {
                    animalsMap.clear();
                }
                animalsMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), age);
            }
        }

        if (animalsMap.isEmpty() && maxAge > 0) {
            for (Animal animal : animals) {
                int age = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
                if (age == maxAge) {
                    animalsMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), age);
                }
            }
        }

        return animalsMap;
    }

    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        Map<String, Integer> animalCountMap = new HashMap<>();

        for (Animal animal : animals) {
            String animalType = animal.getClass().getSimpleName();
            animalCountMap.put(animalType, animalCountMap.getOrDefault(animalType, 0) + 1);
        }

        return animalCountMap;
    }
}
