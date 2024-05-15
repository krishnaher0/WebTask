package com.example.taskwebdev.Service;

import com.example.taskwebdev.Entity.User;
import com.example.taskwebdev.Pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveData(UserPojo userPojo);
    List<User> getAll();

    void deleteById(Integer id);
    Optional<User> findById(Integer id);
}