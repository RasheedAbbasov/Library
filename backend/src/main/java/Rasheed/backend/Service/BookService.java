package Rasheed.backend.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import Rasheed.backend.Entity.Book;
import Rasheed.backend.Repository.BookRepository;
import Rasheed.backend.Service.BookCheckOutService;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookCheckOutService bookCheckOutService;

    public BookService(BookRepository bookRepository, BookCheckOutService bookCheckOutService) {
        this.bookRepository = bookRepository;
        this.bookCheckOutService = bookCheckOutService;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book with id " + id + " not found"));
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Integer id) {
        if(bookCheckOutService.isBookCheckedOut(id)) {
            throw new IllegalStateException("Cannot delete book because it is currently checked out");
        }
        bookRepository.deleteById(id);
    }

    public Book updateBook(Integer id, Book updatedBook) {
        Book book = findById(id);
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
