package StudentManagementSystem;
 public class Course {
  private String courseCode;
   private String courseName;
    private int credits;
      public Course(String courseCode, String courseName, int credits) {
    this.courseCode = courseCode;
   this.courseName = courseName;
  this.credits = credits;
    }
     // Getters and Setters
      public String getCourseCode() { 
       return courseCode; }
        public String getCourseName() { 
         return courseName; }
          public int getCredits() { 
           return credits; }
            public String toString() {
             return String.format("[%s] %s (%d Credits)", courseCode, courseName, credits);
            }
           }