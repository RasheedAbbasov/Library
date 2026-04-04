package Rasheed.backend.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import Rasheed.backend.Entity.BookCheckOut;
import Rasheed.backend.Repository.BookCheckOutRepository;
import Rasheed.backend.Entity.Book;


@Service
public class BookCheckOutService {

    private BookCheckOutRepository bookCheckOutRepository;


    public BookCheckOutService(BookCheckOutRepository bookCheckOutRepository) {
        this.bookCheckOutRepository = bookCheckOutRepository;
    }


    public List<BookCheckOut> getAllBookCheckOuts() {
        return bookCheckOutRepository.findAll();
    }

    public BookCheckOut findById(Integer id) {
        return bookCheckOutRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("BookCheckOut with id " + id + " not found"));
    }

    public void addBookCheckOut(BookCheckOut bookCheckOut) {
        bookCheckOutRepository.save(bookCheckOut);
    }

    public void updateBookCheckOut(Integer id, BookCheckOut updatedBookCheckOut) {
        BookCheckOut bookCheckOut = findById(id);
        bookCheckOut.setFirstName(updatedBookCheckOut.getFirstName());
        bookCheckOut.setLastName(updatedBookCheckOut.getLastName());
        bookCheckOut.setAddress(updatedBookCheckOut.getAddress());
        bookCheckOut.setDate(updatedBookCheckOut.getDate());
        bookCheckOut.setBook(updatedBookCheckOut.getBook());

        bookCheckOutRepository.save(bookCheckOut);
    }

    public void deleteBookCheckOutById(Integer id) {
        bookCheckOutRepository.deleteById(id);
    }

    public BookCheckOut findByBookId(Integer bookId) {
        return bookCheckOutRepository.findByBookId(bookId);
    }

    public boolean isBookCheckedOut(Integer bookId) {
        return bookCheckOutRepository.existsByBookId(bookId);
    }




}
