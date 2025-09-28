package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save new user
    public UserModel saveUser(UserModel user) 
    {
        return userRepository.save(user);
    }

    // Get all users
    public List<UserModel> getAllUsers() 
    {
        return userRepository.findAll();
    }

    // Update by ID
    public UserModel updateById(String id, UserModel updatedUser) 
    {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setMobileNumber(updatedUser.getMobileNumber());
            user.setAddress(updatedUser.getAddress());
            user.setEmpDOB(updatedUser.getEmpDOB());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    // Update by Name
    public UserModel updateByName(String name, UserModel updatedUser) 
    {
        UserModel user = userRepository.findByFullName(name);
        if (user != null) {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setMobileNumber(updatedUser.getMobileNumber());
            user.setAddress(updatedUser.getAddress());
            user.setEmpDOB(updatedUser.getEmpDOB());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with name: " + name);
        }
    }

    // Delete by ID
    public void deleteById(String id) 
    {
        userRepository.deleteById(id);
    }

    // Delete by Name
    public void deleteByName(String name) 
    {
        userRepository.deleteByFullName(name);
    }
}
