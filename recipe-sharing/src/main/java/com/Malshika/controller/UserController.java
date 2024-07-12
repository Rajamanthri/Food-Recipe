package com.Malshika.controller;

import com.Malshika.model.User;
import com.Malshika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {

        User isExist=userRepository.findByEmail(user.getEmail());
        if (isExist!=null){
            throw new Exception("user is exist with "+user.getEmail());
        }

        User savedUser =userRepository.save(user);

        return savedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) throws Exception {

        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception {

        List<User> users=userRepository.findAll();
        return users;
    }

//    public User findByEmail(String email) throws Exception{
//        User user=userRepository.findByEmail(email);
//        if (user==null){
//            throw new Exception("user not found with email"+email);
//        }
//        return user;
//    }
}
