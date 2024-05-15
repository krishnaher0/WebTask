package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.User;
import com.example.taskwebdev.Pojo.UserPojo;
import com.example.taskwebdev.Service.UserService;
import com.example.taskwebdev.shared.GlobalApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public GlobalApiResponse<User> getData() {
        return GlobalApiResponse.
                <User>builder()
                .data("saved")
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
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