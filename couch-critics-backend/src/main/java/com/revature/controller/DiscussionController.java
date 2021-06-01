package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Discussion;
import com.revature.service.DiscussionService;

@RestController
@RequestMapping(value="/disc")
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
	@PostMapping(value="/disc/add")
	public ResponseEntity<Boolean> addDiscussion(@RequestBody Discussion d){
		Boolean success = ds.addDiscussion(d);
		
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}
	
	//Receives a Discussion object id
	//Returns a list of Discussion objects
	@GetMapping(value="/disc/{id}")
	public ResponseEntity<Discussion> getDiscussionById(@RequestParam Integer id){
		Discussion d = ds.getDiscussionByDiscussionId(id);
		
		return new ResponseEntity<Discussion>(d, HttpStatus.OK);
	}
	
	//Receives a Users object id
	//Returns a list of Discussion objects
	@GetMapping(value="/users/{userId}/disc")
	public ResponseEntity<List<Discussion>> getDiscussionByUserId(@RequestParam Integer userId){
		List<Discussion> dList = ds.getDiscussionsByUserId(userId);
		
		return new ResponseEntity<List<Discussion>>(dList, HttpStatus.OK);
	}
	
	//Receives a Reviews object id
	//Returns a list of Discussion objects
	@GetMapping(value="/reviews/{reviewId}/disc")
	public ResponseEntity<List<Discussion>> getDiscussionByReviewId(@RequestParam Integer reviewId){
		List<Discussion> dList = ds.getDiscussionsByReviewId(reviewId);
		
		return new ResponseEntity<List<Discussion>>(dList, HttpStatus.OK);
	}
	
}
