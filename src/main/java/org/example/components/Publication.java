package org.example.components;

public abstract class Publication implements Printable {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

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
