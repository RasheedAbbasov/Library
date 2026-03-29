package Rasheed.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "isbn", nullable = false, unique = true, length = 255)
    private String ISBN;

    public String getName() {
        return this.name;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }

}
