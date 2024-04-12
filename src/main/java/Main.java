public class Main {
    public static void main(String[] args){
        CreateAnimalService createAnimalService = new CreateAnimalService();
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();


        createAnimalService.createAnimals();
        createAnimalServiceImpl.createAnimals(5);
        createAnimalServiceImpl.createAnimals();
    }
}