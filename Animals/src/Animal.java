import java.util.ArrayList;
import java.util.Scanner;

public class Animal implements Comparable<Animal> {
    private String type;
    private String name;
    private String birthday;
    private ArrayList<String> commands;
    private ArrayList<Animal> animals;

    public Animal() {
    }

    public Animal(String type, String name, String birthday, ArrayList<String> commands) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void addNewCommand() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a new command for " + this.name + ":");
            String newCommand = scanner.nextLine();
            commands.add(newCommand);
        }
    }

    public void printCommands() {
        System.out.println("Commands for " + this.name + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }

    public void printAnimal() {
        System.out.println(animals);
    }

    // public int getCountOfAnimals(Object o) {
    // int line = 0;
    // for (Animal animal : animals){
    // System.out.println(animal.getType().equals(o));
    // line ++;
    // }
    // return line;
    // }

    @Override
    public int compareTo(Animal animal) {
        return getBirthday().compareTo(animal.getBirthday());
    }

    @Override
    public String toString() {
        return "Animal {type: " + getType() + ", name: " + getName() + ", birthday: "
                + getBirthday() + ", commands: " + getCommands() + "}";
    }
}
