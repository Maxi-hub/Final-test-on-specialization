import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        AnimalRegistry animalRegistry = new AnimalRegistry();

        Animal newAnimal = Pets.getNewAnimal();
        newAnimal.addNewCommand();
        newAnimal.printCommands();
        System.out.println("\n" + newAnimal + "\n");

        ArrayList<String> catCommands = new ArrayList<>();
        catCommands.add("bark, stay");
        ArrayList<Animal> cats = new ArrayList<Animal>();
        Animal newCat_1 = new Cats("cat", "Suzy", "2020-11-11", catCommands);
        Animal newCat_2 = new Cats("cat", "Tom", "2022-11-11", catCommands);
        Animal newCat_3 = new Cats("cat", "Jary", "2019-11-11", catCommands);
        cats.add(newCat_1);
        cats.add(newCat_2);
        cats.add(newCat_3);
        animalRegistry.addNewAnimal(newCat_1);
        animalRegistry.addNewAnimal(newCat_2);
        animalRegistry.addNewAnimal(newCat_3);

        ArrayList<String> dogCommands = new ArrayList<>();
        dogCommands.add("bark, stay");
        ArrayList<Animal> dogs = new ArrayList<Animal>();
        Animal newDog_1 = new Dogs("dog", "Tom", "2002-01-01", dogCommands);
        Animal newDog_2 = new Dogs("dog", "Bobby", "2002-02-02", dogCommands);
        Animal newDog_3 = new Dogs("dog", "Rex", "2002-03-03", dogCommands);
        dogs.add(newDog_1);
        dogs.add(newDog_2);
        dogs.add(newDog_3);
        animalRegistry.addNewAnimal(newDog_1);
        animalRegistry.addNewAnimal(newDog_2);
        animalRegistry.addNewAnimal(newDog_3);

        ArrayList<String> hamsterCommands = new ArrayList<>();
        hamsterCommands.add("sleep, eat");
        ArrayList<Animal> hamsters = new ArrayList<>();
        Animal newHamster_1 = new Hamsters("hamster", "Bob", "2003-01-01", hamsterCommands);
        Animal newHamster_2 = new Hamsters("hamster", "Sam", "2003-02-02", hamsterCommands);
        Animal newHamster_3 = new Hamsters("hamster", "Lory", "2003-03-03", hamsterCommands);
        hamsters.add(newHamster_1);
        hamsters.add(newHamster_2);
        hamsters.add(newHamster_3);
        animalRegistry.addNewAnimal(newHamster_1);
        animalRegistry.addNewAnimal(newHamster_2);
        animalRegistry.addNewAnimal(newHamster_3);

        if (newAnimal.getType().equals("cat")) {
            cats.add(newAnimal);
        } else if (newAnimal.getType().equals("dog")) {
            dogs.add(newAnimal);
        } else {
            hamsters.add(newAnimal);
        }

        try {
            File fileName = new File("Registry");
            if (!fileName.exists()) {
                fileName.createNewFile();
            }

            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            pw.append(animalRegistry.animals.toString() + "\n");
            animalRegistry.addNewAnimal(newAnimal);
            pw.append(newAnimal.toString() + "\n");
            animalRegistry.printAllAnimal();
            animalRegistry.sortAnimalsByBirthday();
            System.out.println("\n" + "List of animals sorted by birthday:");
            for (Animal animal : animalRegistry.animals) {
                System.out.println(animal);
            }
            int catCount = animalRegistry.countAnimalByType("cat");
            System.out.println("Count of cats: " + catCount);
            int dogCount = animalRegistry.countAnimalByType("dog");
            System.out.println("Count of dogs: " + dogCount);
            int hamsterCount = animalRegistry.countAnimalByType("hamster");
            System.out.println("Count of hamsters: " + hamsterCount);
            System.out
                    .println("\n" + "Total number of animals in the registry: " + animalRegistry.getTotalAnimals()
                            + "\n");
            pw.close();

            // BufferedReader br = new BufferedReader(new FileReader(fileName));
            // String line;
            // while ((line = br.readLine()) != null) {
            //     System.out.println(line);
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
