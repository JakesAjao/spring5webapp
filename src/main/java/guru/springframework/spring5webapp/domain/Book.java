package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isb;
    private String title;
    @ManyToMany
    @JoinTable(name="author_book",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns =
    @JoinColumn(name="author_id"))
    private Set<Author> authors;

    public Book() {
    }
    public Book(String isb, String title, Set<Author> authors) {
        this.isb = isb;
        this.title = title;
        this.authors = authors;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsb() {
        return isb;
    }

    public void setIsb(String isb) {
        this.isb = isb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


}
