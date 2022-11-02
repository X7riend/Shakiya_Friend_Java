package com.company.Summative2FriendShakiya.Contoller;

import com.company.Summative2FriendShakiya.Model.Publisher;
import com.company.Summative2FriendShakiya.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController
{
    @Autowired
    PublisherRepository repo;

    // Read
    @GetMapping("/publishers")
    public List<Publisher> getPublishers()
    {
        return repo.findAll();
    }

    // Read
    @GetMapping("publishers/{ID}")
    public Publisher getPublisherById(@PathVariable int ID)
    {
        Optional<Publisher> returnVal = repo.findById(ID);
        if (returnVal.isPresent())
        {
            return returnVal.get();
        }
        else
        {
            return null;
        }
    }


    // Update
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher)
    {
        return repo.save(publisher);
    }

    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher)
    {
        repo.save(publisher);
    }

    // Delete
    @DeleteMapping("/publisher/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int ID) { repo.deleteById(ID); }

}
