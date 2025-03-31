package no.ntnu.crudrest;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int year;
    private int numberOfPages;

    @ManyToMany
    @JoinTable(
        name = "author_book",  // Name of the join table
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public Book() {}

    public Book(String title, int year, int numberOfPages) {
        this.title = title;
        this.year = year;
        this.numberOfPages = numberOfPages;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getNumberOfPages() { return numberOfPages; }
    public Set<Author> getAuthors() { return authors; }

    public void setTitle(String title) { this.title = title; }
    public void setYear(int year) { this.year = year; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
    public void setAuthors(Set<Author> authors) { this.authors = authors; }
}
