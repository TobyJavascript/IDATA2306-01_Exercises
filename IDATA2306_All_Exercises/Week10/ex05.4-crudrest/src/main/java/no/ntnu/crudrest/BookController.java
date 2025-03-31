package no.ntnu.crudrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    public ResponseEntity<Book> addAuthorToBook(@PathVariable int bookId, @PathVariable int authorId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        Optional<Author> authorOpt = authorRepository.findById(authorId);

        if (bookOpt.isEmpty() || authorOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book book = bookOpt.get();
        Author author = authorOpt.get();
        book.getAuthors().add(author);
        bookRepository.save(book);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
