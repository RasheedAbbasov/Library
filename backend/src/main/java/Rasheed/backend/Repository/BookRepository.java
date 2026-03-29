package Rasheed.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import Rasheed.backend.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // List<Book> findByAuthor(String author); Future Use

    List<Book> getBooksByName(String name);

    // List<Book> getBooksByGenre(String genre);  Future Use
}
