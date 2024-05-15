package com.example.taskwebdev.Service;

import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Pojo.GroundPojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroundService {
    void saveData(GroundPojo groundpojo);
    List<Ground> getAll();
    void deleteById(Integer id);
    Optional<Ground> findById(Integer id);

}

