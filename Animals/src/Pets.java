import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pets {
    Scanner scanner;

    static Animal getNewAnimal() throws IOException {

        Animal newAnimal = new Animal();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input type of animal (cat, dog, hamster, horse, camel or donkey): ");
        String type = scanner.nextLine();
        newAnimal.setType(type);
        System.out.print("Input animal name: ");
        String animalName = scanner.nextLine();
        newAnimal.setName(animalName);
        System.out.print("Input animal's date of birthday (yyyy-mm-dd): ");
        String animalBirthday = scanner.nextLine();
        newAnimal.setBirthday(animalBirthday);
        System.out.print("Input commands for animal: ");
        ArrayList<String> animalCommands = new ArrayList<>();
        animalCommands.add(scanner.nextLine());
        newAnimal.setCommands(animalCommands);

        if (type.equals("cat")) {
            Cats newCat = new Cats(type, animalName, animalBirthday, animalCommands);
            return newCat;
        } else if (type.equals("dog")) {
            Dogs newDog = new Dogs(type, animalName, animalBirthday, animalCommands);
            return newDog;
        } else if (type.equals("hamster")) {
            Hamsters newHamster = new Hamsters(type, animalName, animalBirthday, animalCommands);
            return newHamster;
        }

        return newAnimal;

    }
}
