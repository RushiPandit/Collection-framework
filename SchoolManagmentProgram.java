import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int studentId;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
}

class SchoolManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Display Student Details");
            System.out.println("4. Display Teacher Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    scanner.nextLine(); // Consume newline
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    students.add(new Student(studentName, studentAge, studentId));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Teacher Name: ");
                    scanner.nextLine(); // Consume newline
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter Teacher Age: ");
                    int teacherAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();
                    teachers.add(new Teacher(teacherName, teacherAge, subject));
                    System.out.println("Teacher added successfully!");
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("Student Details:");
                        for (Student student : students) {
                            System.out.println("Name: " + student.name + ", Age: " + student.age +
                                    ", Student ID: " + student.studentId);
                        }
                    }
                    break;

                case 4:
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers found.");
                    } else {
                        System.out.println("Teacher Details:");
                        for (Teacher teacher : teachers) {
                            System.out.println("Name: " + teacher.name + ", Age: " + teacher.age +
                                    ", Subject: " + teacher.subject);
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
