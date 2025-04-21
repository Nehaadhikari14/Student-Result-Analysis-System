package javaapplication1;

import java.util.*;

class Student {
    String name;
    int rollNo;
    int marks[] = new int[3];
    int total;
    double percentage;

    // Constructor
    Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.total = marks[0] + marks[1] + marks[2];
        this.percentage = total / 3.0;
    }

    // Display Student Result
    void displayResult() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Result: " + (percentage >= 40 ? "Pass" : "Fail"));
    }
}

public class StudentResultAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        while (true) {
            System.out.println("\n1. Add Student Result");
            System.out.println("2. Display All Results");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    sc.nextLine(); // Consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    int marks[] = new int[3];
                    System.out.println("Enter marks for 3 subjects: ");
                    for (int i = 0; i < 3; i++) {
                        marks[i] = sc.nextInt();
                    }
                    students.add(new Student(name, rollNo, marks));
                    System.out.println("Student Result Added Successfully!");
                }
                
                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("No student records found!");
                    } else {
                        for (Student s : students) {
                            s.displayResult();
                        }
                    }
                }
                
                case 3 -> {
                    System.out.println("Exiting Program...");
                    sc.close();
                    return;
                }
                
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

