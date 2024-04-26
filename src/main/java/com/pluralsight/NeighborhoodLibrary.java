package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[5];

        books[0] = new Book(666, "9783833936326", "Diary of a Wimpy Kid");
        books[1] = new Book(777, "9780385335485", "Confessions of a Shopaholic");
        books[2] = new Book(999,"978-0062094360", "The Exorcist");
        books[3] = new Book(420, "10: 0688171583", "Tha Doggfather: The Times, Trials, And Hardcore Truths Of Snoop Dogg");
        books[4] = new Book(888, "1846460441", "Bratz: Pop Princesses");


        System.out.println(" ");
        System.out.println("───  ･ ｡ﾟ☆: *.☽ .* :☆ﾟ.  ───");
        System.out.println("Hello Traveler!\n" + "You've stumbled upon a library on your journey!\n");
        System.out.println( "Welcome to ");
        System.out.println("˚₊‧✩ੈ* Brya's Strange and Mysterious Library *ੈ✩‧₊˚");



        boolean running = true;
        while (running) {

            System.out.println("\nSelect an option: ");
            System.out.println("1. Show available books");
            System.out.println("2. Show checked out books");
            System.out.println("3. Exit\n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: showCheckedInBooks(books, scanner);
                break;

                case 2: showCheckedOutBooks(books, scanner);
                break;

                case 3:
                    running = false;
                    System.out.println("Goodbye! Safe travels!");
                    return;
                default:

                    System.out.println("Invalid option. Try again.");
            }


        }

    }

    public static void showCheckedInBooks(Book[] books, Scanner scanner) {
        System.out.println("Checked In Books:\n");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getId() + ": " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
            }
        }

        System.out.println(" ");
        System.out.println("If you would like to check out a book enter the ID of the book (or enter 0 to return to the home screen):");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        if (bookId == 0) {
            return;
        }

        checkOutBook(books,bookId, scanner);

            }
    public static void checkOutBook(Book[] books, int bookId, Scanner scanner) {
        for (Book book : books) {
            if (book.getId() == bookId && !book.isCheckedOut()) {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                book.checkOut(name);
                return;
            }
        }

        System.out.println("Invalid book ID or book is already checked out.");

    }

    public static void showCheckedOutBooks(Book[] books, Scanner scanner) {
        System.out.println("Checked Out Books:\n");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked Out By: " + book.getIsCheckedOutTo());
            }
        }
        System.out.println("\nEnter 'C' to check in a book or 'X' to return to the home screen");

        String choice = scanner.nextLine().toUpperCase();

        switch (choice){
            case "C":
                checkInBook(books, scanner);
                break;

            case "X":
                return;
            default:
                System.out.println("Invalid option. Try again.");
        }

    }

    public static void checkInBook(Book[] books, Scanner scanner){
        System.out.println("Enter the ID of the book you would like to return:");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == bookId && book.isCheckedOut()) {
                book.checkIn();
                return;
            }
        }
        System.out.println("Invalid ID or book is already checked in.");
    }
}



