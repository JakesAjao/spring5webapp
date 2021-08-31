package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Transactional
    public void updateAuthor(Long authorId, String firstName, String lastName) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalStateException(
                        "author with the id "+authorId +" does not exist."));
//        if (firstName != null &&
//                firstName.length()>0 &&
//                !Objects.equals(author.getFirstName(),firstName)){
//            author.setFirstName(firstName);
//        }
        if (lastName != null &&
                lastName.length()>0 &&
                !Objects.equals(author.getLastName(),lastName)){
            author.setLastName(lastName);
        }
        if (firstName != null &&
                firstName.length()>0 &&
                !Objects.equals(author.getFirstName(),firstName)){

            Optional<Author> authorOptional = authorRepository.findAuthorByFirstName(firstName);
            if (authorOptional.isPresent()){
                //throw new IllegalStateException("FirstName Taken");
                System.out.println("FirstName Taken");
            }

            author.setFirstName(firstName);
            System.out.println("FirstName Updated.");
        }
    }
    @Transactional
    public Author findByAuthorId(Long authorId){
        //Optional<Author> authorOptional = authorRepository.findAuthorByFirstName(authorId);
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalStateException(
                "author with the id "+authorId +" does not exist."));
        return author;

    }
}
