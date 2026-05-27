package StudentManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentId;
    private String name;
    private Map<Course, Double> enrolledCourses; // Stores Course and the numeric grade (0.0 - 4.0)

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new HashMap<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public Map<Course, Double> getEnrolledCourses() { return enrolledCourses; }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, -1.0); // -1.0 signifies "No grade assigned yet"
            System.out.println(name + " successfully enrolled in " + course.getCourseName());
        } else {
            System.out.println("Student is already enrolled in this course.");
        }
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            if (grade >= 0.0 && grade <= 4.0) {
                enrolledCourses.put(course, grade);
                System.out.println("Grade updated successfully.");
            } else {
                System.out.println("Error: Grade must be between 0.0 and 4.0.");
            }
        } else {
            System.out.println("Error: Student is not enrolled in this course.");
        }
    }

    // Mathematical implementation for Cumulative GPA:
    // GPA = sum(Grade * Credits) / sum(Total Credits)
    public double calculateGPA() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Map.Entry<Course, Double> entry : enrolledCourses.entrySet()) {
            double grade = entry.getValue();
            if (grade != -1.0) { // Only calculate courses that have been graded
                int credits = entry.getKey().getCredits();
                totalPoints += grade * credits;
                totalCredits += credits;
            }
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    public void displayTranscript() {
        System.out.println("\n--- Transcript for " + name + " (ID: " + studentId + ") ---");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
            return;
        }
        enrolledCourses.forEach((course, grade) -> {
            String gradeStr = (grade == -1.0) ? "N/A" : String.valueOf(grade);
            System.out.println(course + " | Grade: " + gradeStr);
        });
        System.out.printf("Current GPA: %.2f\n", calculateGPA());
    }
}