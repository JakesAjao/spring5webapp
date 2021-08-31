package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Long> {
    @Query("SELECT s FROM Author s WHERE s.firstName = ?1")
    Optional<Author> findAuthorByFirstName(String firstName);
    @Query("SELECT s FROM Author s WHERE s.Id = ?1")
    Author findAuthorById(Long Id);
}
