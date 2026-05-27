package StudentManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagementSystem sms = new ManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Seed some initial data
        sms.addCourse("CS101", "Introduction to Computer Science", 4);
        sms.addCourse("MATH201", "Calculus I", 3);

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Assign Grade to Student");
            System.out.println("5. View Student Transcript");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    sms.addStudent(id, name);
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String sId = scanner.nextLine();
                    System.out.print("Enter Course Code (e.g., CS101, MATH201): ");
                    String cCode = scanner.nextLine();

                    Student s = sms.findStudent(sId);
                    Course c = sms.findCourse(cCode);

                    if (s != null && c != null) s.enrollInCourse(c);
                    else System.out.println("Error: Student or Course not found.");
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String gradeId = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String gradeCode = scanner.nextLine();
                    System.out.print("Enter Grade (0.0 - 4.0): ");
                    double grade = scanner.nextDouble();

                    Student gradeStudent = sms.findStudent(gradeId);
                    Course gradeCourse = sms.findCourse(gradeCode);

                    if (gradeStudent != null && gradeCourse != null) {
                        gradeStudent.assignGrade(gradeCourse, grade);
                    } else {
                        System.out.println("Error: Student or Course not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    String transcriptId = scanner.nextLine();
                    Student tStudent = sms.findStudent(transcriptId);
                    if (tStudent != null) tStudent.displayTranscript();
                    else System.out.println("Student not found.");
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
