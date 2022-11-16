package com.company.Summative2FriendShakiya.Contoller;

import com.company.Summative2FriendShakiya.Model.Author;
import com.company.Summative2FriendShakiya.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController
{
    @Autowired
    AuthorRepository repo;

    // Read
    @GetMapping("/authors")
    public List<Author> getAuthors()
    {
        return repo.findAll();
    }

    // Read
    @GetMapping("/authors/{ID}")
    public Author getAuthorById(@PathVariable int ID)
    {
        Optional<Author> returnVal = repo.findById(ID);
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
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author)
    {
        return repo.save(author);
    }

    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author)
    {
        repo.save(author);
    }

    // Delete
    @DeleteMapping("/authors/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int ID)
    {
        repo.deleteById(ID);
    }
}
