package org.example.components;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Publication p : publications) {
            if (p.getAuthor().equalsIgnoreCase(author)) {
                p.printDetails();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("The typed author not founded!");
        }
    }

    public void deletePublication(String title) {
        boolean remove = false;
        Iterator<Publication> iterator = publications.iterator();
        while (iterator.hasNext()) {
            Publication publication = iterator.next();
            if (publication.getTitle().equals(title)) {
                iterator.remove();
                remove = true;
            }
        }
        if (!remove) {
            System.out.println("Item not founded to remove.");
        }
    }

}
