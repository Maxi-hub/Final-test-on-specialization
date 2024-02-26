import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AnimalManager {
    private int catCount = 0; 
    private int dogCount = 0; 
    private int hamsterCount = 0;

    public ArrayList<Animal> listOfCats() {
        ArrayList<String> catCommands = new ArrayList<>();
        catCommands.add("play, run");
        ArrayList<Animal> cats = new ArrayList<Animal>();
        Animal newCat_1 = new Cats("cat", "Suzy", "2020-11-11", catCommands);
        Animal newCat_2 = new Cats("cat", "Tom", "2022-11-11", catCommands);
        Animal newCat_3 = new Cats("cat", "Jary", "2019-11-11", catCommands);
        cats.add(newCat_1);
        cats.add(newCat_2);
        cats.add(newCat_3);
        return cats;
    }

    public ArrayList<Animal> listOfDogs() {
        ArrayList<String> dogCommands = new ArrayList<>();
        dogCommands.add("bark, seat");
        ArrayList<Animal> dogs = new ArrayList<Animal>();
        Animal newDog_1 = new Dogs("dog", "Tom", "2002-01-01", dogCommands);
        Animal newDog_2 = new Dogs("dog", "Bobby", "2002-02-02", dogCommands);
        Animal newDog_3 = new Dogs("dog", "Rex", "2002-03-03", dogCommands);
        dogs.add(newDog_1);
        dogs.add(newDog_2);
        dogs.add(newDog_3);
        return dogs;
    }

    public ArrayList<Animal> listOfHamsters() {
        ArrayList<String> hamsterCommands = new ArrayList<>();
        hamsterCommands.add("sleep, eat");
        ArrayList<Animal> hamsters = new ArrayList<>();
        Animal newHamster_1 = new Hamsters("hamster", "Bob", "2003-01-01", hamsterCommands);
        Animal newHamster_2 = new Hamsters("hamster", "Sam", "2003-02-02", hamsterCommands);
        Animal newHamster_3 = new Hamsters("hamster", "Lory", "2003-03-03", hamsterCommands);
        hamsters.add(newHamster_1);
        hamsters.add(newHamster_2);
        hamsters.add(newHamster_3);
        return hamsters;
    }

    public static File CreateFile() throws IOException {
        File fileName = new File("Registry");
        if (!fileName.exists()) {
            fileName.createNewFile();
        }
        return fileName;
    }

    public void WriteToFileMainAnimals(File fileName, AnimalRegistry animalRegistry) {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < animalRegistry.animals.size(); i++) {
                br.write(animalRegistry.animals.get(i).toString() + "\n");
            }
            br.write("Count of cats: " + catCount);
            System.out.println("Cats: " + catCount);
            br.newLine();
            br.write("Count of dogs: " + dogCount);
            System.out.println("Dogs: " + dogCount);
            br.newLine();
            br.write("Count of hamsters: " + hamsterCount);
            System.out.println("Hamsters: " + hamsterCount);
            br.newLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadFromFile(File fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Cat")) {
                    catCount++;
                } else if (line.contains("Dog")) {
                    dogCount++;
                } else if (line.contains("Hamster")) {
                    hamsterCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadFromFileAfter(File fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            AnimalRegistry animalRegistry = new AnimalRegistry();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String type = parts[0];
                    String name = parts[1];
                    String birthday = parts[2];
                    ArrayList<String> commands = new ArrayList<>(Arrays.asList(parts).subList(3,
                            parts.length));
                    animalRegistry.addNewAnimal(new Animal(type, name, birthday, commands));
                }
            }
            System.out.println("Registry of animals: ");
            for (Animal animal : animalRegistry.getAnimals()) {
                System.out.println(animal.getType() + animal.getName() + animal.getBirthday() + animal.getCommands());
            }
            animalRegistry.sortAnimalsByBirthday();
            System.out.println("\n" + "List of animals sorted by birthday: ");
            for (Animal animal : animalRegistry.getAnimals()) {
                System.out.println(animal.getType() + animal.getName() + animal.getBirthday() + animal.getCommands());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAnimal(File fileName, String type, Animal newAnimal) {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true));
            newAnimal.addNewCommand();
            System.out.println("--------------------------");
            System.out.println(newAnimal);
            newAnimal.printCommands();
            if (type.equals("cat")) {
                catCount++;
            } else if (type.equals("dog")) {
                dogCount++;
            } else if (type.equals("hamster")) {
                hamsterCount++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteToFile(File fileName, AnimalRegistry animalRegistry, Animal newAnimal) {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true));
            int totalAnimals = (catCount + dogCount + hamsterCount);
            animalRegistry.addNewAnimal(newAnimal);
            br.newLine();
            br.append(newAnimal.toString());
            System.out.println("Count of cats: " + catCount);
            System.out.println("Count of dogs: " + dogCount);
            System.out.println("Count of hamsters: " + hamsterCount);
            System.out.println("Total number of animals in the registry: " + totalAnimals + "\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
