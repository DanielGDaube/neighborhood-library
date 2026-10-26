package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTO) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTO;
    }

    // Getter methods
    public int getId() {return id;}
    public String getIsbn() {return isbn;}
    public String getTitle() {return title;}
    public boolean getCheckedOut() {return isCheckedOut;}
    public String getCheckedOutTo() {return checkedOutTo;}

    // Setter methods
    public Book setId(int id) {
        this.id = id;
        return this;
    }
    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
    public Book setTitle(String title){
        this.title = title;
        return this;
    }
    public Book setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
        return this;
    }
    public Book setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
        return this;
    }

    // Checks in a book
    public void checkIn(){
        isCheckedOut = false;
        checkedOutTo = "";

    }
    // Checks out a book
    public void checkOut(String name){
        isCheckedOut = true;
        checkedOutTo = "name";

    }
    @Override
    public String toString(){
        return id + "  " + isbn + "  " + title;

    }
}
