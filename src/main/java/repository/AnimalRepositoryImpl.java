package repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AnimalRepositoryImpl implements AnimalRepository {
    CheckLeapYearAnimalImpl checkLeapYearAnimalImpl = new CheckLeapYearAnimalImpl();

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) {
        return animals.stream()
                .filter(animal -> checkLeapYearAnimalImpl.checkLeapYearAnimal(animal))
                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName() + " " + animal.getName(), Animal::getBirthDate));
    }

    @Override
    public Map<String, Integer> findOlderAnimal(List<Animal> animals, Integer age) {
        int maxAge = animals.stream()
                .map(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears())
                .max(Integer::compare)
                .orElse(0);

        Map<String, Integer> olderAnimal =
                animals.stream()
                .filter(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() >= age)
                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName() + " " + animal.getName(),
                        animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears()));

        if (olderAnimal.size() == 0) {
            olderAnimal =
                animals.stream()
                .filter(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() == maxAge)
                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName() + " " + animal.getName(),
                animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears()));
        }

        return olderAnimal;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(animal -> animal.getClass().getSimpleName(),
                        Collectors.toList()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public double findAverageAge(List<Animal> animals) {
        return animals.stream()
                .mapToLong(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears())
                .average()
                .orElse(0.0);
    }

    @Override
    public List<String> findOldAndExpensive(List<Animal> animals) {
        double averagePrice = animals.stream()
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(0.0);

        return animals.stream()
                .filter(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears() > 5)
                .filter(animal -> animal.getCost() > averagePrice)
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .map(animal -> animal.getClass().getSimpleName() + " "
                        + animal.getName() + " " + animal.getBirthDate())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findMinCostAnimals(List<Animal> animals) {
        return animals.stream()
                .sorted(Comparator.comparingDouble(Animal::getCost))
                .limit(3)
                .map(Animal::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
