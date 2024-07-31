package com.example;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Tablet", "Electronics"),
            new Product("4", "Headphones", "Accessories"),
            new Product("5", "Charger", "Accessories")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID to search: ");
        String productId = scanner.nextLine();
        // Linear search example
        Product foundProduct = Search.linearSearch(products,productId);
        if (foundProduct != null) {
            System.out.println("Linear Search: Product found - " + foundProduct);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Binary search example
        foundProduct = Search.binarySearch(products, productId);
        if (foundProduct != null) {
            System.out.println("Binary Search: Product found - " + foundProduct);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
        scanner.close();
    }
}
