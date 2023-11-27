package com.cs3203.chatter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    
    // FIXME: provide dependency injection of the database
    private Map<String, User> users = new HashMap<>() {{
        put("1", new User("1", "parker"));
    }};

    @GetMapping("/")
    public String helloWorld() {
        return "Hi, Group S!";
    }
    
    // return every user from the data base
    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return users.values();
    }

    // return a specific user from the database
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        User user = users.get(id);

        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND); // 404 error

        return users.get(id);
    }

    // store a new user in the database
    @PostMapping("/users/")
    public User create(@RequestBody User user) {
        // give the user a random ID
        user.setId(UUID.randomUUID().toString()); 
        users.put(user.getId(), user);
        return user;
    }
}
