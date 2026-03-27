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
    private Long id;

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
}
