package com.example.monolith;

import com.example.monolith.models.Book;
import com.example.monolith.services.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonolithApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonolithApplication.class, args);
    }

    @Bean
    CommandLineRunner run(BookService bookService) {
        return args -> {
            bookService.save(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
            bookService.save(new Book("1984", "George Orwell", "Dystopian"));
            bookService.save(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction"));
        };
    }
}
