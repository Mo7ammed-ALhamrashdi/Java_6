package Java_6;
import java.util.HashSet;
import java.util.Scanner;
public class CourseEnrollmentSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<String> courses = new HashSet<>();
        int numberOfCourses;
        String courseName;
        String removeCourse;
        String catalogClassification;
        boolean removed;
        System.out.println("Enter the number of courses:");
        numberOfCourses = input.nextInt();
        input.nextLine();
        if (numberOfCourses <= 0) {
            System.out.println("Invalid number of courses.");
        } else {
            for (int i = 1; i <= numberOfCourses; i++) {

                System.out.println("Enter course name " + i + ":");
                courseName = input.nextLine();
                if (!courses.add(courseName)) {
                    System.out.println("Course already exists. Duplicate entries are not allowed.");
                }
            }
            System.out.println("Enter the course name to remove:");
            removeCourse = input.nextLine();
            removed = courses.remove(removeCourse);
            if (removed) {
                System.out.println("Course removed successfully.");
            } else {
                System.out.println("Course not found.");
            }
            if (courses.size() < 4) {
                catalogClassification = "Small Course Catalog";
            } else if (courses.size() >= 4 && courses.size() <= 8) {
                catalogClassification = "Medium Course Catalog";
            } else {
                catalogClassification = "Large Course Catalog";
            }
            System.out.println("\n Course Enrollment Report ");
            System.out.println("Total Courses Entered: " + numberOfCourses);
            System.out.println("Total Unique Courses Remaining: " + courses.size());
            System.out.println("All Remaining Course Names: " + courses);
            System.out.println("Course Catalog Classification: " + catalogClassification);
        }
        input.close();
    }
}
