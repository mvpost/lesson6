import model.Cat;
import model.Dog;
import org.junit.jupiter.api.Test;
import repository.Animal;
import repository.AnimalRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryImplTest {

    private final AnimalRepositoryImpl animalRepository;
    private final List<Animal> animals;

    public AnimalRepositoryImplTest() {
        animalRepository = new AnimalRepositoryImpl();
        animals = setUp();
    }

    public static ArrayList<Animal> setUp() {
        ArrayList<Animal> animals = new ArrayList<>();

        Cat cat1 = new Cat();
        cat1.name = "Barsik";
        cat1.birthDate = LocalDate.of(2022, 6, 6);

        Cat cat2 = new Cat();
        cat2.name = "Pushok";
        cat2.birthDate = LocalDate.of(2024, 1, 1);

        Dog dog1 = new Dog();
        dog1.name = "Muhtar";
        dog1.birthDate = LocalDate.of(2018, 10, 10);

        Dog dog2 = new Dog();
        dog2.name = "Ghuczka";
        dog2.birthDate = LocalDate.of(2019, 5, 10);

        animals.add(cat1);
        animals.add(cat2);
        animals.add(dog1);
        animals.add(dog2);

        return animals;
    }

    @Test
    void findLeapYearNames() {
        Map<String, LocalDate> leapYearNames = animalRepository.findLeapYearNames(animals);

        assertEquals(1, leapYearNames.size());
        assertTrue(leapYearNames.containsKey("Cat Pushok"));
        assertEquals(LocalDate.of(2024, 1, 1), leapYearNames.get("Cat Pushok"));
    }

    @Test
    void findOlderAnimal() {
        Map<String, Integer> olderAnimals = animalRepository.findOlderAnimal(animals, 5);

        assertEquals(1, olderAnimals.size());
        assertTrue(olderAnimals.containsKey("Dog Muhtar"));
    }

    @Test
    void findOlderAnimalWithBigAge() {
        Map<String, Integer> olderAnimals = animalRepository.findOlderAnimal(animals, 10);

        assertEquals(1, olderAnimals.size());
        assertTrue(olderAnimals.containsKey("Dog Muhtar"));
    }

    @Test
    void findOlderAnimalWithZeroAge() {
        Map<String, Integer> olderAnimals = animalRepository.findOlderAnimal(animals, 0);

        assertEquals(4, olderAnimals.size());
    }

    @Test
    void findDuplicate() {
        Map<String,List<Animal>> duplicateAnimals = animalRepository.findDuplicate(animals);

        assertEquals(2, duplicateAnimals.size());
        assertTrue(duplicateAnimals.containsKey("Cat"));
        assertTrue(duplicateAnimals.containsKey("Dog"));
    }
}