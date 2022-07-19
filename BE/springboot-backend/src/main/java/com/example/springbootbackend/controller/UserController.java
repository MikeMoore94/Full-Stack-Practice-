package com.example.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import com.example.springbootbackend.repository.UserRepo;
import com.example.springbootbackend.exception.ResoucresNotFoundEx;
import com.example.springbootbackend.model.*;


@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepo.findById(id)
            .orElseThrow(() -> new ResoucresNotFoundEx("User doesnt exist with id " + id));
            return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUse(@PathVariable Long id, @RequestBody User userDetails){
        User user = userRepo.findById(id)
        .orElseThrow(() -> new ResoucresNotFoundEx("User does not exist with id " + id));

        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());

        User updatedUser = userRepo.save(user);
        return ResponseEntity.ok(updatedUser); 

    }
}
