public class Animal {
    private String type;
    private String name;
    private String birthday;
    private String commands;


    public Animal(){
    }
       
    public Animal(String type, String name, String birthday, String commands) {
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
    public String getCommands() {
        return commands;
    }
    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Animal {type: " + getType() + ", name: " + getName() + ", birthday: "
        + getBirthday() + ", commands: " + getCommands() + "}";
    }

        
}
