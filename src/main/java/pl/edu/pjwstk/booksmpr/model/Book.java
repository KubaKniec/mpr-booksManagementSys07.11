package pl.edu.pjwstk.booksmpr.model;

import pl.edu.pjwstk.booksmpr.repository.model.enums.BookType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "title")
    private String title;

//    @Column(name = "publish_date")
    private LocalDate publishDate;

//    @Column(name = "book_type")
    private BookType bookType;


    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

//    @Column(name = "publisher")
    private String publisher;

    public Book() {
    }

    public Book(String title, LocalDate publishDate, BookType bookType, Author author) {
        this.title = title;
        this.publishDate = publishDate;
        this.bookType = bookType;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public BookType getBookType() {
        return bookType;
    }

    public Author getAuthor() {
        return author;
    }
}
