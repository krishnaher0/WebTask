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
        Book teacherAttendance = new Book();
//        System.out.println("Attendance Date: " + teacherAttendancePojo.getDateNow());
        teacherAttendance.setUserId(bookPojo.getUserId());
        teacherAttendance.setGroundId(bookPojo.getGroundId());
//        teacherAttendance.setIdentity(teacherAttendancePojo.getIdentity());
        // Use the date from attendancePojo instead of always using LocalDate.now()
        if (bookPojo.getBookingId() != null) {
            teacherAttendance.setBookingId(bookPojo.getBookingId());
        } else {
            System.out.println("Please fill the booking id");
        }
        teacherAttendance.setUserName(bookPojo.getUserName());
        System.out.println("Attendance before save: " + teacherAttendance);
        bookRepo.save(teacherAttendance);

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
            // Update the existing student with the data from studentPojo
            updateStudentProperties(existingTeacher, bookPojo);
            bookRepo.save(existingTeacher); // Save the updated student
        } else {
            // Handle the case where the student with the given ID does not exist
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(Book teacherAttendance, BookPojo bookPojo) {

        teacherAttendance.setUserId(bookPojo.getUserId());
        teacherAttendance.setGroundId(bookPojo.getGroundId());
//        teacherAttendance.setIdentity(teacherAttendancePojo.getIdentity());
        // Use the date from attendancePojo instead of always using LocalDate.now()
        if (bookPojo.getBookingId() != null) {
            teacherAttendance.setBookingId(bookPojo.getBookingId());
        } else {
            System.out.println("Please fill the booking id");
        }
        teacherAttendance.setUserName(bookPojo.getUserName());
        System.out.println("Attendance before save: " + teacherAttendance);
        bookRepo.save(teacherAttendance);

        // You may need to update other properties here
    }



}