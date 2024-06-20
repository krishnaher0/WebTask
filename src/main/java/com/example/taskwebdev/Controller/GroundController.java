package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Pojo.GroundPojo;
import com.example.taskwebdev.Service.GroundService;
//import jakarta.validation.Valid;
import com.example.taskwebdev.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ground")
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;

    @GetMapping("/get")
    public GlobalApiResponse<List<Ground>> getData() {
        return GlobalApiResponse.
                <List<Ground>>builder()
                .data(groundService.getAll())
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody GroundPojo groundPojo) {
        if (!groundService.existsById(id.longValue())) {
            return new ResponseEntity<>("Students id" + id + " not found", HttpStatus.NOT_FOUND);
        }

        // Update the existing ground with the provided ID
        groundService.updateData(id.longValue(), groundPojo);

        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
    }
    @PostMapping("/save")
    public void save(@RequestBody GroundPojo groundPojo) {
        this.groundService.saveData(groundPojo);
    }

    @GetMapping("/get/{id}")
    public Optional<Ground> getData(@PathVariable Integer id) {
        return groundService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.groundService.deleteById(id);
    }
}