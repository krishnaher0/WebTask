package com.example.taskwebdev.Service.Implementer;

import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Pojo.GroundPojo;
import com.example.taskwebdev.Repo.GroundRepo;
import com.example.taskwebdev.Service.GroundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroundImpl implements GroundService {

    private final GroundRepo groundRepo;

    @Override
    public void saveData(GroundPojo groundPojo) {
        Ground ground = new Ground();
        ground.setId(groundPojo.getId());
        ground.setName(groundPojo.getName());
        groundRepo.save(ground);
    }

    @Override
    public List<Ground> getAll() {
        return groundRepo.findAll();
    }

    @Override
    public void updateData(Long id, GroundPojo groundPojo) {
        Optional<Ground> groundOptional = groundRepo.findById(id);
        if (groundOptional.isPresent()) {
            Ground existingGround = groundOptional.get();
            // Update the existing student with the data from studentPojo
            updateStudentProperties(existingGround, groundPojo);
            groundRepo.save(existingGround); // Save the updated student
        } else {
            // Handle the case where the student with the given ID does not exist
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(Ground ground, GroundPojo groundPojo) {

        ground.setName(groundPojo.getName());

        groundRepo.save(ground);

        // You may need to update other properties here
    }

    @Override
    public void deleteById(Long id) {
        groundRepo.deleteById(id);
    }

    @Override
    public Optional<Ground> findById(Long id) {
        return groundRepo.findById(id);
    }

    public boolean existsById(Long id) {
        return groundRepo.existsById(id);
    }
}