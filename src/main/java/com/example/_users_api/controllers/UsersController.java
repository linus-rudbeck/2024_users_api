package com.example._users_api.controllers;

import com.example._users_api.models.User;
import com.example._users_api.repositories.UsersRepository;
import com.example._users_api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private UsersService service;


    // GET: localhost:8080/users
    @GetMapping
    public Iterable<User> getAllUsers() {
        return service.getAllUsers();
    }


    // GET: localhost:8080/users/5
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }


    // POST: localhost:8080/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }


    // DELETE: localhost:8080/users/5
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return service.deleteUserById(id);
    }


    // PUT: localhost:8080/users/5
    @PutMapping("/{id}")
    public boolean putUser(@PathVariable Long id, @RequestBody User user){
        return service.updateUserById(id, user);
    }


    // POST: localhost:8080/users/seed
    @PostMapping("/seed")
    public boolean postSeedUsers() {
        return service.seed();
    }
}
