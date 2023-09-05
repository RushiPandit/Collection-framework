import java.util.*;

// Employee base class
class Employee {
    // Define common fields and methods for all employees
    private String name;
    private int employeeId;
    
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }
    
    // Common methods like getters and setters
    
    public void performTask() {
        // Base task execution logic
    }
}

// Specialized employee classes (e.g., FrontDeskEmployee, HousekeepingEmployee)

class FrontDeskEmployee extends Employee {
    // Additional fields and methods specific to Front Desk employees
    
    public FrontDeskEmployee(String name, int employeeId) {
        super(name, employeeId);
    }
    
    @Override
    public void performTask() {
        // Front Desk task logic
    }
}

// Create similar specialized employee classes for other categories

// Employee Management
class EmployeeManagement {
    private List<FrontDeskEmployee> frontDeskEmployees;
    // Create similar collections for other employee categories
    
    public void hireFrontDeskEmployee(FrontDeskEmployee employee) {
        // Hire logic
    }
    
    // Create similar methods for other categories
}

// Exception classes
class DuplicateEmployeeException extends Exception {
    // Custom exception for duplicate employee
}

class InvalidTaskAssignmentException extends Exception {
    // Custom exception for invalid task assignment
}

// User Interface (Command-line interface in this example)
class HotelManagementSystem {
    public static void main(String[] args) {
        // Implement user interaction here
    }
}
