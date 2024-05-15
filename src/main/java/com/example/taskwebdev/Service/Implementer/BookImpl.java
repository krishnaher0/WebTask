package com.example.taskwebdev.Service.Implementer;


import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Pojo.RolePojo;
import com.example.taskwebdev.Repo.BookRepo;
import com.example.taskwebdev.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public void saveData(RolePojo bookPojo) {
        Book book = new Book();
        book.setBookingId(bookPojo.getBookingId());
        book.setUserName(bookPojo.getMemberName());
        bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        bookRepo.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Book> findById(Integer bookingId) {
        return bookRepo.findById(Long.valueOf(bookingId));
    }
}