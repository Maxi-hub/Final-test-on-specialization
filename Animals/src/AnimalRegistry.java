import java.util.ArrayList;
import java.util.Collections;


public class AnimalRegistry {
   
    ArrayList<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addNewAnimal(Animal animal){
        animals.add(animal);
    }

    public void printAllAnimal(){
        System.out.println("Registry of animals: ");
        for(Animal animal : animals) {
            System.out.println(animal);
        }
    }
    
    public int getTotalAnimals() {
        return animals.size();
    }

    public void sortAnimalsByBirthday() {
        Collections.sort(animals);
    }
    
}

