package com.revature.controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.controller.ReviewController;
import com.revature.model.Reviews;
import com.revature.service.ReviewService;

/*
 * Author: Robbie
 */
public class ReviewControllerTest {

	@Mock
	private ReviewService rService = Mockito.mock(ReviewService.class);
	
	@InjectMocks
	ReviewController rController = new ReviewController(rService);
	
	List<Reviews> reviews = new ArrayList<>();
	Reviews r = new Reviews(4, "good", "approved", null, 20, 10, 3, "Avengers 3", null, null);
	
	
	
	@Test
	public void getReviewByCriticsIdTest() {
		int id = 5;
		reviews.add(r);
		
		Mockito.when(rService.getReviewByCriticsId(id)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rController.getReviewByCriticsId(id));
		
	}//passed
	
	@Test
	public void getReviewByMovieNameTest() {
		String movieName = "Avengers 3";
		reviews.add(r);
		
		Mockito.when(rService.getReviewByMovieName(movieName)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rController.getReviewByMovieName(movieName));
		
	}//passed
	
	@Test
	public void viewByReviewStatusTest() {
		String status = "Pending";
		reviews.add(r);
		
		Mockito.when(rService.getReviewByReviewStatus(status)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rController.viewByReviewStatus(status));
		
	}//passed
	
	
	@Test
	public void addReviewTest() {
		
		Mockito.when(rService.addReview(r)).thenReturn("success");
		
		assertEquals(new ResponseEntity<String>("success", HttpStatus.OK), rController.addReview(r));
		
	}//passed
	
	@Test
	public void deleteReview() {
		int id = 5;
		
		Mockito.when(rService.deleteReview(id)).thenReturn("success");
		
		assertEquals(new ResponseEntity<String>("success", HttpStatus.OK), rController.deleteReview(id));
		
	}//passed
	
	public void viewByIdAndStatusTest() {
		int id = 5;
		String status = "Pending";
		reviews.add(r);
		
		Mockito.when(rService.getReviewByIdAndStatus(id,status)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rController.viewByReviewStatus(status));
		
	}//passed
	
	public void addAttitudeFromUserTest() {
		int reviewId = 4;
		String attitude = "like";
		reviews.add(r);
		
		Mockito.when(rService.addAttitudeToReview(attitude, reviewId)).thenReturn("Successfully added attitude.");
		
		assertEquals(new ResponseEntity<String>("Successfully added attitute.", HttpStatus.OK), rController.addAttitudeFromUser(reviewId, attitude));
		
	}//passed
}
