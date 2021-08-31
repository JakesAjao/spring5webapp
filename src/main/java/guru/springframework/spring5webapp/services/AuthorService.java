package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private final BookRepository bookRepository;


    @Transactional
    public Author findByAuthorId(Long authorId){
        Author author = authorRepository.findById(authorId).get();
        return author;
    }
    public void UpdateAuthor(Author author){
        if (author==null){
            System.out.println("Author is empty.");
            return;
        }
        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());
        authorRepository.save(author);
    }

    public Set<Author> DeleteAuthor(Long authorId) {
        if (authorId > 0) {
//            Book book = bookRepository.findBookById(authorId);
//            Author author = authorRepository.findAuthorById(authorId);
//            book.getAuthors().remove(author);
//            System.out.println("Numbers of Author after delete: "+book.getAuthors().size());
//            return book.getAuthors();
            Book book = bookRepository.findBookById(3L);
            Author author = authorRepository.findAuthorById(3L);
            book.getAuthors().remove(author);
            System.out.println("Numbers of Author after delete: "+book.getAuthors().size());
            return book.getAuthors();
        }
        return null;
    }
}
