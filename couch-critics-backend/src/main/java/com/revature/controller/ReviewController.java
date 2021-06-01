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
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Reviews;
import com.revature.service.ReviewService;

@RestController
@RequestMapping(value="/review")
public class ReviewController {
	
	private ReviewService rs;
	
	@Autowired
	public ReviewController(ReviewService rs) {
		this.rs = rs;
	}
	
	@PostMapping(value="/viewByCriticId{id}")
	public ResponseEntity<List<Reviews>> getReviewByCriticsId(@PathVariable int id){
		
		List<Reviews> reviews = rs.getReviewByCriticsId(id);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	@PostMapping(value="/viewByMovieName{name}")
	public ResponseEntity<List<Reviews>> getReviewByMovieName(@PathVariable String name){
		
		List<Reviews> reviews = rs.getReviewByMovieName(name);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	@GetMapping(value="/addReview")
	public ResponseEntity<String> addReview(@RequestBody Reviews r){
		
		String success = rs.addReview(r);
		
		
		
		return new ResponseEntity<String>(success, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/deleteReview{id}")
	public ResponseEntity<String> deleteReview(@PathVariable int id){
		
		String success = rs.deleteReview(id);
		
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
	
	@GetMapping(value="/viewByReviewStatus{status}")
	public ResponseEntity<List<Reviews>> viewByReviewStatus(@PathVariable String status){
		
		List<Reviews> reviews = rs.getReviewByReviewStatus(status);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}

}
