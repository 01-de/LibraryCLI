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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Newspaper other = (Newspaper) obj;
        return (publicationDay != null ? publicationDay.equals(other.publicationDay) : other.publicationDay == null);
    }

    @Override
    public int hashCode() {
        int result = 31 * (publicationDay != null ? publicationDay.hashCode() : 0);
        return result;
    }
}
