package org.example;
import java.util.ArrayList;
import java.util.List;


abstract class Publication {
    private String title;
    private String author;
    private int year;
    private static int publicationCount = 0;

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        publicationCount++;
    }

    public abstract String getType();

    public static int getPublicationCount() {
        return publicationCount;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return getType() + "{title='" + title + "', author='" + author + "', year=" + year + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Publication other = (Publication) obj;
        return year == other.year &&
                title != null ? title.equals(other.title) : other.title == null &&
                author != null ? author.equals(other.author) : other.author == null;
    }

    @Override
    public int hashCode() {
        int result = (title != null ? title.hashCode() : 0) + (author != null ? author.hashCode() : 0);
        result = 31 * result * year;
        return result;
    }
}


interface Printable {
    void printDetails();
}


class Book extends Publication implements Printable {
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

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
}


class Magazine extends Publication implements Printable {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public String getType() {
        return "Journal";
    }

    @Override
    public String toString() {
        return super.toString() + ", issueNumber=" + issueNumber + "}";
    }

    @Override
    public void printDetails() {
        System.out.println("Type: Journal");
        System.out.println("Name: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year: " + getYear());
        System.out.println("Issue Number: " + issueNumber);
    }
}

// Newspaper.java
class Newspaper extends Publication implements Printable {
    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    public String getPublicationDay() { return publicationDay; }
    public void setPublicationDay(String publicationDay) { this.publicationDay = publicationDay; }

    @Override
    public String getType() {
        return "Newspaper";
    }

    @Override
    public String toString() {
        return super.toString() + ", publicationDay='" + publicationDay + "'}";
    }

    @Override
    public void printDetails() {
        System.out.println("Type Newspaper");
        System.out.println("Name: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year: " + getYear());
        System.out.println("Publication Day: " + publicationDay);
    }
}






