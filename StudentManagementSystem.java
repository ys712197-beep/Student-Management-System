package StudentSystem.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // ArrayList to store students
    private static ArrayList<Student> students = new ArrayList<>();

    // Scanner for user input
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            showMenu();

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    deleteStudent();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    displayAll();
                    break;

                case 6:
                    findHighestLowest();
                    break;

                case 7:
                    searchById();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // ============================
    // SHOW MENU
    // ============================

    private static void showMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================");

        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Search Student By Name");
        System.out.println("4. Update Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Find Highest & Lowest Marks");
        System.out.println("7. Search Student By ID");
        System.out.println("0. Exit");

        System.out.println("======================================");
    }

    // ============================
    // ADD STUDENT
    // ============================

    private static void addStudent() {

        System.out.println();
        System.out.println("-------- ADD STUDENT --------");

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (Student s : students) {

            if (s.getid() == id) {

                System.out.println(
                        "Student with this ID already exists!"
                );

                return;
            }
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        // Create Student object
        Student student = new Student(id, name, marks);

        // Add student to ArrayList
        students.add(student);

        System.out.println(
                "Student added successfully!"
        );
    }

    // ============================
    // DELETE STUDENT
    // ============================

    private static void deleteStudent() {

        System.out.println();
        System.out.println("-------- DELETE STUDENT --------");

        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getid() == id) {

                students.remove(i);

                System.out.println(
                        "Student deleted successfully!"
                );

                return;
            }
        }

        System.out.println(
                "Student with ID " + id + " was not found."
        );
    }

    // ============================
    // SEARCH BY NAME
    // ============================

    private static void searchStudent() {

        System.out.println();
        System.out.println("-------- SEARCH STUDENT --------");

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Student s : students) {

            if (s.getname().equalsIgnoreCase(name)) {

                System.out.println("Student found!");
                System.out.println(s);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "Student with name " + name +
                            " was not found."
            );
        }
    }

    // ============================
    // UPDATE STUDENT
    // ============================

    private static void updateStudent() {

        System.out.println();
        System.out.println("-------- UPDATE STUDENT --------");

        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.getid() == id) {

                System.out.println("Student found!");
                System.out.println(s);

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                sc.nextLine();

                // Update values
                s.setname(name);
                s.setmarks(marks);

                System.out.println(
                        "Student information updated successfully!"
                );

                return;
            }
        }

        System.out.println(
                "Student with ID " + id +
                        " was not found."
        );
    }

    // ============================
    // DISPLAY ALL STUDENTS
    // ============================

    private static void displayAll() {

        System.out.println();
        System.out.println("-------- ALL STUDENTS --------");

        if (students.isEmpty()) {

            System.out.println(
                    "There are no students in the system."
            );

            return;
        }

        for (Student s : students) {

            System.out.println(s);
        }
    }

    // ============================
    // HIGHEST & LOWEST MARKS
    // ============================

    private static void findHighestLowest() {

        System.out.println();
        System.out.println("-------- HIGHEST & LOWEST MARKS --------");

        if (students.isEmpty()) {

            System.out.println(
                    "There are no students in the system."
            );

            return;
        }

        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student s : students) {

            if (s.getmarks() > highest.getmarks()) {

                highest = s;
            }

            if (s.getmarks() < lowest.getmarks()) {

                lowest = s;
            }
        }

        System.out.println(
                "Highest Marks: " + highest
        );

        System.out.println(
                "Lowest Marks: " + lowest
        );
    }

    // ============================
    // SEARCH BY ID
    // ============================

    private static void searchById() {

        System.out.println();
        System.out.println("-------- SEARCH BY ID --------");

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.getid() == id) {

                System.out.println("Student found!");
                System.out.println(s);

                return;
            }
        }

        System.out.println(
                "Student with ID " + id +
                        " does not exist."
        );
    }
}
