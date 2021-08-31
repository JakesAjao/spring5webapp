package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
    @Query("SELECT s FROM Book s WHERE s.id = ?1")
    Book findBookById(Long id);
}
