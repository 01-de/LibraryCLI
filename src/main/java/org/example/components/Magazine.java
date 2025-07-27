package org.example.components;

public class Magazine extends Publication implements Printable {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

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
