package org.example.components;

// Newspaper.java
public class Newspaper extends Publication implements Printable {
    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

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
