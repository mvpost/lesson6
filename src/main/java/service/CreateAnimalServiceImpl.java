package service;

import model.Cat;
import model.Dog;
import model.Shark;
import model.Wolf;
import repository.Animal;
import service.CreateAnimalService;

import java.time.LocalDate;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    public void createAnimals(int N) {
        System.out.println("Create repository.Animal with cycle for:");
        for (int i = 0; i < N; i++) {
            Animal animal;
            byte remainder = (byte) (i % 4);
            animal = switch (remainder) {
                case 3 -> new Wolf();
                case 2 -> new Shark();
                case 1 -> new Cat();
                case 0 -> new Dog();
                default -> throw new IllegalStateException("Unexpected value: " + remainder);
            };
            System.out.printf("Created a new animal %d : %s \n", i, animal.getName());
        }
    }

    public void createAnimals() {
        byte count = 0;
        System.out.println("Create repository.Animal with cycle do-while:");

        do {
            Animal animal;
            byte remainder = (byte) (count % 4);
            animal = switch (remainder) {
                case 3 -> new Wolf();
                case 2 -> new Shark();
                case 1 -> new Cat();
                case 0 -> new Dog();
                default -> throw new IllegalStateException("Unexpected value: " + remainder);
            };

            System.out.printf("Created a new animal %d : %s \n", count, animal.getName());
            count++;
        }
        while (count < 10);
    }
}
