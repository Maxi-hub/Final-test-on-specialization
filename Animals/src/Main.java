import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
       
        File newFile = AnimalManager.CreateFile();
        Animal newAnimal = Pets.getNewAnimal();
        AnimalRegistry animalRegistry = new AnimalRegistry();
        AnimalManager animalManager = new AnimalManager();
        
        
        ArrayList<Animal> cats = animalManager.listOfCats();
        for (int i = 0; i < cats.size(); i++) {
            animalRegistry.addNewAnimal(cats.get(i));
        }

        ArrayList<Animal> dogs = animalManager.listOfDogs();
        for (int i = 0; i < dogs.size(); i++) {
            animalRegistry.addNewAnimal(dogs.get(i));
        }

        ArrayList<Animal> hamsters = animalManager.listOfHamsters();
        for (int i = 0; i < hamsters.size(); i++) {
            animalRegistry.addNewAnimal(hamsters.get(i));
        }
        
        // animalManager.WriteToFileMainAnimals(newFile, animalRegistry);
        animalManager.ReadFromFile(newFile);
        animalManager.addAnimal(newFile, newAnimal.getType(), newAnimal);
        animalManager.WriteToFile(newFile, animalRegistry, newAnimal);
        
             
    }
}
