package no.ntnu.crudrest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private int birthYear;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnore  // Prevents infinite recursion in JSON serialization
    private Set<Book> books = new HashSet<>();

    public Author() {}

    public Author(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getBirthYear() { return birthYear; }
    public Set<Book> getBooks() { return books; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public void setBooks(Set<Book> books) { this.books = books; }
}
