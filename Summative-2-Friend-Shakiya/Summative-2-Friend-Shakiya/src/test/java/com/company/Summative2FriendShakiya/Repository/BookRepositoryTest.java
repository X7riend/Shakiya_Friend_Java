package com.company.Summative2FriendShakiya.Repository;

import com.company.Summative2FriendShakiya.Model.Author;
import com.company.Summative2FriendShakiya.Model.Book;
import com.company.Summative2FriendShakiya.Model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest
{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception
    {
        bookRepository.deleteAll();
    }

    @Test
    public void addGetDeleteBook()
    {
        Author author = new Author();
        author.setFirstName("Shakiya");
        author.setLastName("Friend");
        author.setState("AL");
        author.setCity("Huntsville");
        author.setPhone("256-652-5502");
        author.setPostalCode("35810");
        author.setStreet("Melrose");
        author.setEmail("sf@.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Willam Sanchez");
        publisher.setCity("Brookside");
        publisher.setEmail("pub.lish@gmail.com");
        publisher.setPhone("301-567-9880");
        publisher.setPostalCode("23504");
        publisher.setState("VA");
        publisher.setStreet("Oakwood");

        publisher = publisherRepository.save(publisher);
        Book book = new Book();
        book.setTitle("Here or There");
        book.setIsbn("67876546");
        book.setPrice(new BigDecimal("26.00"));
        book.setPublishDate(LocalDate.of(2022, 4, 6));
        book.setPublisherID(publisher.getPublisherID());
        book.setAuthorID(author.getID());

        book = bookRepository.save(book);

        Optional<Book> myBook = bookRepository.findById(book.getID());

        assertEquals(myBook.get(), book);

        bookRepository.deleteById(book.getID());

        myBook = bookRepository.findById(book.getID());
        assertFalse(myBook.isPresent());
    }

    @Test
    public void updateBook()
    {
        Author author = new Author();
        author.setFirstName("Shakiya");
        author.setLastName("Friend");
        author.setState("AL");
        author.setCity("Huntsville");
        author.setPhone("256-652-5502");
        author.setPostalCode("35810");
        author.setStreet("Melrose");
        author.setEmail("sf@.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Willam Sanchez");
        publisher.setCity("Brookside");
        publisher.setEmail("pub.lish@gmail.com");
        publisher.setPhone("301-567-9880");
        publisher.setPostalCode("23504");
        publisher.setState("VA");
        publisher.setStreet("Oakwood");

        publisher = publisherRepository.save(publisher);

        Book book1 = new Book();
        book1.setTitle("The Giver");
        book1.setIsbn("758093");
        book1.setPrice(new BigDecimal("32.00"));
        book1.setPublishDate(LocalDate.of(2020, 8, 7));
        book1.setAuthorID(author.getID());
        book1.setPublisherID(publisher.getPublisherID());

        book1 = bookRepository.save(book1);

        book1.setPrice(new BigDecimal("29.99"));
        book1.setTitle("A Drop In The Ocean");
        book1.setPublishDate(LocalDate.of(2020, 1, 1));

        book1 = bookRepository.save(book1);

        bookRepository.findById(book1.getID());

        Optional<Book> optionalBook = bookRepository.findById(book1.getID());
        assertEquals(optionalBook.get(),book1);

    }
    @Test
    public void getAllBooks()
    {
        Author author = new Author();
        author.setFirstName("Shakiya");
        author.setLastName("Friend");
        author.setState("AL");
        author.setCity("Huntsville");
        author.setPhone("256-652-5502");
        author.setPostalCode("35810");
        author.setStreet("Melrose");
        author.setEmail("sf@.com");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Willam Sanchez");
        publisher.setCity("Brookside");
        publisher.setEmail("pub.lish@gmail.com");
        publisher.setPhone("301-567-9880");
        publisher.setPostalCode("23504");
        publisher.setState("VA");
        publisher.setStreet("Oakwood");

        publisher = publisherRepository.save(publisher);
        Book book1 = new Book();
        book1.setTitle("The Giver");
        book1.setIsbn("758093");
        book1.setPrice(new BigDecimal("25.75"));
        book1.setPublishDate(LocalDate.of(2022, 8, 7));
        book1.setPublisherID(publisher.getPublisherID());
        book1.setAuthorID(author.getID());

        book1 = bookRepository.save(book1);

        Book book = new Book();
        book.setTitle("The Nanny");
        book.setIsbn("034543");
        book.setPrice(new BigDecimal("43.50"));
        book.setPublishDate(LocalDate.of(2000, 5, 6));
        book.setPublisherID(publisher.getPublisherID());
        book.setAuthorID(author.getID());

        book = bookRepository.save(book);

        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.size(),2);
    }
}