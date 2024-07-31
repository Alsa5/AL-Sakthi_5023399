package com.example;

import java.util.Scanner;

public class Main {
    private static LibraryManagement library = new LibraryManagement();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBookLinear();
                    break;
                case 3:
                    searchBookBinary();
                    break;
                case 4:
                    traverseBooks();
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
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book (Linear Search)");
        System.out.println("3. Search Book (Binary Search)");
        System.out.println("4. Display All Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook() {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(bookId, title, author);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void searchBookLinear() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        Book book = library.linearSearchByTitle(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println(book);
        }
    }

    private static void searchBookBinary() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        Book book = library.binarySearchByTitle(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println(book);
        }
    }

    private static void traverseBooks() {
        System.out.println("Book List:");
        library.traverseBooks();
    }
}
