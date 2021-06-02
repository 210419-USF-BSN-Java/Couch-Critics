package come.revature.controllerTest;

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
	private ReviewService rs = Mockito.mock(ReviewService.class);
	
	@InjectMocks
	ReviewController rc = new ReviewController(rs);
	
	List<Reviews> reviews = new ArrayList<>();
	Reviews r = new Reviews(4, "good", "approved", null, "20", "10", 3, "Avengers 3", null, null);
	
	
	
	@Test
	public void getReviewByCriticsIdTest() {
		int id = 5;
		reviews.add(r);
		
		Mockito.when(rs.getReviewByCriticsId(id)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rc.getReviewByCriticsId(id));
		
	}//passed
	
	@Test
	public void getReviewByMovieNameTest() {
		String movieName = "Avengers 3";
		reviews.add(r);
		
		Mockito.when(rs.getReviewByMovieName(movieName)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rc.getReviewByMovieName(movieName));
		
	}//passed
	
	@Test
	public void viewByReviewStatusTest() {
		String status = "Pending";
		reviews.add(r);
		
		Mockito.when(rs.getReviewByReviewStatus(status)).thenReturn(reviews);
		
		assertEquals(new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK), rc.viewByReviewStatus(status));
		
	}//passed
	
	
	@Test
	public void addReviewTest() {
		
		Mockito.when(rs.addReview(r)).thenReturn("success");
		
		assertEquals(new ResponseEntity<String>("success", HttpStatus.OK), rc.addReview(r));
		
	}//passed
	
	@Test
	public void deleteReview() {
		int id = 5;
		
		Mockito.when(rs.deleteReview(id)).thenReturn("success");
		
		assertEquals(new ResponseEntity<String>("success", HttpStatus.OK), rc.deleteReview(id));
		
	}//passed
}
