package com.example.taskwebdev.Service.Implementer;


import com.example.taskwebdev.Entity.User;
import com.example.taskwebdev.Pojo.RolePojo;
import com.example.taskwebdev.Pojo.UserPojo;
import com.example.taskwebdev.Repo.UserRepo;
import com.example.taskwebdev.Service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service


@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepo userRepo;
    @Transactional
    public void saveUser(User user) {
        userRepo.save(user);
    }
    @Override
    public void saveData(UserPojo userPojo) {
        User user = new User();
user.setId(userPojo.getId());
        user.setUserName(userPojo.getUserName());
        userRepo.save(user);
    }
    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public void updateData(Long id, UserPojo userPojo) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            // Update the existing student with the data from studentPojo
            updateStudentProperties(existingUser, userPojo);
            userRepo.save(existingUser); // Save the updated student
        } else {
            // Handle the case where the student with the given ID does not exist
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(User user, UserPojo userPojo) {

//        user.setId(userPojo.getId());
        user.setUserName(userPojo.getUserName());

        userRepo.save(user);

        // You may need to update other properties here
    }
    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
    @Override
    public Optional<User> findById(Long bookingId) {
        return userRepo.findById(bookingId);
    }

    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }
}