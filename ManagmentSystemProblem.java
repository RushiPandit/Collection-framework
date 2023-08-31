import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Project {
    String name;
    String description;
    Set<String> teamMembers;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.teamMembers = new HashSet<>();
    }
}

class ProjectManagementSystem {
    public static void main(String[] args) {
        Map<String, Project> projects = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Project");
            System.out.println("2. Add Team Member");
            System.out.println("3. View Project Details");
            System.out.println("4. List All Projects");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Project Name: ");
                    scanner.nextLine(); // Consume newline
                    String projectName = scanner.nextLine();
                    System.out.print("Enter Project Description: ");
                    String projectDescription = scanner.nextLine();
                    projects.put(projectName, new Project(projectName, projectDescription));
                    System.out.println("Project added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Project Name: ");
                    scanner.nextLine(); // Consume newline
                    String teamProjectName = scanner.nextLine();
                    if (projects.containsKey(teamProjectName)) {
                        Project project = projects.get(teamProjectName);
                        System.out.print("Enter Team Member Name: ");
                        String teamMemberName = scanner.nextLine();
                        project.teamMembers.add(teamMemberName);
                        System.out.println("Team member added to the project!");
                    } else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Project Name: ");
                    scanner.nextLine(); // Consume newline
                    String viewProjectName = scanner.nextLine();
                    if (projects.containsKey(viewProjectName)) {
                        Project project = projects.get(viewProjectName);
                        System.out.println("Project Details - Name: " + project.name +
                                ", Description: " + project.description);
                        System.out.println("Team Members:");
                        for (String teamMember : project.teamMembers) {
                            System.out.println("- " + teamMember);
                        }
                    } else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 4:
                    if (projects.isEmpty()) {
                        System.out.println("No projects found.");
                    } else {
                        System.out.println("List of Projects:");
                        for (Project project : projects.values()) {
                            System.out.println("Project Name: " + project.name +
                                    ", Description: " + project.description);
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
