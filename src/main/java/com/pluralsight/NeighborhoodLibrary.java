package com.pluralsight;

public class NeighborhoodLibrary {
    // Creates an array with 20 slots
    private static Book [] library = new Book[20];
    public static void main(String[] args) {

        initializeLibrary();

        System.out.printf("What would you like to do?%n%n");
        System.out.println("1 - Show available books");
        System.out.println("2 - Show checked out books");
        System.out.println("3 - Exit");


    }

    // Preloads the array with entered books
    public static void initializeLibrary(){
        library[0] = new Book(1,"978-1-68-281852-7", "Threshing Day", false, "");
        library[1] = new Book(2,"978-1-66-250763-2", "The Witch of Tin Mountain", false, "");
        library[2] = new Book(3,"978-0-59-383017-8", "The French Illusion", false, "");
        library[3] = new Book(4,"978-1-66-823651-2", "Theo of Golden", false, "");
        library[4] = new Book(5,"978-3-56-563264-0", "The Calamity Club", false, "");
        library[5] = new Book(6,"978-9-04-921490-6", "Peck & Peck",false, "");
        library[6] = new Book(7,"978-0-59-382025-4", "Dungeon Crawler Carl",false, "");
        library[7] = new Book(8,"978-1-53-878405-1", "Verity",false, "");
        library[8] = new Book(9,"978-0-59-372625-9", "Hollow Bones",false, "");
        library[9] = new Book(10,"978-0-59-382026-1","Carl's Doomsday Scenario", false, "");
        library[10] = new Book(11,"978-1-25-028454-9", "Mad Mabel",false, "");
        library[11] = new Book(12,"9781597804332", "Other Worlds Than These", false, "");
        library[12] = new Book(13,"978-0-06-351163-7", "Whistler",false, "");
        library[13] = new Book(14,"978-0-59-380421-6", "Yesteryear",false, "");
        library[14] = new Book(15,"978-1-46-429854-7","Brain Damage", false, "");
        library[15] = new Book(16,"978-0-59-313522-8","Project Hail Mary", false, "");
        library[16] = new Book(17,"978-1-63-557556-9","A Court of Thorns and Roses", false, "");
        library[17] = new Book(18,"979-8-21-719235-9","Bound and Unbound", false, "");
        library[18] = new Book(19,"978-0-34-553980-9","Red Rising", false, "");
        library[19] = new Book(20,"978-1-64-937929-0","Fourth Wing", false, "");
    }
}
