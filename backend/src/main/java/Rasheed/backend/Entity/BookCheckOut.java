package Rasheed.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "bookcheckout")
public class BookCheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 255)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 255)
    private String lastName;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "date", nullable = false, length = 255)
    private String date;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    //----------------------------------------------------------

    public BookCheckOut() {

    }

    public BookCheckOut(String firstName, String lastName, String address, String date, Book book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.date = date;
        this.book = book;
    }

    public Integer getId() {
        return this.id;
    }

    public Book getBook() {
        return this.book;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDate() {
        return this.date;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
