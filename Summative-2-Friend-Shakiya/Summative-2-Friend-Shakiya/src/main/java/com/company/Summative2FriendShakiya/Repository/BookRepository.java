package com.company.Summative2FriendShakiya.Repository;

import com.company.Summative2FriendShakiya.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>
{
    // Find Books By Author
    List<Book> findAllBooksByAuthorID(int authorID);
}
