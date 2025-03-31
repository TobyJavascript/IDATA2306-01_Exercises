package no.ntnu.crudrest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

/**
 * REST API controller for book collection.
 */
@RestController
@RequestMapping("/books")
public class BookController {

  /**
   * Get All books.
   * HTTP GET to /books
   *
   * @return List of all books currently stored in the collection
   */
  @GetMapping
  public Collection<Book> getAll() {

    try {
      String URL = "jdbc:mysql://localhost:3306/books";
      String USER = "booknerd";
      String PASSWORD = "nerd";

      Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

      // Create a statement
      String query = "SELECT * FROM book";
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);

      // Process the results
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("year");
        int pages = resultSet.getInt("pages");
        String author = resultSet.getString("author");
        String genre = resultSet.getString("genre");

        System.out.println(id + " | " + title + " | " + year + " | " + pages + " | " + author + " | " + genre);
      }

      // Close resources
      resultSet.close();
      statement.close();
      connection.close();
      System.out.println("Connection closed.");

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

    /**
     * Get a specific book.
     *
     * @param id ID of the book to be returned
     * @return Book with the given ID or status 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getOne(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * HTTP POST endpoint for adding a new book.
     *
     * @param book Data of the book to add
     * @return 201 Created on success, 400 Bad request on error
     */
    @PostMapping
    public ResponseEntity<String> add(@RequestBody Book book) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Delete a book from the collection.
     *
     * @param id ID of the book to delete
     * @return 200 OK on success, 404 Not found on error
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

  // /**
  // * Update a book in the repository.
  // *
  // * @param id ID of the book to update, from the URL
  // * @param book New book data to store, from request body
  // * @return 200 OK on success, 400 Bad request on error with error message in
  // the response body
  // */
  // @PutMapping("/{id}")
  // public ResponseEntity<String> update(@PathVariable int id, @RequestBody Book
  // book) {
  // ResponseEntity<String> response;
  // try {
  // updateBook(id, book);
  // response = new ResponseEntity<>(HttpStatus.OK);
  // } catch (Exception e) {
  // response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  // }

  // return response;
  // }

  /**
   * Search through the book collection, find the book with given ID.
   *
   * @param id Book ID
   * @return Book or null if not found
   */
  private Book findBookById(Integer id) {
    return books.get(id);
  }

  /**
   * Add a new book to the collection. Note: ID will be auto-generated, the
   * original ID will
   * not be used!
   *
   * @param book The book to add
   * @return the ID of the added book
   * @throws IllegalArgumentException When the provided book is not valid
   */
  private int addBookToCollection(Book book) throws IllegalArgumentException {
    if (!book.isValid()) {
      throw new IllegalArgumentException("Book is invalid");
    }
    int id = createNewId();
    books.put(id, new Book(id, book.title(), book.year(), book.numberOfPages()));
    return id;
  }

  // /**
  // * Try to update a book with given ID. The book.id must match the id.
  // *
  // * @param id ID of the book
  // * @param book The updated book data
  // * @throws IllegalArgumentException If something goes wrong.
  // * Error message can be used in HTTP response.
  // */
  // private void updateBook(int id, Book book) throws IllegalArgumentException {
  // Book existingBook = findBookById(id);
  // if (existingBook == null) {
  // throw new IllegalArgumentException("No book with id " + id + " found");
  // }
  // if (book == null || !book.isValid()) {
  // throw new IllegalArgumentException("Wrong data in request body");
  // }
  // if (book.id() != id) {
  // throw new IllegalArgumentException(
  // "Book ID in the URL does not match the ID in JSON data (response body)");
  // }

  // books.put(id, book);
  // }
}
