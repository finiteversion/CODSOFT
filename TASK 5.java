import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean removeStudent(int rollNumber) {
        return students.removeIf(s -> s.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class Main {  // Important: must match online compiler default class name
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    manager.addStudent(new Student(name, roll, grade));
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRoll = scanner.nextInt();
                    boolean removed = manager.removeStudent(removeRoll);
                    System.out.println(removed ? "Student removed." : "Student not found.");
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = scanner.nextInt();
                    Student found = manager.searchStudent(searchRoll);
                    System.out.println(found != null ? found : "Student not found.");
                    break;

                case 4:
                    List<Student> list = manager.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : list) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}