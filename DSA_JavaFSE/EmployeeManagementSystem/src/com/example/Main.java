package com.example;

import java.util.Scanner;

public class Main {
    private static EmployeeManagement management = new EmployeeManagement(10);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add Employee");
        System.out.println("2. Search Employee");
        System.out.println("3. Traverse Employees");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter position: ");
        String position = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Employee employee = new Employee(employeeId, name, position, salary);
        management.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        String employeeId = scanner.nextLine();

        Employee employee = management.searchEmployee(employeeId);
        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println(employee);
        }
    }

    private static void traverseEmployees() {
        System.out.println("Employee List:");
        management.traverseEmployees();
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        String employeeId = scanner.nextLine();

        management.deleteEmployee(employeeId);
        System.out.println("Employee deleted successfully.");
    }
}
