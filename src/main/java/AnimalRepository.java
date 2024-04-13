import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;

public interface AnimalRepository {
    AbstractMap<String, LocalDate> findLeapYearNames (List<Animal> animals);
    AbstractMap<String, Integer> findOlderAnimal(List<Animal> animals, Integer age);
    AbstractMap<String, Integer> findDuplicate(List<Animal> animals);
}
