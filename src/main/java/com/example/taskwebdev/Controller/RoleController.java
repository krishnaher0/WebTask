package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Entity.Role;
import com.example.taskwebdev.Pojo.GroundPojo;
import com.example.taskwebdev.Pojo.RolePojo;
import com.example.taskwebdev.Service.BookService;

import com.example.taskwebdev.Service.RoleService;
import com.example.taskwebdev.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get")
    public GlobalApiResponse<List<Role>> getData() {
        return GlobalApiResponse.
                <List<Role>>builder()
                .data(roleService.getAll())
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody RolePojo rolePojo) {
        if (!roleService.existsById(id.longValue())) {
            return new ResponseEntity<>("Students id" + id + " not found", HttpStatus.NOT_FOUND);
        }

        // Update the existing ground with the provided ID
        roleService.updateData(id.longValue(), rolePojo);

        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public void save(@RequestBody RolePojo rolePojo) {
        this.roleService.saveData(rolePojo);
    }

    @GetMapping("/get/{id}")
    public Optional<Role> getData(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.roleService.deleteById(id);
    }
}