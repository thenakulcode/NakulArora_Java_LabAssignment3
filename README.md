📘 Student Management System – Java (Exception Handling + Multithreading + Wrapper Classes)

A simple and robust Student Management System implemented in Java that demonstrates:

Exception Handling

Custom Exceptions

Multithreading

Wrapper Classes (Integer, Double)

User Input Validation

Simulated Loading Process

This project is created as part of an academic assignment focusing on safe execution, responsive UI simulation, and proper use of Java features.

🚀 Features ✔ Exception Handling Detects invalid marks (<0 or >100) Detects empty fields (name, email, course) Handles invalid numeric inputs Custom exception StudentNotFoundException

✔ Multithreading Loader class implements Runnable Simulates a loading process using a separate thread Uses Thread.sleep() for delay animation ✔ Wrapper Classes Uses Integer for roll number Uses Double for marks Demonstrates autoboxing and parsing using wrapper classes

✔ Clean and Simple Structure Student class for student data RecordActions interface StudentManager that implements all logic StudentManagementSystem (main class)

🧩 Class Structure StudentManagementSystem │ ├── Student ├── StudentManager (implements RecordActions) ├── Loader (implements Runnable) └── StudentNotFoundException (custom exception)

📥 How to Run

Clone the repository:

git clone https://github.com/yourusername/StudentManagementSystem.git Navigate into project folder: cd StudentManagementSystem Compile the program: javac StudentManagementSystem.java Run the program: java StudentManagementSystem

🖥️ Sample Output Enter Roll No (Integer): 102 Enter Name: Karan Enter Email: karan@mail.com Enter Course: BCA Enter Marks: 77.5 Loading..... Student added successfully! Add student process finished.

Roll No: 102 Name: Karan Email: karan@mail.com Course: BCA Marks: 77.5 Grade: B Program execution completed.

📚 Concepts Demonstrated Concept Implementation Exception Handling try-catch-finally Custom Exceptions StudentNotFoundException Multithreading Loader thread simulating loading Wrapper Classes Integer, Double Autoboxing Automatic conversion between primitives and wrappers User Input Validation Checking empty fields and invalid marks 🛠️ Technologies Used

Java 8+ OOP Concepts Multithreading Custom Exception Handling

🧑‍💻 Author

Nakul Arora B.Tech CSE – K.R. Mangalam University
