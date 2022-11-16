package com.company.Summative2FriendShakiya.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable
{
    // Properties
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String isbn;



    private LocalDate publishDate;

    @Column(name = "author_id")
    private int authorID;

    private String title;

    @Column(name = "publisher_id")
    private int publisherID;

    private BigDecimal price;


    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Hashcode and Equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID && authorID == book.authorID && publisherID == book.publisherID && Objects.equals(isbn, book.isbn) && Objects.equals(publishDate, book.publishDate) && Objects.equals(title, book.title) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, isbn, publishDate, authorID, title, publisherID, price);
    }

    // ToString
    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", isbn='" + isbn + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", authorID=" + authorID +
                ", title='" + title + '\'' +
                ", publisherID=" + publisherID +
                ", price=" + price +
                '}';
    }
}
