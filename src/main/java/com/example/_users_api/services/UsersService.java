package com.example._users_api.services;

import com.example._users_api.models.User;
import com.example._users_api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;


    // Get all users
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }


    // Get one user
    public Optional<User> getUserById(Long id){
        return repository.findById(id);
    }


    // Create user
    public User createUser(User user){
        return repository.save(user);
    }


    // Update user
    public boolean updateUserById(Long id, User user){
        if(repository.existsById(id)){
            user.setId(id);

            repository.save(user);

            return true;
        }

        return false;
    }


    // Delete user
    public boolean deleteUserById(Long id) {

        // Kolla om användaren finns
        if(repository.existsById(id)){

            // Ta bort och returnera true om den finns
            repository.deleteById(id);
            return true;
        }

        // Returnera false annars
        return false;
    }


    // Seed users
    public boolean seed() {
        try{
            User[] users = {
                    new User("Linus", "linus@da.se"),
                    new User("Anna", "anna@da.se"),
                    new User("Jens Sen", "jens@sen.se")
            };

            var usersList = Arrays.stream(users).toList();

            repository.saveAll(usersList);

            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
