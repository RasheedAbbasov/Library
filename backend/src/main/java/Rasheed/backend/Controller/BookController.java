package Rasheed.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import Rasheed.backend.Service.BookService;
import Rasheed.backend.Entity.Book;


@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "https://symmetrical-meme-p6xv54gjgrx2w7x-8080.app.github.dev/")
public class BookController {

    public BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{Id}")
    public void deleteBookById(@PathVariable Integer Id) {
        bookService.deleteBookById(Id);
    }

    @GetMapping("/{Id}")
    public Book findById(@PathVariable Integer Id) {
        return bookService.findById(Id);

    }



}
