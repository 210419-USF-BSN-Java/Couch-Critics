package com.revature.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.model.Reviews;
import com.revature.repository.ReviewRepository;
import com.revature.service.ReviewService;

/*
 * Author: Robbie
 */
public class ReveiwServiceTest {

	@Mock
	private ReviewRepository rRepo = Mockito.mock(ReviewRepository.class);
	
	@InjectMocks
	private ReviewService rService = new ReviewService(rRepo);
	
	static List<Reviews> reviews = new ArrayList<>();
	
	@BeforeClass
	public static void setUp() {
		
		reviews.add(new Reviews(3, "below average", "approved", null, 2, 1, 55,"Avengers 4", null, null));
		
	}
	
	@Test
	public void getReviewByCriticsIdTest() {
		int criticsId = 5;
		
		Mockito.when(rRepo.getReviewsByauthorIdUserid(criticsId)).thenReturn(reviews);
		
		assertEquals(reviews, rService.getReviewByCriticsId(criticsId));
		
	}//passed
	
	@Test
	public void getReviewByMovieNameTest() {
		String movieName = "Avengers 4";
		
		Mockito.when(rRepo.getReviewsByMovieName(movieName)).thenReturn(reviews);
		
		assertEquals(reviews, rService.getReviewByMovieName(movieName));
		
	}//passed
	
	@Test
	public void addReviewTest() {
		Reviews r = new Reviews();
		
		Mockito.when(rRepo.save(r)).thenReturn(r);
		
		assertEquals("Successfully added a review", rService.addReview(r));
		
	}//passed
	
	@Test
	public void deleteReviewTest() {
		int id = 5;
		doNothing().when(rRepo).deleteById(id);

		assertEquals("Successfully deleted a review", rService.deleteReview(id));
		
	}//passed
	
	@Test
	public void getReviewByReviewStatusTest() {
		String status = "Pending";
		
		Mockito.when(rRepo.getReviewsByReviewStatus(status)).thenReturn(reviews);
		
		assertEquals(reviews, rService.getReviewByReviewStatus(status));
		
	}//passed
	
}
