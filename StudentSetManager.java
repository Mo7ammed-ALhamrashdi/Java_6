package Java_6;
import java.util.HashSet;
import java.util.Scanner;
public class StudentSetManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();
        int numberOfStudents;
        int studentId;
        String registrationClassification;
        System.out.println("Enter the number of student IDs:");
        numberOfStudents = input.nextInt();
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            for (int i = 1; i <= numberOfStudents; i++) {

                System.out.println("Enter Student ID " + i + ":");
                studentId = input.nextInt();
                if (!studentIds.add(studentId)) {
                    System.out.println("Duplicate ID detected. ID was not added.");
                }
            }
            if (studentIds.size() < 5) {
                registrationClassification = "Small Registration";
            } else if (studentIds.size() >= 5 && studentIds.size() <= 10) {
                registrationClassification = "Medium Registration";
            } else {
                registrationClassification = "Large Registration";
            }
            System.out.println("\n Registration Report ");
            System.out.println("Total IDs Entered: " + numberOfStudents);
            System.out.println("Total Unique Student IDs: " + studentIds.size());
            System.out.println("All Unique Student IDs: " + studentIds);
            System.out.println("Registration Classification: " + registrationClassification);
        }
        input.close();
    }
}
