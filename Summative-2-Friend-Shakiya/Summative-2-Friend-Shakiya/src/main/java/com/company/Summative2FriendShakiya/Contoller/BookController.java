package com.company.Summative2FriendShakiya.Contoller;

import com.company.Summative2FriendShakiya.Model.Book;
import com.company.Summative2FriendShakiya.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{
    @Autowired
    BookRepository repo;

    // Read
    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return repo.findAll();
    }

    // Read
    @GetMapping("/books/{id}")
    public Book getBookByID(@PathVariable int ID)
    {
        Optional<Book> returnVal = repo.findById(ID);
        if(returnVal.isPresent())
        {
            return returnVal.get();
        }
        else
        {
            return null;
        }
    }
    @GetMapping("/books/author/{authorID}")
    public Book getBookByAuthorID(@PathVariable int authorID)
    {
        Optional<Book> returnVal = repo.findById(authorID);
        if(returnVal.isPresent())
        {
            return returnVal.get();
        }
        else
        {
            return null;
        }
    }

    // Update
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addABook(@RequestBody Book book)
    {
        return repo.save(book);
    }

    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateABook(@RequestBody Book book)
    {
        repo.save(book);
    }

    // Delete
    @DeleteMapping("/books/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteABook(@PathVariable int ID)
    {
        repo.deleteById(ID);
    }
}
