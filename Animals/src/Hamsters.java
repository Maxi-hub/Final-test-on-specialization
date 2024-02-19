import java.util.ArrayList;

public class Hamsters extends Animal {
    private int id;

    public Hamsters(String type, String name, String birthday, ArrayList<String> commands) {
        super(type, name, birthday, commands);
    }

    public Hamsters(String type, String name, String birthday, ArrayList<String> commands, int id) {
        super(type, name, birthday, commands);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hamster {type: " + super.getType() + ", name: " + super.getName() + ", birthday: "
                + super.getBirthday() + ", commands: " + super.getCommands() + "}";
    }

}
