public class CreateAnimalService {
    public void createAnimals() {
        byte count = 0;
        System.out.println("Create Animal with cycle while:");
        while (count < 10) {
            Animal animal;
            byte remainder = (byte) (count % 4);
            switch (remainder) {
                case 3:
                    animal = new Wolf();
                    break;
                case 2:
                    animal = new Shark();
                    break;
                case 1:
                    animal = new Cat();
                    break;
                case 0:
                    animal = new Dog();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + remainder);
            }

            System.out.println("Created a new animal " + count + ": " + animal.getName());
            count++;
        }
    }
}
