package com.capgemini.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.User;
import com.capgemini.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired
	private UserRepository repository;
 
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public User AddingUser(@RequestBody User user) {
		
		return repository.save(user);

	}

	@GetMapping(path="{userId}"  ,produces= MediaType.APPLICATION_JSON_VALUE)
	public Optional<User> getUser(@PathVariable("userId") int id) {
	Optional<User> user=	repository.findById(id);
		return user;
	}
	
	
	
}
