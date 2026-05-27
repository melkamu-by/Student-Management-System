# Student Management System

A production-ready, console-based **Student Management System** implemented in Java. This project demonstrates clean coding practices, decoupled architecture, and fundamental Object-Oriented Programming (OOP) principles.

The source code is organized entirely under the `/src` directory as specified by the project layout configurations.

---

## Architectural & Design Theory

To ensure scalability, readability, and ease of maintenance, this system avoids bundling logic into a single monolithic file. Instead, it relies on a decoupled, layer-based architecture heavily rooted in OOP fundamentals.

### 1. The Core OOP Pillars Implemented

* **Encapsulation**: Every entity (`Student`, `Course`) safeguards its internal state by declaring attributes as `private`. Interaction with these objects is strictly controlled through public methods (getters, setters, and operational logic). For example, a student's GPA cannot be overwritten directly; it is calculated dynamically based on controlled data state transformations.
* **Abstraction**: Complex operations, such as calculating weighted averages or traversing nested collections, are hidden behind clear, simple method boundaries (e.g., `s.calculateGPA()`). The user interface interacts with high-level workflows without needing to manage raw pointer or collection operations.

### 2. Domain Modeling and Relationships

The system relies on concrete mappings to simulate real-world university relationships:

* **One-to-Many / Many-to-Many via Mappings**: A `Student` can enroll in multiple `Course` objects. Rather than maintaining separate parallel arrays, this is managed natively using a Java `Map<Course, Double>`. This binds the specific course object directly to the numeric grade achieved by the student, ensuring strict data integrity.
* **Separation of Concerns**:
* **Domain Models (`Student.java`, `Course.java`)**: Pure data structures containing attributes, constructors, and direct atomic behaviors.
* **Service/Controller Layer (`ManagementSystem.java`)**: Acts as an in-memory database and coordinator, executing filtering logic, validating uniqueness constraints (e.g., preventing duplicate Student IDs), and managing state collections.
* **Presentation Layer (`Main.java`)**: The CLI wrapper managing I/O operations and directing user intents to the service layer.



### 3. Data Structures & Algorithmic Design

* **Dynamic Sizing (`ArrayList`)**: Used within the management system to handle an unpredictable number of student registrations without running into fixed-array overflows.
* **Lookup Mechanics**: Java Streams and lambda expressions (`.stream().filter()`) are utilized to isolate specific objects within collection arrays, mimicking basic query executions found in relational databases.
* **Mathematical Precision**: The Grade Point Average (GPA) is computed as a weighted cumulative metric using the mathematical formula:

$$GPA = \frac{\sum_{i=1}^{n} (\text{Grade}_i \times \text{Credits}_i)}{\sum_{i=1}^{n} \text{Credits}_i}$$

This ensures that higher-credit courses impact the overall GPA with proportional mathematical weight, ignoring unsubmitted or pending (`-1.0`) grades.

---

## Component Breakdown

* **`Main`**: Orchestrates the system runtime loop, reads console input, and handles application state exit paths.
* **`ManagementSystem`**: Hosts core arrays for courses and students, serving as the central management hub.
* **`Student`**: Controls individual student profiles, enrollment status, transcripts, and calculations.
* **`Course`**: Identifies course modules, cataloging titles, numeric IDs, and structural academic weight.