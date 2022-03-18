package com.example.webshop.service;

import com.example.webshop.entity.User;
import com.example.webshop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    // Create operation
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Read operations
    public User fetchUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No user with id " + id));
    }

    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    // Update operation
    public User updateUser(User user, Long id) {
        User u = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No user with id " + id));
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        return userRepository.save(u);
    }

    // Delete operation
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
