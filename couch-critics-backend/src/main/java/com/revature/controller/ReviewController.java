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
	
	
	/* This end point expecting a Post request with one path variable: 
	 * 1) The userid, 
	 * Then return a list of Reviews object that contains this userid.
	*/
	@PostMapping(value="/viewByCriticId/{id}")
	public ResponseEntity<List<Reviews>> getReviewByCriticsId(@PathVariable int id){
		
		List<Reviews> reviews = rs.getReviewByCriticsId(id);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	/* This end point expecting a get request with one path variable: 
	 * 1) The movie name, 
	 * Then return a list of Reviews object that contains this movie name.
	*/
	@GetMapping(value="/viewByMovieName/{name}")
	public ResponseEntity<List<Reviews>> getReviewByMovieName(@PathVariable String name){
		System.out.println(name);
		List<Reviews> reviews = rs.getReviewByMovieName(name);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	/* This end point expecting a get request with a Review object: 
	 * 1) Reviews object that contains the review, status, movieId, movieName, and authorId, 
	 * Then return a String that indicate if the review has been added to database.
	*/
	@GetMapping(value="/addReview")
	public ResponseEntity<String> addReview(@RequestBody Reviews r){
		
		String success = rs.addReview(r);

		return new ResponseEntity<String>(success, HttpStatus.OK);
		
	}
	
	/* This end point expecting a delete request with a path variable: 
	 * 1) The review ID to indicate which to delete.
	 * Then return a String that indicate if the review has been deleted from database.
	*/
	@DeleteMapping(value="/deleteReview/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable int id){
		
		String success = rs.deleteReview(id);
		
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
	
	/* This end point expecting a request with a path variable: 
	 * 1) The status of the reviews.
	 * Then return a list of reviews that have this kind of status.
	*/
	@RequestMapping(value="/viewByReviewStatus/{status}")
	public ResponseEntity<List<Reviews>> viewByReviewStatus(@PathVariable String status){
		
		List<Reviews> reviews = rs.getReviewByReviewStatus(status);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
	
	/* This end point expecting a request with two path variable: 
	 * 1) The authorId.
	 * 2) The reviewStatus.
	 * Then return a list of reviews that contains the authorId and reviewStatus.
	*/
	@RequestMapping(value="/viewByIdAndStatus/{id}/{status}")
	public ResponseEntity<List<Reviews>> viewByIdAndStatus(@PathVariable int id, @PathVariable String status){
	
		List<Reviews> reviews = rs.getReviewByIdAndStatus(id, status);
		
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
		
	}
	
	/* This end point expecting a Get request with two path variable: 
	 * 1) The reviewId.
	 * 2) The attitude that indicates like or dislike.
	 * Then return a String that indicate if the attitude has been added to database.
	*/
	@GetMapping(value="/attitude/{reviewId}/{attitude}")
	public ResponseEntity<String> addAttitudeFromUser(@PathVariable int reviewId,@PathVariable String attitude){
		
		String addUserAttitude = rs.addAttitudeToReview(attitude, reviewId);
		
		return new ResponseEntity<String>(addUserAttitude, HttpStatus.OK);
	}
	
	/* This end point expecting a request with two path variable: 
	 * 1) The reviewId to make decision on.
	 * 2) The decision between Approved or denied.
	 * Then return a String that indicate if the decision has been updated.
	*/
	@GetMapping(value="/decision/{reviewId}/{decision}")
	public ResponseEntity<String> decisionOnPendingReview(@PathVariable int reviewId,@PathVariable String decision){
		
		String decisionResult = rs.decisionOnPendingReview(reviewId, decision);
		
		return new ResponseEntity<String>(decisionResult, HttpStatus.OK);
	}

}
