package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.User;
import com.example.taskwebdev.Pojo.GroundPojo;
import com.example.taskwebdev.Pojo.UserPojo;
import com.example.taskwebdev.Service.UserService;

import com.example.taskwebdev.shared.pojo.GlobalApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public GlobalApiResponse<List<User>> getData() {
        return GlobalApiResponse.
                <List<User>>builder()
                .data(userService.getAll())
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody UserPojo userPojo) {
        if (!userService.existsById(id.longValue())) {
            return new ResponseEntity<>("Students id" + id + " not found", HttpStatus.NOT_FOUND);
        }

        // Update the existing ground with the provided ID
        userService.updateData(id.longValue(), userPojo);

        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public void save(@RequestBody @Valid UserPojo userPojo) {
        this.userService.saveData(userPojo);
    }

    @GetMapping("/get/{id}")
    public Optional<User> getData(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.userService.deleteById(id);
    }
}