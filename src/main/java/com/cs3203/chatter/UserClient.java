package com.cs3203.chatter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserClient {
    public static void main(String[] args) {
        createUser();
    }

    private static void createUser() {
        String baseUrl = "http://localhost:8080";  // Update with your server URL

        // Set up the HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a User object to send in the request body
        User newUser = new User(1, "username");

        // Set up the request entity with headers and body
        HttpEntity<User> requestEntity = new HttpEntity<>(newUser, headers);

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Make the HTTP request to the server
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                baseUrl + "/users/create",
                HttpMethod.POST,
                requestEntity,
                User.class
        );

        // Get the created user from the response
        User createdUser = responseEntity.getBody();

        System.out.println("got here. ");

        // Print the created user details
        System.out.println("Created User: " + createdUser);
    }
}
