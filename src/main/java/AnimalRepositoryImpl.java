import java.time.LocalDate;
import java.time.Period;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;

public class AnimalRepositoryImpl implements AnimalRepository {
    CheckLeapYearAnimalImpl checkLeapYearAnimalImpl = new CheckLeapYearAnimalImpl();

    public AbstractMap<String, LocalDate> findLeapYearNames (List<Animal> animals) {
        HashMap<String, LocalDate> animalsMap = new HashMap<>();

        for (Animal animal : animals) {
            if (checkLeapYearAnimalImpl.checkLeapYearAnimal(animal)) {
                animalsMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), animal.getBirthDate());
            }
        }

        return animalsMap;
    }

    public AbstractMap<String, Integer> findOlderAnimal(List<Animal> animals, Integer years) {
        HashMap<String, Integer> animalsMap = new HashMap<>();

        for (Animal animal : animals) {
            int age = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();

            if (age >= years) {
                animalsMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), age);
            }
        }

        if (animalsMap.isEmpty()) {
            HashMap<String, Integer> olderAnimalMap = new HashMap<>();
            int maxAge = 0;
            for (Animal animal : animals) {
                int currentAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();

                if (olderAnimalMap.isEmpty()) {
                    olderAnimalMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), currentAge);
                    maxAge = currentAge;
                } else {
                    if (currentAge > maxAge) {
                        olderAnimalMap.clear();
                        olderAnimalMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), currentAge);
                        maxAge = currentAge;
                    }
                }
            }
            animalsMap = olderAnimalMap;
        }

        return animalsMap;
    }

    public AbstractMap<String, Integer> findDuplicate(List<Animal> animals) {
        AbstractMap<String, Integer> animalCountMap = new HashMap<>();

        for (Animal animal : animals) {
            String animalType = animal.getClass().getSimpleName();
            if (!animalCountMap.containsKey(animalType))
                animalCountMap.put(animalType, animalCountMap.getOrDefault(animalType, 0) + 1);
            else {
                animalCountMap.replace(animalType, animalCountMap.get(animalType) + 1);
            }
        }

        return animalCountMap;
    }
}
