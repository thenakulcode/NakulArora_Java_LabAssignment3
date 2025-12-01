import java.util.Scanner;

// ----------------------------- Custom Exception -----------------------------
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// ----------------------------- Loader Thread -----------------------------
class Loader implements Runnable {
    @Override
    public void run() {
        System.out.print("Loading");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            System.out.println("Loader interrupted!");
        }
        System.out.println();
    }
}

// ----------------------------- Student Class -----------------------------
class Student {
    Integer rollNo;
    String name;
    String email;
    String course;
    Double marks;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else return "D";
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

// ----------------------------- RecordActions Interface -----------------------------
interface RecordActions {
    void addStudent();
    void displayStudent() throws StudentNotFoundException;
}

// ----------------------------- StudentManager Class -----------------------------
class StudentManager implements RecordActions {

    Student student;

    @SuppressWarnings("resource")  // Remove scanner warning
    Scanner sc = new Scanner(System.in);

    @Override
    public void addStudent() {
        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) throw new Exception("Name cannot be empty!");

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            if (email.isEmpty()) throw new Exception("Email cannot be empty!");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            if (course.isEmpty()) throw new Exception("Course cannot be empty!");

            System.out.print("Enter Marks: ");
            Double marks = Double.parseDouble(sc.nextLine());
            if (marks < 0 || marks > 100)
                throw new Exception("Marks must be between 0 and 100!");

            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            student = new Student(roll, name, email, course, marks);
            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format! Please enter numeric values.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Add student process finished.\n");
        }
    }

    @Override
    public void displayStudent() throws StudentNotFoundException {
        if (student == null)
            throw new StudentNotFoundException("No student record available!");

        student.display();
    }
}

// ----------------------------- Main Class -----------------------------
public class StudentManagementSystem {
    public static void main(String[] args) {

        StudentManager sm = new StudentManager();

        try {
            sm.addStudent();
            sm.displayStudent();
        }
        catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Program execution completed.");
        }
    }
}
