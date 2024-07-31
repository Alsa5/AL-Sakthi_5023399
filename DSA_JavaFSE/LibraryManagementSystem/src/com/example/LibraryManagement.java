package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryManagement {
    private List<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        // Sorting the list after adding a book for binary search
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    // Linear Search by Title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search by Title
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int compareResult = midBook.getTitle().compareToIgnoreCase(title);

            if (compareResult == 0) {
                return midBook;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Traverse Books
    public void traverseBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
