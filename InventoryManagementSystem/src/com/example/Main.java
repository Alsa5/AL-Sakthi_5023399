package com.example;

import java.util.Scanner;

public class Main {
    private static InventoryManagement inventory = new InventoryManagement();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    inventory.displayInventory();
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
        System.out.println("\nInventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display Inventory");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price of One product: ");
        double priceOfone = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        
        double price = priceOfone* quantity;

        Product product = new Product(productId, productName, quantity, price, priceOfone);
        inventory.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        String productId = scanner.nextLine();

        if (inventory.getProduct(productId) == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter new price: ");
        double priceOfone = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        
        double price = priceOfone* quantity;
        
        Product updatedProduct = new Product(productId, productName, quantity, price, priceOfone);
        inventory.updateProduct(productId, updatedProduct);
        System.out.println("Product updated successfully.");
    }

    private static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        String productId = scanner.nextLine();

        if (inventory.getProduct(productId) == null) {
            System.out.println("Product not found.");
            return;
        }

        inventory.deleteProduct(productId);
        System.out.println("Product deleted successfully.");
    }
}
