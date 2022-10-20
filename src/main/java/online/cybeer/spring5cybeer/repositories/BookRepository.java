package online.cybeer.spring5cybeer.repositories;

import online.cybeer.spring5cybeer.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
