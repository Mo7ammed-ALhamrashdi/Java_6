package Java_6;
import java.util.HashMap;
import java.util.Scanner;
public class EmployeeDirectoryMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, String> employees = new HashMap<>();
        int numberOfEmployees;
        int employeeId;
        int searchId;
        String employeeName;
        String companyClassification;
        System.out.println("Enter the number of employees:");
        numberOfEmployees = input.nextInt();
        input.nextLine();
        if (numberOfEmployees <= 0) {

            System.out.println("Invalid number of employees.");
        } else {
            for (int i = 1; i <= numberOfEmployees; i++) {

                System.out.println("Enter Employee ID " + i + ":");
                employeeId = input.nextInt();
                input.nextLine();
                if (employees.containsKey(employeeId)) {
                    System.out.println("Employee ID already exists. Please enter a unique ID.");
                } else {
                    System.out.println("Enter Employee Name:");
                    employeeName = input.nextLine();
                    employees.put(employeeId, employeeName);
                }
            }
            System.out.println("Enter an Employee ID to search:");
            searchId = input.nextInt();
            if (employees.containsKey(searchId)) {
                System.out.println("Employee Found: " + employees.get(searchId));
            } else {
                System.out.println("Employee ID not found.");
            }
            if (employees.size() < 5) {
                companyClassification = "Small Company";
            } else if (employees.size() >= 5 && employees.size() <= 10) {
                companyClassification = "Medium Company";
            } else {
                companyClassification = "Large Company";
            }
            System.out.println("\n===== Employee Directory Report =====");
            System.out.println("Total Employee Records Entered: " + numberOfEmployees);
            System.out.println("Total Unique Employees: " + employees.size());
            System.out.println("Employee IDs and Names:");
            for (Integer id : employees.keySet()) {
                System.out.println("ID: " + id + "  Name: " + employees.get(id));
            }
            System.out.println("Company Classification: " + companyClassification);
        }
        input.close();
    }
}
