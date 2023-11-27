package com.cs3203.chatter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired // Autowired will grab the UserService automatically
    private UserService userService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hi, Group S!";
    }
    
    // return every user from the data base
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }

    // return a specific user from the database
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);

        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND); // 404 error

        return userService.getUser(id);
    }

    /* 
    // store a new user in the database
    // fixme:: not compatible with DB yet
    @PostMapping("/users/")
    public User create(@RequestBody User user) {
        // give the user a random ID
        user.setId(UUID.randomUUID()); 
        //users.put(user.getId(), user);
        return userS
    }
    */
}
