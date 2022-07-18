package com.example.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import com.example.springbootbackend.repository.UserRepo;
import com.example.springbootbackend.model.*;



@RestController
@RequestMapping("/api/v1/")
public class UserController {
    

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    
    @PostMapping("/users")
        public User createUser(@RequestBody User user) {
            return userRepo.save(user);
    }

    // @GetMapping("/users/{id}")
    // public ResponseEntity<User> getUserById(@PathVarible Long id) {
    //     User user = userRepo.findById(id)
    //         .orElseThrow(() -> new ResourcesNotFoundEx("User doesnt exist with id " + id));
    //         return ResponseEntity.ok(user);
    // }
}
