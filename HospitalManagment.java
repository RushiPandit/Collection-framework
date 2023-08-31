import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class HospitalManagementSystem {
    public static void main(String[] args) {
        Map<Integer, Patient> patients = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient Details");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. List All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    patients.put(id, new Patient(id, name, age));
                    System.out.println("Patient added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    int viewId = scanner.nextInt();
                    if (patients.containsKey(viewId)) {
                        Patient patient = patients.get(viewId);
                        System.out.println("Patient Details - ID: " + patient.id +
                                ", Name: " + patient.name + ", Age: " + patient.age);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();
                    if (patients.containsKey(searchId)) {
                        Patient patient = patients.get(searchId);
                        System.out.println("Patient found - ID: " + patient.id +
                                ", Name: " + patient.name + ", Age: " + patient.age);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        System.out.println("List of Patients:");
                        for (Patient patient : patients.values()) {
                            System.out.println("ID: " + patient.id +
                                    ", Name: " + patient.name + ", Age: " + patient.age);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
