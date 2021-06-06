package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Users;
import com.revature.service.UsersService;

/*
 * Author: Robbie
 */
@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	private UsersService us;
	
	public UsersController() {
		
	}
	
	@Autowired
	public UsersController(UsersService us) {
		this.us = us;
	}
	
	//This method expecting a Post Request with JSON format Users Object, and return a String indicates if registration is successful.
	@PostMapping(value="/register")
	public ResponseEntity<String> registerUser(@RequestBody Users u){

		String message = us.registUserAccount(u);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	/* This method expecting a Post Request with two variables from the request: 
	 * 1) uName that contains the username, 
	 * 2) pWord that contains the password.
	 * Then return the verified Users Object(JSON format) back to front end.
	*/
	@PostMapping(value="/login")
	public ResponseEntity<Users> loginUser(@RequestParam String username, @RequestParam String password){
		Users u = us.getUserByUnameAndPword(username, password);
	
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}
	
	/* This method expecting a Post Request with a Users object from the request: 
	 * Then return the update status back to the front end.
	*/
	@PostMapping(value="/update")
	public ResponseEntity<String> updateUser(@RequestBody Users u){
		
		String message = us.updateUserAccount(u);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	/* This method expecting a Post Request with a username from the request: 
	 * Then return a String indicates if the username is already exited in the database.
	*/
	@PostMapping(value="/checkUserName")
	public ResponseEntity<String> checkUserName(@RequestParam String username){
		
		String message = us.checkUserName(username);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	/* This method expecting a request with one path variable: 
	 * 1) User role, 
	 * Then return a list of Users that has the same role.
	*/
	@RequestMapping(value="/getUsers/{role}")
	public ResponseEntity<List<Users>> getUsersByRole(@PathVariable String role){
		List<Users> u = us.getUserByRole(role);
	
		return new ResponseEntity<List<Users>>(u, HttpStatus.OK);
	}
	
	/* This method expecting a request with one path variable: 
	 * 1) userid, 
	 * Then return an Users object that has this userid.
	*/
	@GetMapping(value="/getUsersById/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable int id){
		Users u = us.getUserById(id);
	
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}
}
