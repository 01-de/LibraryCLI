package org.example.components;

import java.util.Objects;

public class Book extends Publication implements Printable {
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public String toString() {
        return super.toString() + ", ISBN='" + ISBN + "'}";
    }

    @Override
    public void printDetails() {
        System.out.println("Type: Book");
        System.out.println("Name: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year: " + getYear());
        System.out.println("ISBN: " + ISBN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book other = (Book) o;
        return (ISBN != null ? ISBN.equals(other.ISBN) : other.ISBN == null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0);
        return result;
    }
}
