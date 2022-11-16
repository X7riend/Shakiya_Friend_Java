package com.company.Summative2FriendShakiya.Repository;

import com.company.Summative2FriendShakiya.Model.Author;
import com.company.Summative2FriendShakiya.Model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest
{
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception
    {
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
        bookRepository.deleteAll();

    }

    @Test
    public void addGetDeleteAuthor()
    {
        // Create Author
        Author author = new Author();
        author.setFirstName("Shakiya");
        author.setLastName("Friend");
        author.setState("AL");
        author.setCity("Huntsville");
        author.setPhone("256-652-5502");
        author.setPostalCode("35810");
        author.setStreet("Melrose");
        author.setEmail("sf@.com");

        // Save Author
        author = authorRepository.save(author);


        Optional<Author> myAuthor = authorRepository.findById(author.getID());

        assertEquals(myAuthor.get(), author);

        authorRepository.deleteById(author.getID());

        myAuthor = authorRepository.findById(author.getID());
        assertFalse(myAuthor.isPresent());
    }
    @Test
    public void getAllAuthors()
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

        Author author1 = new Author();
        author1.setFirstName("Justin");
        author1.setLastName("Lee");
        author1.setState("VA");
        author1.setCity("Chile");
        author1.setPhone("757-081-3502");
        author1.setPostalCode("23504");
        author1.setStreet("Lacklord");
        author1.setEmail("jfts@.com");
        author1 = authorRepository.save(author1);

        List<Author> authorList = authorRepository.findAll();
        assertEquals(authorList.size(), 2);

    }

    @Test
    public void updateAuthor()
    {
        Author author1 = new Author();
        author1.setFirstName("Justin");
        author1.setLastName("Lee");
        author1.setState("VA");
        author1.setCity("Chile");
        author1.setPhone("757-081-3502");
        author1.setPostalCode("23504");
        author1.setStreet("Lacklord");
        author1.setEmail("jfts@.com");
        author1 = authorRepository.save(author1);

        author1.setCity("Janif");
        author1.setLastName("Fell");
        author1.setPostalCode("56739");

        author1 = authorRepository.save(author1);

        authorRepository.findById(author1.getID());

        Optional<Author> optionalAuthor = authorRepository.findById(author1.getID());
        assertEquals(optionalAuthor.get(),author1);
    }
}