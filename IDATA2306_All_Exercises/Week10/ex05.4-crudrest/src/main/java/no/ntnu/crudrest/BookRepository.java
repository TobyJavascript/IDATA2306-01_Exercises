package no.ntnu.crudrest;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Iterable<Book> findByYearGreaterThan(int minYear);
}
