package Java_6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class UniversityCourseRegistrationSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();
        HashMap<Integer, HashSet<String>> studentCourses = new HashMap<>();
        int numberOfStudents;
        int studentId;
        int numberOfCourses;
        int menuChoice;
        int courseCount;
        int totalRegistrations;
        int highestCourses;
        int lowestCourses;
        int highestStudentId;
        int lowestStudentId;
        double averageCourses;
        String courseName;
        String searchCourse;
        HashSet<String> courses;
        System.out.println("Enter the number of students:");
        numberOfStudents = input.nextInt();
        input.nextLine();
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.println("\nEnter Student ID " + i + ":");
                studentId = input.nextInt();
                input.nextLine();
                if (studentIds.contains(studentId)) {
                    System.out.println("Student ID already exists. Record skipped.");
                } else {
                    studentIds.add(studentId);
                    System.out.println("Enter the number of courses:");
                    numberOfCourses = input.nextInt();
                    input.nextLine();
                    courses = new HashSet<>();
                    if (numberOfCourses > 6) {
                        System.out.println("A student cannot register for more than 6 courses.");
                        numberOfCourses = 6;
                    }
                    for (int j = 1; j <= numberOfCourses; j++) {
                        System.out.println("Enter Course " + j + ":");
                        courseName = input.nextLine();
                        if (!courses.add(courseName)) {
                            System.out.println(
                                    "Course already registered. Duplicate course was not added."
                            );
                        }
                    }
                    studentCourses.put(studentId, courses);
                }
            }
            do {
                System.out.println("\n===== University Course Registration =====");
                System.out.println("1. Search Student");
                System.out.println("2. Add Course to Student");
                System.out.println("3. Remove Course from Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Display Registration Statistics");
                System.out.println("6. Register New Student");
                System.out.println("7. Search Students by Course");
                System.out.println("8. Exit");
                System.out.println("Enter your choice:");
                menuChoice = input.nextInt();
                input.nextLine();
                switch (menuChoice) {
                    case 1:
                        System.out.println("Enter Student ID:");
                        studentId = input.nextInt();
                        input.nextLine();
                        if (studentCourses.containsKey(studentId)) {
                            System.out.println("Student ID: " + studentId);
                            System.out.println("Registered Courses:");
                            courses = studentCourses.get(studentId);
                            for (String course : courses) {
                                System.out.println("- " + course);
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Student ID:");
                        studentId = input.nextInt();
                        input.nextLine();
                        if (studentCourses.containsKey(studentId)) {
                            courses = studentCourses.get(studentId);
                            if (courses.size() >= 6) {
                                System.out.println(
                                        "Student cannot register for more than 6 courses."
                                );
                            } else {
                                System.out.println("Enter Course Name:");
                                courseName = input.nextLine();
                                if (courses.contains(courseName)) {
                                    System.out.println(
                                            "Course already registered. Duplicate course was not added."
                                    );

                                } else {
                                    courses.add(courseName);
                                    studentCourses.replace(studentId, courses);
                                    System.out.println(
                                            "Course added successfully."
                                    );
                                }
                            }

                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Student ID:");
                        studentId = input.nextInt();
                        input.nextLine();
                        if (studentCourses.containsKey(studentId)) {
                            courses = studentCourses.get(studentId);
                            System.out.println("Enter Course Name to remove:");
                            courseName = input.nextLine();
                            if (courses.remove(courseName)) {
                                studentCourses.replace(studentId, courses);
                                System.out.println(
                                        "Course removed successfully."
                                );
                            } else {
                                System.out.println("Course not found.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        System.out.println("\n All Students ");
                        TreeSet<Integer> sortedStudentIds =
                                new TreeSet<>(studentCourses.keySet());
                        if (sortedStudentIds.isEmpty()) {
                            System.out.println("No students registered.");
                        } else {
                            for (Integer id : sortedStudentIds) {
                                System.out.println("Student ID: " + id);
                                courses = studentCourses.get(id);
                                if (courses.isEmpty()) {
                                    System.out.println("Courses: None");
                                } else {
                                    System.out.println("Courses:");
                                    for (String course : courses) {
                                        System.out.println("- " + course);
                                    }
                                }
                                System.out.println();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("\n Registration Statistics ");
                        if (studentCourses.isEmpty()) {
                            System.out.println("No student registrations available.");
                        } else {
                            totalRegistrations = 0;
                            for (HashSet<String> studentCourseSet
                                    : studentCourses.values()) {
                                totalRegistrations += studentCourseSet.size();
                            }
                            highestCourses = -1;
                            lowestCourses = Integer.MAX_VALUE;
                            highestStudentId = 0;
                            lowestStudentId = 0;
                            for (Integer id : studentCourses.keySet()) {
                                courseCount = studentCourses.get(id).size();
                                if (courseCount > highestCourses) {
                                    highestCourses = courseCount;
                                    highestStudentId = id;
                                }
                                if (courseCount < lowestCourses) {
                                    lowestCourses = courseCount;
                                    lowestStudentId = id;
                                }
                            }
                            averageCourses =
                                    (double) totalRegistrations
                                            / studentCourses.size();
                            System.out.println(
                                    "Total Number of Students: "
                                            + studentCourses.size()
                            );
                            System.out.println(
                                    "Total Course Registrations: "
                                            + totalRegistrations
                            );
                            System.out.println(
                                    "Student with Highest Courses: "
                                            + highestStudentId
                                            + " (" + highestCourses
                                            + " courses)"
                            );
                            System.out.println(
                                    "Student with Lowest Courses: "
                                            + lowestStudentId
                                            + " (" + lowestCourses
                                            + " courses)"
                            );
                            System.out.println(
                                    "Average Courses per Student: "
                                            + averageCourses
                            );
                        }
                        break;
                    case 6:
                        System.out.println("Enter New Student ID:");
                        studentId = input.nextInt();
                        input.nextLine();
                        if (studentIds.contains(studentId)) {
                            System.out.println(
                                    "Student ID already exists. Student not added."
                            );
                        } else {
                            studentIds.add(studentId);
                            courses = new HashSet<>();
                            studentCourses.put(studentId, courses);
                            System.out.println(
                                    "New student registered successfully."
                            );
                        }
                        break;
                    case 7:
                        System.out.println("Enter Course Name:");
                        searchCourse = input.nextLine();
                        boolean courseFound = false;
                        System.out.println(
                                "\nStudents registered in " + searchCourse + ":"
                        );
                        for (Integer id : studentCourses.keySet()) {
                            courses = studentCourses.get(id);
                            if (courses.contains(searchCourse)) {
                                System.out.println("Student ID: " + id);
                                courseFound = true;
                            }
                        }
                        if (!courseFound) {
                            System.out.println(
                                    "No students are registered in this course."
                            );
                        }
                        break;

                    case 8:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } while (menuChoice != 8);
            System.out.println("\n Final Registration Summary ");
            if (studentCourses.isEmpty()) {
                System.out.println("No registrations available.");
            } else {
                System.out.println(
                        "Total Students: " + studentCourses.size()
                );
                totalRegistrations = 0;
                TreeSet<Integer> sortedStudentIds =
                        new TreeSet<>(studentCourses.keySet());
                for (Integer id : sortedStudentIds) {
                    courses = studentCourses.get(id);
                    totalRegistrations += courses.size();
                    System.out.println("\nStudent ID: " + id);
                    if (courses.isEmpty()) {
                        System.out.println("Courses: None");
                    } else {
                        for (String course : courses) {
                            System.out.println("- " + course);
                        }
                    }
                }
                System.out.println(
                        "\nTotal Course Registrations: "
                                + totalRegistrations
                );
            }
        }
        input.close();
    }
}