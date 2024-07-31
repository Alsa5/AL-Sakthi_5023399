package com.example;

import java.util.Scanner;

public class Main {
    private static TaskManagement management = new TaskManagement();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    searchTask();
                    break;
                case 3:
                    traverseTasks();
                    break;
                case 4:
                    deleteTask();
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
        System.out.println("\nTask Management System");
        System.out.println("1. Add Task");
        System.out.println("2. Search Task");
        System.out.println("3. Traverse Tasks");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine();

        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        Task task = new Task(taskId, taskName, status);
        management.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void searchTask() {
        System.out.print("Enter task ID to search: ");
        String taskId = scanner.nextLine();

        Task task = management.searchTask(taskId);
        if (task == null) {
            System.out.println("Task not found.");
        } else {
            System.out.println(task);
        }
    }

    private static void traverseTasks() {
        System.out.println("Task List:");
        management.traverseTasks();
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        String taskId = scanner.nextLine();

        management.deleteTask(taskId);
        System.out.println("Task deleted successfully.");
    }
}
