public class CheckLeapYearAnimalImpl {
    boolean checkLeapYearAnimal(Animal animal) {
        if (animal == null)
            throw new InvalidAnimalException("Invalid animal");
        return animal.getBirthDate().isLeapYear();
    }
}
