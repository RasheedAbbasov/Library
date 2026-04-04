package Rasheed.backend.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Rasheed.backend.Service.BookCheckOutService;
import java.util.List;
import Rasheed.backend.Entity.BookCheckOut;

@RestController
@RequestMapping("/checkout")
public class BookCheckOutController {

    private BookCheckOutService bookCheckOutService;


    public BookCheckOutController(BookCheckOutService bookCheckOutService) {
        this.bookCheckOutService = bookCheckOutService;
    }
    
    @GetMapping
    public List<BookCheckOut> getAllBookCheckOuts() {
        return bookCheckOutService.getAllBookCheckOuts();
    }

    @GetMapping("/{id}")
    public BookCheckOut findById(@PathVariable Integer id) {
        return bookCheckOutService.findById(id);
    }

    @GetMapping("/book/{bookId}") 
    public BookCheckOut findByBookId(@PathVariable Integer bookId) {
        return bookCheckOutService.findByBookId(bookId);
    }
    
    @PostMapping
    public void addBookCheckOut(@RequestBody BookCheckOut bookCheckOut) {
        bookCheckOutService.addBookCheckOut(bookCheckOut);
    }

    @PutMapping("/{id}")
    public void updateBookCheckOut(@PathVariable Integer id, @RequestBody BookCheckOut updatedBookCheckOut) {
        bookCheckOutService.updateBookCheckOut(id, updatedBookCheckOut);
    }

    @DeleteMapping("/{id}")
    public void deleteBookCheckOutById(@PathVariable Integer id) {
        bookCheckOutService.deleteBookCheckOutById(id);
    }

}
