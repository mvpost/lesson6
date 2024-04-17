package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames (List<Animal> animals);
    Map<String, Integer> findOlderAnimal(List<Animal> animals, Integer age);
    Map<String, Integer> findDuplicate(List<Animal> animals);
}
