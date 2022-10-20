package online.cybeer.spring5cybeer.repositories;

import online.cybeer.spring5cybeer.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
