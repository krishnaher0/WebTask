package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Entity.Role;
import com.example.taskwebdev.Pojo.RolePojo;
import com.example.taskwebdev.Service.BookService;
import com.example.taskwebdev.shared.GlobalApiResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final BookService roleService;

    @GetMapping("/get")
    public GlobalApiResponse<Role> getData() {
        return GlobalApiResponse.
                <Role>builder()
                .data("saved")
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PostMapping("/save")
    public void save(@RequestBody RolePojo rolePojo) {
        this.roleService.saveData(rolePojo);
    }

    @GetMapping("/get/{id}")
    public Optional<Book> getData(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.roleService.deleteById(id);
    }
}