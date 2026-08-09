package Java_6;
import java.util.HashMap;
import java.util.Scanner;

public class StudentAttendanceManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Integer> attendanceRecords = new HashMap<>();
        int numberOfStudents;
        int studentId;
        int attendanceDays;
        int searchId;
        int updateId;
        int newAttendanceDays;
        int removeId;
        int menuChoice;
        int totalAttendanceDays;
        int highestAttendance;
        int lowestAttendance;
        int highestStudentId;
        int lowestStudentId;
        double averageAttendance;
        System.out.println("Enter the number of student records:");
        numberOfStudents = input.nextInt();
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.println("\nEnter Student ID " + i + ":");
                studentId = input.nextInt();
                if (attendanceRecords.containsKey(studentId)) {
                    System.out.println(
                            "Student ID already exists. Record not added."
                    );
                } else {
                    System.out.println(
                            "Enter number of attended days:"
                    );
                    attendanceDays = input.nextInt();
                    attendanceRecords.put(
                            studentId,
                            attendanceDays
                    );
                    System.out.println(
                            "Student attendance record added successfully."
                    );
                }
            }
            do {
                System.out.println(
                        "\n Student Attendance Management "
                );
                System.out.println("1. Add Student Record");
                System.out.println("2. Search Student Attendance");
                System.out.println("3. Update Attendance");
                System.out.println("4. Remove Student Record");
                System.out.println("5. Display All Attendance Records");
                System.out.println("6. Display Attendance Statistics");
                System.out.println("7. Exit");
                System.out.println("Enter your choice:");
                menuChoice = input.nextInt();
                switch (menuChoice) {
                    case 1:
                        System.out.println("Enter Student ID:");
                        studentId = input.nextInt();
                        if (attendanceRecords.containsKey(studentId)) {
                            System.out.println(
                                    "Student ID already exists. Record not added."
                            );
                        } else {
                            System.out.println(
                                    "Enter number of attended days:"
                            );
                            attendanceDays = input.nextInt();
                            attendanceRecords.put(
                                    studentId,
                                    attendanceDays
                            );
                            System.out.println(
                                    "Student record added successfully."
                            );
                        }
                        break;
                    case 2:
                        System.out.println(
                                "Enter Student ID to search:"
                        );
                        searchId = input.nextInt();
                        if (attendanceRecords.containsKey(searchId)) {
                            System.out.println(
                                    "Student ID: " + searchId
                            );
                            System.out.println(
                                    "Attendance Days: "
                                            + attendanceRecords.get(searchId)
                            );
                        } else {
                            System.out.println(
                                    "Student ID not found."
                            );
                        }
                        break;
                    case 3:
                        System.out.println(
                                "Enter Student ID to update:"
                        );
                        updateId = input.nextInt();
                        if (attendanceRecords.containsKey(updateId)) {
                            System.out.println(
                                    "Enter new number of attended days:"
                            );
                            newAttendanceDays = input.nextInt();
                            attendanceRecords.replace(
                                    updateId,
                                    newAttendanceDays
                            );
                            System.out.println(
                                    "Attendance updated successfully."
                            );
                        } else {
                            System.out.println(
                                    "Student ID not found."
                            );
                        }
                        break;
                    case 4:
                        System.out.println(
                                "Enter Student ID to remove:"
                        );
                        removeId = input.nextInt();
                        if (attendanceRecords.containsKey(removeId)) {
                            attendanceRecords.remove(removeId);
                            System.out.println(
                                    "Student record removed successfully."
                            );
                        } else {
                            System.out.println(
                                    "Student ID not found."
                            );
                        }
                        break;
                    case 5:
                        System.out.println(
                                "\nAll Attendance Records "
                        );
                        if (attendanceRecords.isEmpty()) {
                            System.out.println(
                                    "No attendance records found."
                            );
                        } else {
                            for (HashMap.Entry<Integer, Integer> entry
                                    : attendanceRecords.entrySet()) {
                                System.out.println(
                                        "Student ID: "
                                                + entry.getKey()
                                                + " | Attendance Days: "
                                                + entry.getValue()
                                );
                            }
                        }
                        break;
                    case 6:
                        System.out.println(
                                "\n Attendance Statistics "
                        );
                        if (attendanceRecords.isEmpty()) {
                            System.out.println(
                                    "No attendance records available."
                            );
                        } else {
                            totalAttendanceDays = 0;
                            highestAttendance = Integer.MIN_VALUE;
                            lowestAttendance = Integer.MAX_VALUE;
                            highestStudentId = 0;
                            lowestStudentId = 0;
                            for (Integer days : attendanceRecords.values()) {
                                totalAttendanceDays += days;
                            }
                            for (Integer id : attendanceRecords.keySet()) {
                                attendanceDays =
                                        attendanceRecords.get(id);
                                if (attendanceDays > highestAttendance) {
                                    highestAttendance = attendanceDays;
                                    highestStudentId = id;
                                }
                                if (attendanceDays < lowestAttendance) {
                                    lowestAttendance = attendanceDays;
                                    lowestStudentId = id;
                                }
                            }
                            averageAttendance =
                                    (double) totalAttendanceDays
                                            / attendanceRecords.size();
                            System.out.println(
                                    "Total Number of Students: "
                                            + attendanceRecords.size()
                            );
                            System.out.println(
                                    "Total Attendance Days: "
                                            + totalAttendanceDays
                            );
                            System.out.println(
                                    "Average Attendance: "
                                            + averageAttendance
                            );
                            System.out.println(
                                    "Student with Highest Attendance: "
                                            + highestStudentId
                                            + " ("
                                            + highestAttendance
                                            + " days)"
                            );
                            System.out.println(
                                    "Student with Lowest Attendance: "
                                            + lowestStudentId
                                            + " ("
                                            + lowestAttendance
                                            + " days)"
                            );
                        }
                        break;
                    case 7:
                        System.out.println(
                                "Exiting Student Attendance Management System..."
                        );
                        break;
                    default:
                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }
            } while (menuChoice != 7);
        }
        input.close();
    }
}
