package Java_6;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeSalaryManager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Double> employeeSalaries = new HashMap<>();
        int numberOfEmployees;
        int employeeId;
        int searchId;
        int updateId;
        int removeId;
        double salary;
        double newSalary;
        double highestSalary;
        double lowestSalary;
        double totalPayroll;
        double averageSalary;
        int menuChoice;
        System.out.println("Enter the number of employees:");
        numberOfEmployees = input.nextInt();
        if (numberOfEmployees <= 0) {
            System.out.println("Invalid number of employees.");
        } else {
            for (int i = 1; i <= numberOfEmployees; i++) {
                System.out.println("\nEnter Employee ID " + i + ":");
                employeeId = input.nextInt();
                if (employeeSalaries.containsKey(employeeId)) {
                    System.out.println(
                            "Employee ID already exists. Record not added."
                    );
                } else {
                    System.out.println("Enter Employee Salary:");
                    salary = input.nextDouble();
                    employeeSalaries.put(employeeId, salary);
                    System.out.println("Employee added successfully.");
                }
            }
            do {
                System.out.println("\n===== Employee Salary Management =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Search Employee");
                System.out.println("3. Update Salary");
                System.out.println("4. Remove Employee");
                System.out.println("5. Display All Employees");
                System.out.println("6. Display Salary Statistics");
                System.out.println("7. Exit");
                System.out.println("Enter your choice:");
                menuChoice = input.nextInt();
                switch (menuChoice) {
                    case 1:
                        System.out.println("Enter Employee ID:");
                        employeeId = input.nextInt();
                        if (employeeSalaries.containsKey(employeeId)) {
                            System.out.println(
                                    "Employee ID already exists. Record not added."
                            );
                        } else {
                            System.out.println("Enter Employee Salary:");
                            salary = input.nextDouble();
                            employeeSalaries.put(employeeId, salary);
                            System.out.println(
                                    "Employee added successfully."
                            );
                        }
                        break;
                    case 2:
                        System.out.println("Enter Employee ID to search:");
                        searchId = input.nextInt();
                        if (employeeSalaries.containsKey(searchId)) {
                            System.out.println(
                                    "Employee ID: " + searchId
                            );
                            System.out.println(
                                    "Salary: "
                                            + employeeSalaries.get(searchId)
                            );

                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Employee ID to update:");
                        updateId = input.nextInt();
                        if (employeeSalaries.containsKey(updateId)) {
                            System.out.println("Enter the new salary:");
                            newSalary = input.nextDouble();
                            employeeSalaries.replace(
                                    updateId,
                                    newSalary
                            );
                            System.out.println(
                                    "Salary updated successfully."
                            );
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Employee ID to remove:");
                        removeId = input.nextInt();
                        if (employeeSalaries.containsKey(removeId)) {
                            employeeSalaries.remove(removeId);
                            System.out.println(
                                    "Employee removed successfully."
                            );
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 5:
                        System.out.println("\n All Employees ");
                        if (employeeSalaries.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            for (Integer id : employeeSalaries.keySet()) {
                                System.out.println(
                                        "Employee ID: " + id
                                                + " | Salary: "
                                                + employeeSalaries.get(id)
                                );
                            }
                        }
                        break;

                    case 6:
                        System.out.println(
                                "\n Salary Statistics "
                        );
                        if (employeeSalaries.isEmpty()) {
                            System.out.println(
                                    "No employee records available."
                            );
                        } else {
                            highestSalary = Double.MIN_VALUE;
                            lowestSalary = Double.MAX_VALUE;
                            totalPayroll = 0;
                            for (Double currentSalary
                                    : employeeSalaries.values()) {
                                totalPayroll += currentSalary;
                                if (currentSalary > highestSalary) {
                                    highestSalary = currentSalary;
                                }
                                if (currentSalary < lowestSalary) {
                                    lowestSalary = currentSalary;
                                }
                            }
                            averageSalary =
                                    totalPayroll
                                            / employeeSalaries.size();
                            System.out.println(
                                    "Highest Salary: " + highestSalary
                            );
                            System.out.println(
                                    "Lowest Salary: " + lowestSalary
                            );
                            System.out.println(
                                    "Average Salary: " + averageSalary
                            );
                            System.out.println(
                                    "Total Payroll: " + totalPayroll
                            );
                        }
                        break;

                    case 7:
                        System.out.println(
                                "Exiting Employee Salary Management System..."
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