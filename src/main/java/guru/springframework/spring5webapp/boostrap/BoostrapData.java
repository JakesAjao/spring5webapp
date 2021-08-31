package guru.springframework.spring5webapp.boostrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import guru.springframework.spring5webapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorService = authorService;
    }

    private final AuthorService authorService;


       // this.studentService = studentService;


    @Override
    public void run(String... args) throws Exception {


        Publisher publisher = new Publisher("Martin Fowler","No 12, Ogba Ijaiye, Lagos","Lagos","Lagos","234");

        publisherRepository.save(publisher);
        System.out.println("Numbers of Publishers: "+publisherRepository.count());

        Author eric = new Author("Eric","Eric");
        Book ddd = new Book("Domain Driven Design","1234567");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","6899999");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Boostrap.");
        System.out.println("Numbers of Books: "+bookRepository.count());
        System.out.println("Numbers of Author: "+authorRepository.count());

        System.out.println("Publishers name of books: "+publisher.getBooks().size());

        /*Book book = bookRepository.findBookById(3L);
        Author author = authorRepository.findAuthorById(3L);
        book.getAuthors().remove(author);
        System.out.println("Numbers of Author after delete: "+book.getAuthors().size());

        Book book2 = bookRepository.findBookById(5L);
        Author author2 = authorRepository.findAuthorById(5L);
        book2.getAuthors().remove(author2);
        System.out.println("Numbers of Author second after delete: "+book.getAuthors().size());

        for(Author auth:book.getAuthors()){
            System.out.println(auth);
        }*/






    }
}
