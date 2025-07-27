package org.example.components;

import java.util.ArrayList;
import java.util.List;

public class Library {
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

    public void print() {

    }

    public void searchByQuery(String query) {
        boolean found = false;
        for (Publication p : publications) {
            if (p.getAuthor().equalsIgnoreCase(query) || p.getTitle().equalsIgnoreCase(query)) {
                p.printDetails();
                System.out.println();
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
