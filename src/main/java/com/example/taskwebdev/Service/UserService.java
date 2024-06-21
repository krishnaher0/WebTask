package com.example.taskwebdev.Service;

import com.example.taskwebdev.Entity.User;
import com.example.taskwebdev.Pojo.BookPojo;
import com.example.taskwebdev.Pojo.UserPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface UserService {

    void saveData(UserPojo userPojo);
    List<User> getAll();
    void updateData(Long id, UserPojo userPojo);

    void deleteById(Long id);
    Optional<User> findById(Long id);
    boolean existsById(Long id);
}