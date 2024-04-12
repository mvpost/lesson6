public class CheckLeapYearAnimalImpl {
    String checkLeapYearAnimal(Animal animal) {
        if (animal == null)
            throw new InvalidAnimalException("Invalid animal");

        return (String.format("%s was born in a %s year", animal.getName(),
                animal.getBirthDate().isLeapYear() ? "leap" : "non-leap"));
    }
}
