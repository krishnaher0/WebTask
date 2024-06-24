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

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {

    private final BookRepo bookRepo;
//    private final UserRepo userRepo;
//    private final  GroundRepo groundRepo;

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



    @Override
    public void saveData(BookPojo bookPojo) {
        Book book = new Book();
        book.setBookingId(bookPojo.getBookingId());
        book.setUserName(bookPojo.getUserName());
        book.setGround(bookPojo.getGround());
        book.setUser(bookPojo.getUser());

        bookRepo.save(book);
    }


    @Override
    public List<Book> getAll() {
        System.out.println("Hello honey bunny");
        return bookRepo.findAll();

    }

    @Override
    public void updateData(Long id, BookPojo bookPojo) {
        Optional<Book> teacherAOptional = bookRepo.findById(id);
        if (teacherAOptional.isPresent()) {
            Book existingTeacher = teacherAOptional.get();
            updateStudentProperties(existingTeacher, bookPojo);
            bookRepo.save(existingTeacher); // Save the updated student
        } else {

            throw new IllegalArgumentException("Booking with ID " + id + " not found");
        }
    }
    private void updateStudentProperties(Book book, BookPojo bookPojo) {

        book.setUser(bookPojo.getUser());
        book.setGround(bookPojo.getGround());
        book.setUserName(bookPojo.getUserName());
        System.out.println("Attendance before save: " + book);
        bookRepo.save(book);

    }



}