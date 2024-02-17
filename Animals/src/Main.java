import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {

        Animal newCat_1 = new Cats("cat", "Suzy", "2020-11-11", "meow");
        Animal newCat_2 = new Cats("cat", "Tom", "2022-11-11", "lie");
        Animal newCat_3 = new Cats("cat", "Jary", "2019-11-11", "play");
        ArrayList<Animal> cats = new ArrayList<>();
        cats.add(newCat_1);
        cats.add(newCat_2);
        cats.add(newCat_3);

        Animal newDog_1 = new Dogs("dog", "Tom", "2002-01-01", "seat");
        Animal newDog_2 = new Dogs("dog", "Bobby", "2002-02-02", "walk");
        Animal newDog_3 = new Dogs("dog", "Rex", "2002-03-03", "bark");
        ArrayList<Animal> dogs = new ArrayList<>();
        dogs.add(newDog_1);
        dogs.add(newDog_2);
        dogs.add(newDog_3);

        Animal newHamster_1 = new Hamsters("hamster", "Bob", "2003-01-01", "run");
        Animal newHamster_2 = new Hamsters("hamster", "Sam", "2003-02-02", "lie");
        Animal newHamster_3 = new Hamsters("hamster", "Lory", "2003-03-03", "sleep");
        ArrayList<Animal> hamsters = new ArrayList<>();
        hamsters.add(newHamster_1);
        hamsters.add(newHamster_2);
        hamsters.add(newHamster_3);

        Animal newAnimal = Pets.getNewAnimal();
        Animal animalNewAnimal = new Animal(newAnimal.getType(), newAnimal.getName(), newAnimal.getBirthday(), newAnimal.getCommands());
        // System.out.println(newAnimal);
        if (animalNewAnimal.getType().equals("cat")){
            cats.add(animalNewAnimal);
            System.out.println(cats);
            System.out.println("Выполняемые команды: " + newAnimal.getCommands());
        }
        else if (newAnimal.getType().equals("dog")){
            dogs.add(animalNewAnimal);
            System.out.println(dogs);
            System.out.println("Выполняемые команды: " + newAnimal.getCommands());
        }
        else if (newAnimal.getType().equals("hamster")){
            hamsters.add(animalNewAnimal);
            System.out.println(hamsters);
            System.out.println("Выполняемые команды: " + newAnimal.getCommands());
        }

      
                 

    }
}
    

