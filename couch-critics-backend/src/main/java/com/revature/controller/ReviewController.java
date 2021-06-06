package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Reviews;
import com.revature.service.ReviewService;

/*
 * Author: Robbie
 */
@RestController
@RequestMapping(value="/review")
public class ReviewController {
	
	private ReviewService rs;
	
	public ReviewController() {

	}
	
	@Autowired
	public ReviewController(ReviewService rs) {
		this.rs = rs;
	}
	
	//this method is use to view all Reviews belong to this ID with all types of status in database.
	@PostMapping(value="/viewByCriticId/{id}")
	public ResponseEntity<List<Reviews>> getReviewByCriticsId(@PathVariable int id){
		
		List<Reviews> reviews = rs.getReviewByCriticsId(id);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	@GetMapping(value="/viewByMovieName/{name}")
	public ResponseEntity<List<Reviews>> getReviewByMovieName(@PathVariable String name){
		System.out.println(name);
		List<Reviews> reviews = rs.getReviewByMovieName(name);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	@GetMapping(value="/addReview")
	public ResponseEntity<String> addReview(@RequestBody Reviews r){
		
		String success = rs.addReview(r);

		return new ResponseEntity<String>(success, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/deleteReview/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable int id){
		
		String success = rs.deleteReview(id);
		
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/viewByReviewStatus/{status}")
	public ResponseEntity<List<Reviews>> viewByReviewStatus(@PathVariable String status){
		
		List<Reviews> reviews = rs.getReviewByReviewStatus(status);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	//this is to view Reviews by critics ID and the status.
	@RequestMapping(value="/viewByIdAndStatus/{id}/{status}")
	public ResponseEntity<List<Reviews>> viewByIdAndStatus(@PathVariable int id, @PathVariable String status){
	
		List<Reviews> reviews = rs.getReviewByIdAndStatus(id, status);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/attitude/{reviewId}/{attitude}")
	public ResponseEntity<String> addAttitudeFromUser(@PathVariable int reviewId,@PathVariable String attitude){
		
		String addUserAttitude = rs.addAttitudeToReview(attitude, reviewId);
		
		return new ResponseEntity<String>(addUserAttitude, HttpStatus.OK);
	}
	
	@GetMapping(value="/decision/{reviewId}/{decision}")
	public ResponseEntity<String> decisionOnPendingReview(@PathVariable int reviewId,@PathVariable String decision){
		
		String decisionResult = rs.decisionOnPendingReview(reviewId, decision);
		
		return new ResponseEntity<String>(decisionResult, HttpStatus.OK);
	}

}
