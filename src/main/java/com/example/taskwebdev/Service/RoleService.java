package com.example.taskwebdev.Service;


import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Entity.Role;
import com.example.taskwebdev.Pojo.RolePojo;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    void saveData(RolePojo rolePojo);
    List<Role> getAll();

    void deleteById(Integer id);
    Optional<Role> findById(Integer id);
}