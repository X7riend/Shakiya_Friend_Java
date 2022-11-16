package com.company.Summative2FriendShakiya.Repository;

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
public class PublisherRepositoryTest
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
    public void addGetDeletePublisher()
    {
        Publisher publisher = new Publisher();
        publisher.setName("Willam Sanchez");
        publisher.setCity("Brookside");
        publisher.setEmail("pub.lish@gmail.com");
        publisher.setPhone("301-567-9880");
        publisher.setPostalCode("23504");
        publisher.setState("VA");
        publisher.setStreet("Oakwood");

        publisher = publisherRepository.save(publisher);
        Optional<Publisher> myPublisher = publisherRepository.findById(publisher.getPublisherID());

        assertEquals(myPublisher.get(), publisher);

        publisherRepository.deleteById(publisher.getPublisherID());

        myPublisher = publisherRepository.findById(publisher.getPublisherID());
        assertFalse(myPublisher.isPresent());
    }

    @Test
    public void getAllPublishers()
    {
        Publisher publisher1 = new Publisher();
        publisher1.setName("Ericka Low");
        publisher1.setCity("Brooklyn");
        publisher1.setEmail("ELB@gmail.com");
        publisher1.setPhone("305-673-8933");
        publisher1.setPostalCode("23504");
        publisher1.setState("VA");
        publisher1.setStreet("Riverton");

        publisher1 = publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Ericka Low");
        publisher2.setCity("Brooklyn");
        publisher2.setEmail("ELB@gmail.com");
        publisher2.setPhone("305-673-8933");
        publisher2.setPostalCode("23504");
        publisher2.setState("VA");
        publisher2.setStreet("Riverton");

        publisher1 = publisherRepository.save(publisher2);

        List<Publisher> publisherList = publisherRepository.findAll();
        assertEquals(publisherList.size(), 2);
    }

    @Test
    public void updatePublisher()
    {
        Publisher publisher2 = new Publisher();
        publisher2.setName("Ericka Low");
        publisher2.setCity("Brooklyn");
        publisher2.setEmail("ELB@gmail.com");
        publisher2.setPhone("305-673-8933");
        publisher2.setPostalCode("23504");
        publisher2.setState("VA");
        publisher2.setStreet("Riverton");

        publisher2 = publisherRepository.save(publisher2);
        publisher2.setStreet("Homeside");
        publisher2.setName("Tyson David");
        publisher2.setState("AL");

        publisher2 = publisherRepository.save(publisher2);

        publisherRepository.findById(publisher2.getPublisherID());

        Optional<Publisher> optionalPublisher = publisherRepository.findById(publisher2.getPublisherID());
        assertEquals(optionalPublisher.get(), publisher2);
    }
}