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

import java.time.LocalDate;
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
        Book book = new Book();

        book.setBookingId(bookPojo.getBookingId());

        book.setUserName(bookPojo.getUserName());
        book.setGround(bookPojo.getGroundId());
        book.setUser(bookPojo.getUserId());

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
            updateBookProperties(existingBook, bookPojo);
            bookRepo.save(existingBook); // Save the updated student
        } else {
            // Handle the case where the student with the given ID does not exist
            throw new IllegalArgumentException("Book with ID " + id + " not found");
        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateBookProperties(Book book, BookPojo bookPojo) {
        book.setBookingId(bookPojo.getBookingId());

        book.setUserName(bookPojo.getUserName());
        book.setGround(bookPojo.getGroundId());
        book.setUser(bookPojo.getUserId());

        bookRepo.save(book);




        // You may need to update other properties here
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long bookingId) {
        return bookRepo.findById(bookingId);
    }

    @Override
    public boolean existsById(Long id) {
        return bookRepo.existsById(id);
    }


}