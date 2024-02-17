import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Pets {

    static Animal getNewAnimal() throws IOException {
        Animal newAnimal = new Animal();
        String fileName = "Animals";
        try (FileWriter fileWriter = new FileWriter(Paths.get(fileName).toFile(), true)) {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.readLine();
            // String s = System.lineSeparator();
            // fileWriter.write(s);
            fileWriter.append("\n");
            System.out.print("Что будем делать: /n1-добавим новое животное /n2-добавим новую команду существующему животному");
            try {Scanner scanner = new Scanner(System.in);
                Integer number = scanner.nextInt();
                switch (number) {
                    case 1:
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
                    String animalCommands = scanner.nextLine();
                    newAnimal.setCommands(animalCommands);
                    if (type.equals("cat")) {
                        Cats newCat = new Cats(type, animalName, animalBirthday, animalCommands);
                            // System.out.println(newCat.toString());
                        fileWriter.write(newCat.toString());
                        return newCat;
                    } else if (type.equals("dog")) {
                        Dogs newDog = new Dogs(type, animalName, animalBirthday, animalCommands);
                            // System.out.println(newDog.toString());
                        fileWriter.write(newDog.toString());
                        return newDog;
                    } else if (type.equals("hamster")) {
                        Hamsters newHamster = new Hamsters(type, animalName, animalBirthday, animalCommands);
                            // System.out.println(newHamster.toString());
                        fileWriter.write(newHamster.toString());
                        return newHamster;
                    }
                    break;
                    case 2:
                    System.out.print("Укажите какому животному добавим команду: (cat, dog, hamster)");
                    // String type = scanner.nextLine();
                
                            
                    
                    default:
                        break;

                }
                
                
            }
            finally{}
        }
            return newAnimal;
    }

}
