package Rasheed.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import Rasheed.backend.Entity.Book;
import Rasheed.backend.Repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;
    private Book book;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getallBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book with id " + id + " not found"));
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Integer id, Book updatedBook) {
        Book book = getBookById(id);
        book.setTitle(updatedBook.getTitle());
        book.setISBN(updatedBook.getISBN());
        book.setAvailable(updatedBook.isAvailable());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());

        return bookRepository.save(book);
    }

    public List<Book> findByAvailability(boolean availability) {
        return bookRepository.findByAvailable(availability);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    

}
