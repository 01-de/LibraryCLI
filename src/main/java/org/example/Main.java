package org.example;
import org.example.components.*;

import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library CLI by 01-de");
            System.out.println("1: Add new publication");
            System.out.println("2: List of all publications");
            System.out.println("3: Search by author");
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
                    System.out.println("Type author: ");
                    String author = scanner.nextLine();

                    System.out.println("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    if (type == 1) {
                        System.out.println("Enter ISBN: ");
                        String ISBN = scanner.nextLine();
                        library.addPublication(new Book(title, author, year, ISBN));
                    } else if (type == 2) {
                        System.out.println("Enter Issue Number: ");
                        int issueNumber = scanner.nextInt();
                        scanner.nextLine();
                        library.addPublication(new Magazine(title, author, year, issueNumber));
                    } else if (type == 3) {
                        System.out.println("Enter a publication day (for example 'Monday')");
                        String publicationDay = scanner.nextLine();
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
                    library.searchByAuthor(query);
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





