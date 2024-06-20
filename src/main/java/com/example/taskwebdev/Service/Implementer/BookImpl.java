package com.example.taskwebdev.Service.Implementer;


import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Entity.User;
import com.example.taskwebdev.Pojo.BookPojo;
import com.example.taskwebdev.Repo.BookRepo;
import com.example.taskwebdev.Repo.GroundRepo;
import com.example.taskwebdev.Repo.UserRepo;
import com.example.taskwebdev.Service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {

    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private final  GroundRepo groundRepo;


    @Override
    public void saveData(BookPojo bookPojo) {
        User user = userRepo.findById(bookPojo.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Ground ground = groundRepo.findById(bookPojo.getGroundId())
                .orElseThrow(() -> new RuntimeException("Ground not found"));
        Book book = new Book();
        book.setBookingId(bookPojo.getBookingId());
        System.out.println(bookPojo.getBookingId());
        System.out.println(bookPojo.getGroundId());
        book.setUserName(bookPojo.getUserName());
      book.setGround(ground);
      book.setUser(user);
        bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        System.out.println("Hello honey bunny");
        return bookRepo.findAll();

    }

    @Override
    public void updateData(Long id, BookPojo bookPojo) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            Book existingBook = bookOptional.get();
            // Update the existing student with the data from studentPojo
            updateStudentProperties(existingBook, bookPojo);
            bookRepo.save(existingBook); // Save the updated student
        } else {
            // Handle the case where the student with the given ID does not exist
            throw new IllegalArgumentException("Book with ID " + id + " not found");
        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(Book book, BookPojo bookPojo) {
        User user = userRepo.findById(bookPojo.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Ground ground = groundRepo.findById(bookPojo.getGroundId())
                .orElseThrow(() -> new RuntimeException("Ground not found"));
        book.setBookingId(bookPojo.getBookingId());
        System.out.println(bookPojo.getBookingId());
        System.out.println(bookPojo.getGroundId());
        book.setUserName(bookPojo.getUserName());
        book.setGround(ground);
        book.setUser(user);




        // You may need to update other properties here
    }

    @Override
    public void deleteById(Integer id) {
        bookRepo.deleteById(Long.valueOf(id));
    }

    @Override
    public Optional<Book> findById(Integer bookingId) {
        return bookRepo.findById(Long.valueOf(bookingId));
    }

    @Override
    public boolean existsById(Long id) {
        return bookRepo.existsById(id);
    }


}