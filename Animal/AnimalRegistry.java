import java.util.ArrayList;
import java.util.List;

class AnimalRegistry {
    private List<Animals> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
    }

    public void listCommands(Animals animal) {
        if (animal instanceof Pets) {
            System.out.println("List of commands for " + animal.getName() + ":");
            Pets pet = (Pets) animal;
            List<String> commands = pet.getCommands();
            if (commands.isEmpty()) {
                System.out.println("No commands available for " + animal.getName());
            } else {
                for (String command : commands) {
                    System.out.println("- " + command);
                }
            }
        } else {
            System.out.println("No commands available for " + animal.getName());
        }
    }

    public void trainAnimal(Animals animal, String newCommand) {
        if (animal instanceof Pets) {
            Pets pet = (Pets) animal;
            pet.addCommands(newCommand);
            System.out.println(animal.getName() + " has been trained with the new command: " + newCommand);
        } else {
            System.out.println("Cannot train commands for " + animal.getName());
        }
    }

    public void listByDateOfBirth() {
        System.out.println("List of animals by date of birth:");
        for (Animals animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getDateOfBirth() + ")");
        }
    }

    public List<Animals> getAnimals() {
        return animals;
    }
}