import java.util.List;

class Animals {
    private String name;
    private String dateOfBirth;
    private List<String> commands;

    public Animals(String name, String dateOfBirth, List<String> commands) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void addCommands(String команда) {
        commands.add(команда);
    }

    public List<String> getCommands() {
        return commands;
    }
}
