package com.example.taskwebdev.Service;


import com.example.taskwebdev.Entity.Book;
import com.example.taskwebdev.Entity.Role;
import com.example.taskwebdev.Pojo.BookPojo;
import com.example.taskwebdev.Pojo.RolePojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface RoleService {

    void saveData(RolePojo rolePojo);
    List<Role> getAll();
    void updateData(Long id, RolePojo rolePojo);

    void deleteById(Integer id);
    Optional<Role> findById(Integer id);
    boolean existsById(Long id);
}