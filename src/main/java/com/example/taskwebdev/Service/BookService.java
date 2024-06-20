package com.example.taskwebdev.Service;

import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Pojo.BookPojo;
import com.example.taskwebdev.Pojo.RolePojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface BookService {

    void saveData(BookPojo bookPojo);
    List<Book> getAll();

    void updateData(Long id,BookPojo bookPojo);

    void deleteById(Integer id);
    Optional<Book> findById(Integer id);
    boolean existsById(Long id);
}
