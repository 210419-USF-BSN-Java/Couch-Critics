package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Users;
import com.revature.service.UsersService;

@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	private UsersService us;
	
	public UsersController() {
		
	}
	
	@Autowired
	public UsersController(UsersService serv) {
		this.us = us;
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<String> registerUser(@RequestBody Users u){
		String message = us.registUserAccount(u);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Users> loginUser(@PathVariable String uName, @PathVariable String pWord){
		Users u = us.getUserByUnameAndPword(uName, pWord);
	
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}
	
}
