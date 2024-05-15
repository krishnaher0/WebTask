package com.example.taskwebdev.Controller;

import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Pojo.GroundPojo;
import com.example.taskwebdev.Service.GroundService;
//import jakarta.validation.Valid;
import com.example.taskwebdev.shared.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ground")
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;

    @GetMapping("/get")
    public GlobalApiResponse<Ground> getData() {
        return GlobalApiResponse.
                <Ground>builder()
                .data("saved")
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
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