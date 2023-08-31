import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    employeeList.add(new Employee(id, name));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("Employee Details:");
                        for (Employee employee : employeeList) {
                            System.out.println("ID: " + employee.id + ", Name: " + employee.name);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;
                    for (Employee employee : employeeList) {
                        if (employee.id == searchId) {
                            System.out.println("Employee found - ID: " + employee.id + ", Name: " + employee.name);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
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
