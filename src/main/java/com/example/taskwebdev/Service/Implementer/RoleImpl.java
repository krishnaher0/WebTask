package com.example.taskwebdev.Service.Implementer;


import com.example.taskwebdev.Entity.Role;
import com.example.taskwebdev.Pojo.RolePojo;
import com.example.taskwebdev.Repo.RoleRepo;
import com.example.taskwebdev.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RoleImpl implements RoleService {
    private final RoleRepo roleRepo;
    @Override
    public void saveData(RolePojo rolePojo) {
        Role role = new Role();

        role.setRoleName(rolePojo.getRoleName());

        roleRepo.save(role);
    }
    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public void updateData(Long id, RolePojo rolePojo) {
        Optional<Role> roleOptional = roleRepo.findById(id);
        if (roleOptional.isPresent()) {
            Role existingRole = roleOptional.get();
            // Update the existing student with the data from studentPojo
            updateStudentProperties(existingRole, rolePojo);
            roleRepo.save(existingRole); // Save the updated student
        } else {
            // Handle the case where the student with the given ID does not exist
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(Role role, RolePojo rolePojo) {

        role.setRoleName(rolePojo.getRoleName());


        roleRepo.save(role);

        // You may need to update other properties here
    }
    @Override
    public void deleteById(Long id) {
        roleRepo.deleteById(id);
    }
    @Override
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }

    public boolean existsById(Long id) {
        return roleRepo.existsById(id);
    }
}