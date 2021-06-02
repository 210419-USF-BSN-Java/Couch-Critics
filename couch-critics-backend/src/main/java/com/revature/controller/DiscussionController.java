package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Discussion;
import com.revature.service.DiscussionService;

@RestController
@RequestMapping(value="/disc")
@CrossOrigin(origins="8080") 
public class DiscussionController {

	private DiscussionService ds;
	
	public DiscussionController() {
		
	}
	
	@Autowired
	public DiscussionController(DiscussionService ds) {
		this.ds = ds;
	}
	
	//Receives a Discussion object 
	//Returns a Boolean and OK status code
	@PostMapping(value="/add")
	public ResponseEntity<Boolean> addDiscussion(@RequestBody Discussion d){
		Boolean success = ds.addDiscussion(d);
		
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}
	
	//Receives a Discussion object id
	//Returns a list of Discussion objects
	@GetMapping(value="/{id}")
	public ResponseEntity<Discussion> getDiscussionById(@PathVariable("id") Integer id){
		Discussion d = ds.getDiscussionByDiscussionId(id);
		
		return new ResponseEntity<Discussion>(d, HttpStatus.OK);
	}
	
	//Receives a Users object id
	//Returns a list of Discussion objects
	@GetMapping(value="/users/{userId}")
	public ResponseEntity<List<Discussion>> getDiscussionByUserId(@PathVariable("userId") Integer userId){
		List<Discussion> dList = ds.getDiscussionsByUserId(userId);
		
		return new ResponseEntity<List<Discussion>>(dList, HttpStatus.OK);
	}
	
	//Receives a Reviews object id
	//Returns a list of Discussion objects
	@GetMapping(value="/reviews/{reviewId}")
	public ResponseEntity<List<Discussion>> getDiscussionByReviewId(@PathVariable("reviewId") Integer reviewId){
		List<Discussion> dList = ds.getDiscussionsByReviewId(reviewId);
		
		return new ResponseEntity<List<Discussion>>(dList, HttpStatus.OK);
	}
	
}
