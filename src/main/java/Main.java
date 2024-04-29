import model.Cat;
import model.Dog;
import repository.Animal;
import repository.AnimalRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        AnimalRepositoryImpl animalRepositoryImpl = new AnimalRepositoryImpl();

        ArrayList<Animal> animals = fillAnimalsList();

        System.out.println("Животные, родившиеся в високосный год: \n"
                + animalRepositoryImpl.findLeapYearNames(animals) + "\n");

        System.out.println("Старшее животное: \n"
                + animalRepositoryImpl.findOlderAnimal(animals, 10)+ "\n");

        System.out.println("Дубликаты животных: \n"
                + animalRepositoryImpl.findDuplicate(animals)+ "\n");

        System.out.println("Средний возраст животных: \n"
                + animalRepositoryImpl.findAverageAge(animals)+ "\n");

        System.out.println("Животные старше 5 лет и дороже средней стоимости: \n"
                + animalRepositoryImpl.findOldAndExpensive(animals)+ "\n");

        System.out.println("3 животных с самой низкой ценой: \n"
                + animalRepositoryImpl.findMinCostAnimals(animals)+ "\n");
    }

    private static ArrayList<Animal> fillAnimalsList() {
        ArrayList<Animal> animals = new ArrayList<>();

        Cat cat1 = new Cat();
        cat1.name = "Barsik";
        cat1.birthDate = LocalDate.of(2022, 6, 6);
        cat1.cost = 100.0;

        Cat cat2 = new Cat();
        cat2.name = "Pushok";
        cat2.birthDate = LocalDate.of(2024, 1, 1);
        cat2.cost = 200.0;

        Dog dog1 = new Dog();
        dog1.name = "Muhtar";
        dog1.birthDate = LocalDate.of(2017, 10, 10);
        dog1.cost = 300.0;

        Dog dog2 = new Dog();
        dog2.name = "Ghuczka";
        dog2.birthDate = LocalDate.of(2019, 5, 10);
        dog2.cost = 400.0;

        animals.add(cat1);
        animals.add(cat2);
        animals.add(dog1);
        animals.add(dog2);

        return animals;
    }
}