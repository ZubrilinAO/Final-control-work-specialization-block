import java.util.ArrayList;
import java.util.Scanner;

class AnimalRegistryApp {
    private AnimalRegistry registry;
    private Scanner scanner;

    public AnimalRegistryApp() {
        registry = new AnimalRegistry();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add new animal");
            System.out.println("2. List commands for an animal");
            System.out.println("3. Train an animal with a new command");
            System.out.println("4. List animals by date of birth");
            System.out.println("5. Show animal count");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listCommands();
                    break;
                case 3:
                    trainAnimal();
                    break;
                case 4:
                    listByDateOfBirth();
                    break;
                case 5:
                    showAnimalCount();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private boolean validateDateOfBirth(String dateOfBirth) {
        String pattern = "\\d{2}-\\d{2}-\\d{4}";
        return dateOfBirth.matches(pattern);
    }

    private void addAnimal() {
        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();
        System.out.print("Enter the date of birth of the animal (in the format DD-MM-YYYY): ");
        String dateOfBirth = scanner.nextLine();

        if (!validateDateOfBirth(dateOfBirth)) {
            System.out.println("Invalid date format. Please enter the date in the format DD-MM-YYYY.");
            return;
        }

        System.out.print("Enter the type of animal (dog, cat, hamster, horse, camel, donkey): ");
        String type = scanner.nextLine();

        Animals animal;

        switch (type.toLowerCase()) {
            case "dog":
                animal = new Dogs(name, dateOfBirth, new ArrayList<>());
                break;
            case "cat":
                animal = new Cats(name, dateOfBirth, new ArrayList<>());
                break;
            case "hamster":
                animal = new Hamsters(name, dateOfBirth, new ArrayList<>());
                break;
            case "horse":
                animal = new Horses(name, dateOfBirth, new ArrayList<>());
                break;
            case "camel":
                animal = new Camels(name, dateOfBirth, new ArrayList<>());
                break;
            case "donkey":
                animal = new Donkeys(name, dateOfBirth, new ArrayList<>());
                break;
            default:
                System.out.println("Invalid animal type.");
                return;
        }

        registry.addAnimal(animal);
        System.out.println("Animal successfully added to the registry.");
    }

    private void listCommands() {
        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (Animals animal : registry.getAnimals()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                registry.listCommands(animal);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Animal not found.");
        }
    }

    private void trainAnimal() {
        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (Animals animal : registry.getAnimals()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter the new command to train the animal: ");
                String newCommand = scanner.nextLine();
                registry.trainAnimal(animal, newCommand);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Animal not found.");
        }
    }

    private void listByDateOfBirth() {
        registry.listByDateOfBirth();
    }

    private void showAnimalCount() {
        System.out.println("Total number of animals: " + registry.getAnimals().size());
    }
}