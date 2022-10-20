package online.cybeer.spring5cybeer.repositories;

import online.cybeer.spring5cybeer.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
