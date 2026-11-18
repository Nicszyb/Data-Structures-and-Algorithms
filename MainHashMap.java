import java.util.HashMap;
import java.util.Scanner;

public class MainHashMap {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SubClassHashMap manager = new SubClassHashMap();

        int choice;

        do {
            System.out.println("\n===== STUDENT HASHMAP MENU =====");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Remove");
            System.out.println("4. Display All");
            System.out.println("5. Display Specific");
            System.out.println("6. Search Key");
            System.out.println("7. Display Total");
            System.out.println("8. Clear");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter student ID: ");
                    int addId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter student name: ");
                    String addName = input.nextLine();

                    if (manager.hasStudent(addId)) {
                        System.out.println("Student ID already exists.");
                    } else {
                        manager.addStudent(addId, addName);
                        System.out.println("Student added successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    int updateId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new student name: ");
                    String newName = input.nextLine();

                    manager.updateStudent(updateId, newName);
                    break;

                case 3:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = input.nextInt();

                    manager.removeStudent(removeId);
                    break;

                case 4:
                    manager.displayAll();
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int specificId = input.nextInt();

                    manager.displaySpecific(specificId);
                    break;

                case 6:
                    System.out.print("Enter student ID to search: ");
                    int searchId = input.nextInt();

                    manager.searchKey(searchId);
                    break;

                case 7:
                    manager.displayTotal();
                    break;

                case 8:
                    manager.clearAll();
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        input.close();
    }
}

abstract class AbstractClassHashMap {

    protected HashMap<Integer, String> students =
            new HashMap<>();

    abstract boolean hasStudent(int id);

    abstract void addStudent(int id, String name);

    abstract void updateStudent(int id, String name);

    abstract void removeStudent(int id);

    abstract void displayAll();

    abstract void displaySpecific(int id);

    abstract void searchKey(int id);

    abstract void displayTotal();

    abstract void clearAll();
}

class SubClassHashMap extends AbstractClassHashMap {

    @Override
    public boolean hasStudent(int id) {
        return students.containsKey(id);
    }

    @Override
    public void addStudent(int id, String name) {
        students.put(id, name);
    }

    @Override
    public void updateStudent(int id, String name) {
        if (students.containsKey(id)) {
            students.put(id, name);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    @Override
    public void removeStudent(int id) {
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    @Override
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            System.out.println(students);
        }
    }

    @Override
    public void displaySpecific(int id) {
        if (students.containsKey(id)) {
            System.out.println("Student with ID " + id
                    + ": " + students.get(id));
        } else {
            System.out.println("Student ID not found.");
        }
    }

    @Override
    public void searchKey(int id) {
        System.out.println("Is Student ID " + id
                + " existing? " + students.containsKey(id));
    }

    @Override
    public void displayTotal() {
        System.out.println("Total Students: " + students.size());
    }

    @Override
    public void clearAll() {
        students.clear();
        System.out.println("All students have been cleared.");
    }
}
