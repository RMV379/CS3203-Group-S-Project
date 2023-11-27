package com.cs3203.chatter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public User getUser(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	public void saveUser(User user) {
        userRepository.save(user);
	}


}
