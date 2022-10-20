package online.cybeer.spring5cybeer.bootstrap;

import online.cybeer.spring5cybeer.model.Author;
import online.cybeer.spring5cybeer.model.Book;
import online.cybeer.spring5cybeer.model.Publisher;
import online.cybeer.spring5cybeer.repositories.AuthorRepository;
import online.cybeer.spring5cybeer.repositories.BookRepository;
import online.cybeer.spring5cybeer.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("DDD", "test book");
        Publisher publisher = new Publisher();
        publisher.setName("Ivan");
        publisher.setCity("New York");
        publisher.setState("NY");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development", "2321");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("Started a bootstrap!");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
