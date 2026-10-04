
# 🎓 Student Management System

A production-ready, **console-based Student Management System** built in Java. This project demonstrates clean coding practices, decoupled architecture, and fundamental Object-Oriented Programming (OOP) principles.

> 📁 All source code is organized under the project root following a clean, layered architecture.

---

## 📐 Architectural & Design Theory

To ensure scalability, readability, and ease of maintenance, this system avoids bundling logic into a single monolithic file. Instead, it relies on a **decoupled, layer-based architecture** rooted in solid OOP principles.

### 🧱 1. Core OOP Pillars Implemented

- 🔒 **Encapsulation** — Every entity (`Student`, `Course`) safeguards its internal state by declaring attributes as `private`. Interaction is strictly controlled through public getters/setters.
- 🧩 **Abstraction** — Complex operations, such as calculating weighted averages or traversing nested collections, are hidden behind simple method calls (e.g., `student.calculateGPA()`).

### 🔗 2. Domain Modeling and Relationships

The system relies on concrete mappings to simulate real-world university relationships:

- 🔁 **One-to-Many / Many-to-Many via Mappings** — A `Student` can enroll in multiple `Course` objects, managed natively using a Java `Map<Course, Double>` instead of parallel arrays.
- 🗂️ **Separation of Concerns**:
  - 📄 **Domain Models** (`Student.java`, `Course.java`) — Pure data structures with attributes, constructors, and atomic behaviors.
  - ⚙️ **Service/Controller Layer** (`ManagementSystem.java`) — Acts as an in-memory database, handling filtering logic and uniqueness validation (e.g., preventing duplicate IDs).
  - 🖥️ **Presentation Layer** (`Main.java`) — The CLI wrapper managing I/O operations and routing user intents to the service layer.

### 📊 3. Data Structures & Algorithmic Design

- 📈 **Dynamic Sizing (`ArrayList`)** — Handles an unpredictable number of student registrations without fixed-array overflow.
- 🔍 **Lookup Mechanics** — Java Streams and lambda expressions (`.stream().filter()`) isolate specific objects within collections, mimicking basic query execution.
- 🧮 **Mathematical Precision** — GPA is computed as a weighted cumulative metric:

$$GPA = \frac{\sum_{i=1}^{n} (\text{Grade}_i \times \text{Credits}_i)}{\sum_{i=1}^{n} \text{Credits}_i}$$

  This ensures higher-credit courses proportionally impact the overall GPA, while ignoring unsubmitted or pending (`-1.0`) grades.

---

## 🧩 Component Breakdown

| Component | Responsibility |
|---|---|
| 🖥️ **`Main`** | Orchestrates the runtime loop, reads console input, and handles application exit paths |
| ⚙️ **`ManagementSystem`** | Hosts core collections for courses and students; the central management hub |
| 🧑‍🎓 **`Student`** | Manages individual student profiles, enrollment status, transcripts, and GPA calculations |
| 📘 **`Course`** | Represents course modules, including titles, codes, and credit weight |

---

## 🚀 Features

- ✅ Register new students
- 📋 View all registered students
- ✏️ Enroll students in courses
- 🏆 Assign grades to students
- 📄 View a student's full transcript with calculated GPA
- 🚪 Clean exit from the console application

---

## ▶️ Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/melkamu-by/Student-Management-System.git
   ```
2. **Compile the project**
   ```bash
   javac *.java -d out
   ```
3. **Run the application**
   ```bash
   java -cp out StudentManagementSystem.Main
   ```

---

## 🛠️ Tech Stack

- ☕ **Java** (100%)

---

## 📜 License

This project is open for educational and demonstration purposes. Feel free to fork and extend it! ⭐
