package Java_6;
import java.util.HashMap;
import java.util.Scanner;
public class StudentGradesMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Double> studentGrades = new HashMap<>();
        int numberOfStudents;
        int studentId;
        int updateId;
        double grade;
        double newGrade;
        double totalGrades = 0;
        double averageGrade;
        String performanceClassification;
        System.out.println("Enter the number of students:");
        numberOfStudents = input.nextInt();
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.println("Enter Student ID " + i + ":");
                studentId = input.nextInt();
                if (studentGrades.containsKey(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");
                } else {
                    System.out.println("Enter Student Grade:");
                    grade = input.nextDouble();
                    studentGrades.put(studentId, grade);
                }
            }
            System.out.println("Enter Student ID to update:");
            updateId = input.nextInt();
            if (studentGrades.containsKey(updateId)) {
                System.out.println("Enter the new grade:");
                newGrade = input.nextDouble();
                studentGrades.replace(updateId, newGrade);
                System.out.println("Grade updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
            for (Double currentGrade : studentGrades.values()) {
                totalGrades += currentGrade;
            }
            averageGrade = totalGrades / studentGrades.size();
            if (averageGrade < 60) {
                performanceClassification = "Needs Improvement";
            } else if (averageGrade >= 60 && averageGrade <= 84) {
                performanceClassification = "Good Performance";
            } else {
                performanceClassification = "Excellent Performance";
            }
            System.out.println("\n Student Grades Report ");
            System.out.println("Total Student Records: " + studentGrades.size());
            System.out.println("Student IDs and Grades:");
            for (Integer id : studentGrades.keySet()) {
                System.out.println("ID: " + id + "  Grade: " + studentGrades.get(id));
            }
            System.out.println("Average Grade: " + averageGrade);
            System.out.println("Class Performance: " + performanceClassification);
        }
        input.close();
    }
}
