package Rasheed.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import Rasheed.backend.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

    List<Book> findByAvailable(boolean availability);

    List<Book> findByGenre(String genre);
}
