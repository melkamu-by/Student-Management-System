package StudentManagementSystem;
 import java.util.ArrayList;
  import java.util.List;
    public class ManagementSystem {
    private List<Student> students;
    private List<Course> courses;
    public ManagementSystem() {
     this.students = new ArrayList<>();
      this.courses = new ArrayList<>();
    }
    public void addStudent(String id, String name) {
     if (findStudent(id) == null) {
       students.add(new Student(id, name));
        System.out.println("Student added successfully.");
          } else {
            System.out.println("Error: Student ID already exists.");
        }
    }
    public void addCourse(String code, String name, int credits) {
      if (findCourse(code) == null) {
       courses.add(new Course(code, name, credits));
        System.out.println("Course added successfully.");
          } else {
           System.out.println("Error: Course code already exists.");
        }
    }
    public Student findStudent(String id) {
     return students.stream().filter(s -> s.getStudentId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
     public Course findCourse(String code) {
      return courses.stream().filter(c -> c.getCourseCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
     public void displayAllStudents() {
      System.out.println("\n--- Registered Students ---");
        if (students.isEmpty()) System.out.println("No students registered.");
         else students.forEach(s -> System.out.println("ID: " + s.getStudentId() + " | Name: " + s.getName()));
    }
}
