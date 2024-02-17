
public class Dogs extends Animal {
    private int id;

    public Dogs(String type, String name, String birthday, String commands) {
        super(type, name, birthday, commands);
    }

    public Dogs(String type, String name, String birthday, String commands, int id) {
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
        return "Dog {type: " + super.getType() + ", name: " + super.getName() + ", birthday: "
                + super.getBirthday() + ", commands: " + super.getCommands() + "}";
    }

}
