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
        role.setRoleId(rolePojo.getRoleId());
        role.setRoleName(rolePojo.getRoleName());
        roleRepo.save(role);
    }
    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        roleRepo.deleteById(Long.valueOf(id));
    }
    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepo.findById(Long.valueOf(id));
    }
}