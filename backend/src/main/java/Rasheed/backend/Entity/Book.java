package Rasheed.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @JsonProperty("isbn")
    @Column(name = "isbn", nullable = false, unique = true, length = 255)
    private String ISBN;

    @Column(name = "author", nullable = false, unique = false, length = 255)
    private String author;

    @Column(name = "available", nullable = true, columnDefinition = "BOOLEAN DEFAULT  false")
    private boolean available;

    @Column(name = "genre", nullable = false, unique = false, length = 255)
    public String genre; 


//-------------------------------------------------------------------------------

    public Book() {

    }

    public Book(String title, String ISBN, String author, String genre, boolean available) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }


    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }

}
