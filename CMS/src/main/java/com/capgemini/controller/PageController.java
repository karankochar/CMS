package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Page;
import com.capgemini.entities.User;
import com.capgemini.repository.PageRepository;
import com.capgemini.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "page")
public class PageController {
	@Autowired
	private PageRepository repository;
 
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public Page AddingPage(@RequestBody Page page) {
		
		return repository.save(page);

	}
	
	
}
