package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Pojo.BookPojo;
import com.example.taskwebdev.Pojo.GroundPojo;
import com.example.taskwebdev.Pojo.RolePojo;
import com.example.taskwebdev.Service.BookService;

import com.example.taskwebdev.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public GlobalApiResponse<List<Book>> getData() {
        return GlobalApiResponse.
                <List<Book>>builder()
                .data(bookService.getAll())
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody BookPojo bookPojo) {
        if (!bookService.existsById(id.longValue())) {
            return new ResponseEntity<>("Students id" + id + " not found", HttpStatus.NOT_FOUND);
        }
        bookService.updateData(id.longValue(), bookPojo);

        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<GlobalApiResponse<Void>> save( @RequestBody BookPojo bookPojo) {
        bookService.saveData(bookPojo);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Book saved successfully!")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/{id}")
    public Optional<Book> getData(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.bookService.deleteById(id);
    }
}