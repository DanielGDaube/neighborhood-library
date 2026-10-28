package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    static Scanner libraryScanner = new Scanner(System.in);
    // Creates an array with 20 slots
    private static Book[] library = new Book[20];

    public static void main(String[] args) throws InterruptedException{

            initializeLibrary();


            // Loop that displays home menu screen
            boolean condition = true;
            while (condition) {

                    System.out.println("--------------------------");
                    System.out.printf("What would you like to do?%n%n");
                    System.out.println("1 - Show available books");
                    System.out.println("2 - Show checked out books");
                    System.out.println("3 - Exit");
                    System.out.println("--------------------------");


                  /*  First try and catch prevents crash on input mismatch
                        Other two try and catch prevent looping back to main menu from sub menus*/
                    try {
            /* Inputting 1 brings user to available books menu
             Inputting 2 brings user to checked out books menu
             Inputting 3 quits the program
             Any other input prints an error message*/
                        switch (libraryScanner.nextInt()) {
                            case 1 -> showAvailableBooks();
                            case 2 -> showCheckedOutBooks();
                            case 3 -> condition = false;
                            default -> menuError();
                        }
                    }
                    catch (Exception InputMismatchException){
                        menuError();
                        libraryScanner.nextLine();
                    }

            }
            libraryScanner.close();
        }


    // Preloads the array with entered books
    public static void initializeLibrary() {
        library[0] = new Book(1, "978-1-68-281852-7", "Threshing Day", false, "");
        library[1] = new Book(2, "978-1-66-250763-2", "The Witch of Tin Mountain", false, "");
        library[2] = new Book(3, "978-0-59-383017-8", "The French Illusion", false, "");
        library[3] = new Book(4, "978-1-66-823651-2", "Theo of Golden", false, "");
        library[4] = new Book(5, "978-3-56-563264-0", "The Calamity Club", false, "");
        library[5] = new Book(6, "978-9-04-921490-6", "Peck & Peck", false, "");
        library[6] = new Book(7, "978-0-59-382025-4", "Dungeon Crawler Carl", false, "");
        library[7] = new Book(8, "978-1-53-878405-1", "Verity", false, "");
        library[8] = new Book(9, "978-0-59-372625-9", "Hollow Bones", false, "");
        library[9] = new Book(10, "978-0-59-382026-1", "Carl's Doomsday Scenario", false, "");
        library[10] = new Book(11, "978-1-25-028454-9", "Mad Mabel", false, "");
        library[11] = new Book(12, "978-1-59-780433-2", "Other Worlds Than These", false, "");
        library[12] = new Book(13, "978-0-06-351163-7", "Whistler", false, "");
        library[13] = new Book(14, "978-0-59-380421-6", "Yesteryear", false, "");
        library[14] = new Book(15, "978-1-46-429854-7", "Brain Damage", false, "");
        library[15] = new Book(16, "978-0-59-313522-8", "Project Hail Mary", false, "");
        library[16] = new Book(17, "978-1-63-557556-9", "A Court of Thorns and Roses", false, "");
        library[17] = new Book(18, "979-8-21-719235-9", "Bound and Unbound", false, "");
        library[18] = new Book(19, "978-0-34-553980-9", "Red Rising", false, "");
        library[19] = new Book(20, "978-1-64-937929-0", "Fourth Wing", false, "");
    }

    /*Displays  alist of available books and takes the user to the available books menu
     If no books are available it prints an error message and returns to the previous screen*/
    public static void showAvailableBooks() throws InterruptedException {
        int available = 0;
        boolean header = true;
        for (Book book : library) {
            if (!book.getCheckedOut()) {
                if (header) {
                    System.out.println("ID ISBN              Title");
                    header = false;
                }
                System.out.println(book);
                available++;
            }
        }
        if (available == 0) {
            System.out.println("Sorry, no there are no books available right now");
            Thread.sleep(1070);
        } else {
            availableBooksMenu();
        }
    }

    // Displays a list of checked out books
    public static void showCheckedOutBooks() throws InterruptedException {
        int out = 0;
        boolean header = true;
        for (Book book : library) {
            if (book.getCheckedOut()) {
                if (header) {
                    System.out.println("ID ISBN              Title");
                    header = false;
                }
                System.out.println(book + " |" + " This book is checked out to " + book.getCheckedOutTo());
                out++;
            }

        }
        if (out == 0) {
            System.out.println("No books are checked out");
            Thread.sleep(1050);
        } else {
            libraryScanner.nextLine();
            checkedOutBooksMenu();
        }

    }
    /* Gives the user the option to either check out a book or return to the previous menu
    An input of 1 will ask for a book ID and a name and then runs the book.checkOut() method
    an input of 2 will return to the previous screen
    any other input prints an error message*/
    public static void availableBooksMenu() throws InterruptedException {
        boolean condition = true;

        // loop displays menu options
        while (condition) {
            System.out.println("--------------------------");
            System.out.printf("Do you want to check out a book?%n%n");
            System.out.println("1. Check out a book");
            System.out.println("2. Go back");
            System.out.println("--------------------------");

            try {
                switch (libraryScanner.nextInt()) {
                    case 1 -> {
                        System.out.println("Please enter the books ID:");
                        int inputId = libraryScanner.nextInt();
                        // Invalid ID returns an error
                        if (inputId > library.length || inputId < 1 || library[inputId - 1].getCheckedOut()) {
                            System.out.println("Invalid ID");
                            Thread.sleep(1000);
                        } else {
                            libraryScanner.nextLine();
                            System.out.println("Please enter your name:");
                            String inputName = libraryScanner.nextLine();
                            library[inputId - 1].checkOut(inputName);
                            System.out.println("Thank you for checking out from the library!");
                            Thread.sleep(1080);
                        }
                    }
                    case 2 -> condition = false;
                    default -> menuError();
                }
            }
            catch (Exception InputMismatchException){
                menuError();
                libraryScanner.nextLine();
            }
        }

    }
    /* Gives the user the option to either check in a book or return to the previous menu
    An input of c will ask for a book ID then runs the book.checkIn() method
    an input of x will return to the previous screen
    any other input prints an error message*/
    public static void checkedOutBooksMenu() throws InterruptedException {
        boolean condition = true;

        // loop displays menu options
        while (condition) {

            System.out.println("--------------------------");
            System.out.printf("Would you like to check in a book?%n%n");
            System.out.println("C - Check in a book");
            System.out.println("X - Go back");
            System.out.println("--------------------------");


            try {
                switch (libraryScanner.next().toLowerCase()) {
                    case "c" -> {
                        System.out.println("Please enter the books ID:");
                        int inputId = libraryScanner.nextInt();
                        // Invalid ID returns an error
                        if (inputId > library.length || inputId < 1 || !library[inputId - 1].getCheckedOut()) {
                            System.out.println("Invalid ID");
                            Thread.sleep(1000);
                            if (libraryScanner.hasNextLine()) {
                                libraryScanner.nextLine();
                            }
                        } else {
                            library[inputId - 1].checkIn();
                            System.out.println("Thank you for returning this book");
                            Thread.sleep(1080);
                            condition = false;
                        }
                    }
                    case "x" -> condition = false;
                    default -> menuError();
                }
            }
            catch (Exception InputMismatchException){
                menuError();
                libraryScanner.nextLine();
            }
        }
    }
    // Method to display a common error message for invalid inputs on menus
    public static void menuError() throws InterruptedException {
        System.err.println("Error, not a valid option. Please try again.");
        Thread.sleep(1085);
    }
}

