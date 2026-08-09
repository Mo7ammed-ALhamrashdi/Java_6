package Java_6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CourseEnrollmentSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();
        HashMap<Integer, String> studentCourses = new HashMap<>();
        int numberOfStudents;
        int studentId;
        int updateStudentId;
        String courseName;
        String newCourseName;
        String enrollmentClassification;
        System.out.println("Enter the number of students:");
        numberOfStudents = input.nextInt();
        input.nextLine();
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.println("Enter Student ID " + i + ":");
                studentId = input.nextInt();
                input.nextLine();
                if (studentIds.contains(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");
                } else {
                    System.out.println("Enter Course Name:");
                    courseName = input.nextLine();
                    studentIds.add(studentId);
                    studentCourses.put(studentId, courseName);
                }
            }
            System.out.println("Enter Student ID to update:");
            updateStudentId = input.nextInt();
            input.nextLine();
            if (studentCourses.containsKey(updateStudentId)) {
                System.out.println("Enter the new course name:");
                newCourseName = input.nextLine();
                studentCourses.replace(updateStudentId, newCourseName);
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
            if (studentIds.size() < 5) {
                enrollmentClassification = "Small Enrollment";
            } else if (studentIds.size() >= 5 && studentIds.size() <= 15) {
                enrollmentClassification = "Medium Enrollment";
            } else {
                enrollmentClassification = "Large Enrollment";
            }
            System.out.println("\n Course Enrollment Report ");
            System.out.println("Total Student Records Entered: " + numberOfStudents);
            System.out.println("Total Unique Students: " + studentIds.size());
            System.out.println("All Student IDs:");
            System.out.println(studentIds);
            System.out.println("Student IDs with Enrolled Courses:");
            for (Integer id : studentCourses.keySet()) {
                System.out.println("Student ID: " + id + "| Course: " + studentCourses.get(id));
            }
            System.out.println("Enrollment Classification:" + enrollmentClassification);
        }
        input.close();
    }
}