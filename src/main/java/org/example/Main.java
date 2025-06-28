package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
        return getType() + "{title='" + title + "', author='" + author + "', year=" + year;
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


class Library {
    private final List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication pub) {
        publications.add(pub);
    }

    public void listPublication() {
        if (publications.isEmpty()) {
            System.out.println("Catalog is empty");
        } else {
            for (Publication p : publications) {
                System.out.println(p);
            }
        }
    }

    public void searchByQuery(String query) {
        boolean found = false;
        for (Publication p : publications) {
            if (p.getAuthor().equalsIgnoreCase(query) || p.getTitle().equalsIgnoreCase(query)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("The typed author or title not founded!");
        }
    }


    /* public void deletePublication(String title, author) {

     */

}

class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library CLI by 01-de");
            System.out.println("1: Add new publication");
            System.out.println("2: List of all publications");
            System.out.println("3: Search by author or title");
            System.out.println("4: Total number of publications");
            System.out.println("5: Exit");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Add new publication menu:");
                    System.out.println("1 - Book, 2 - Journal, 3 - Newspaper");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Type title: ");
                    String title = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Type author: ");
                    String author = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    if (type == 1) {
                        System.out.println("Enter ISBN: ");
                        String ISBN = scanner.nextLine();
                        scanner.nextLine();
                        library.addPublication(new Book(title, author, year, ISBN));
                    } else if (type == 2) {
                        System.out.println("Enter Issue Number: ");
                        int issueNumber = scanner.nextInt();
                        scanner.nextLine();
                        library.addPublication(new Magazine(title, author, year, issueNumber));
                    } else if (type == 3) {
                        System.out.println("Enter a publication day (for example 'Monday')");
                        String publicationDay = scanner.nextLine();
                        scanner.nextLine();
                        library.addPublication(new Newspaper(title, author, year, publicationDay));
                    } else {
                        System.out.println("Invalid publication type");
                    }

                    break;

                case 2:
                    System.out.println("List of all publications:");
                    library.listPublication();
                    break;

                case 3:
                    System.out.println("Search by author or title:");
                    System.out.println("Enter author or title: ");
                    String query = scanner.nextLine();
                    scanner.nextLine();
                    library.searchByQuery(query);
                    break;

                case 4:
                    System.out.println("Total number of publications: " + Publication.getPublicationCount());
                    break;

                case 5:
                    System.out.println("Exit...");
                    return;

                default:
                    System.out.println("Invalid option please choose between 1-5");


            }
        }
    }
}





