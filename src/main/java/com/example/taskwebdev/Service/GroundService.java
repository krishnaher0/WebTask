package com.example.taskwebdev.Service;

import com.example.taskwebdev.Entity.Ground;
import com.example.taskwebdev.Pojo.BookPojo;
import com.example.taskwebdev.Pojo.GroundPojo;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service

public interface GroundService {
    void saveData(GroundPojo groundpojo);
    List<Ground> getAll();
    void deleteById(Integer id);
    void updateData(Long id, GroundPojo groundPojo);
    Optional<Ground> findById(Integer id);
    boolean existsById(Long id);

}

