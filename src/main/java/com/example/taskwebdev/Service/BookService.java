package com.example.taskwebdev.Service;

import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Pojo.RolePojo;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void saveData(RolePojo bookPojo);
    List<Book> getAll();

    void deleteById(Integer id);
    Optional<Book> findById(Integer id);
}