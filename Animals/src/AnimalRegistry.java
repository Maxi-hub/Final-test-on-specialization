import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AnimalRegistry {

    ArrayList<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addNewAnimal(Animal animal) {
        animals.add(animal);
    }

    public void printAllAnimal() {
        System.out.println("Registry of animals: ");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public int countAnimalByType(String type) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getType().equals(type)) {
                count++;
            }
        }
        return count;
    }

    public int getTotalAnimals() {
        return animals.size();
    }

    public void sortAnimalsByBirthday() {
        Collections.sort(animals);
    }

    
    @Override
    public String toString() {
        return "AnimalRegistry [animals=" + animals + "]";
    }
}
