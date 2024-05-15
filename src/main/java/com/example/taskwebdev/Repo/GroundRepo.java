package com.example.taskwebdev.Repo;

import com.example.taskwebdev.Entity.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundRepo extends JpaRepository<Ground, Long> {

}