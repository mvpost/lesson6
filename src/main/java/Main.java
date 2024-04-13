import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        AnimalRepositoryImpl animalRepositoryImpl = new AnimalRepositoryImpl();

        ArrayList<Animal> animals = (ArrayList<Animal>) fillAnimalsList();

        System.out.println("Животные, родившиеся в високосный год: \n"
                + animalRepositoryImpl.findLeapYearNames(animals));

        System.out.println("Старшее животное: \n"
                + animalRepositoryImpl.findOlderAnimal(animals, 20));

        System.out.println("Дубликаты животных: \n"
                + animalRepositoryImpl.findDuplicate(animals));
    }

    private static List<Animal> fillAnimalsList() {
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
}