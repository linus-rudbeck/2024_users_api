package com.example._users_api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class NamesController {

    @GetMapping("/names")
    public String getName(){ // Hämta ett namn / användare
        return "Your name is Linus....";
    }

    @PostMapping("/names")
    public String postName(@RequestBody String name){ // Skapa ett namn / användare
        return "Posting your name: " + name;
    }

    @PutMapping("/names")
    public String putName(){ // Uppdatera befintligt namn / användare
        return "Updating your name!";
    }

    @DeleteMapping("/names")
    public String deleteName(){ // Ta bort ett befintligt namn / användare
        return "Deleting your name!";
    }

}
