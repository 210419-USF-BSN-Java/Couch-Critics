package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Reviews;
import com.revature.repository.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository rr;
	

	public ReviewService () {
		
	}
	
	@Autowired
	public ReviewService (ReviewRepository rr) {
		this.rr = rr;
	}
	
	public List<Reviews> getReviewByCriticsId(int criticsId){
		
		try{
			List<Reviews> reviews = rr.getReviewsByauthorIdUserid(criticsId);
			return reviews;
		} catch (Exception e){
			System.out.println(e);
			return null;
		}
		
	}

	public List<Reviews> getReviewByMovieName(String movieName) {

		try{
			List<Reviews> reviews = rr.getReviewsByMovieName(movieName);
			return reviews;
		} catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	public String addReview(Reviews r) {
		
		try{
			if(rr.save(r) != null) {
				return "Successfully added a review";
			}
			
		} catch (Exception e){
			System.out.println(e);
			return "Failed to add a review";
		}
		return null;
	}

	public String deleteReview(int id) {
		try{
			
			rr.deleteById(id);
			return "Successfully deleted a review";
			
		} catch (Exception e){
			System.out.println(e);
			return "Failed to delete a review";
		}

	}

	public List<Reviews> getReviewByReviewStatus(String status) {
		
		try{
			List<Reviews> reviews = rr.getReviewsByReviewStatus(status);
			return reviews;
		} catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	public String addAttitudeToReview(String attitude, int reviewId) {
		
		try{
			if(attitude.equals("like")) {
				rr.addLikeToReview(reviewId);
				
			} else if (attitude.equals("dislike")) {
				rr.addDislikeToReview(reviewId);
			} else {
				return "Invalid attitude.";
			}

			return "Successfully added attitude.";
		} catch (Exception e){
			System.out.println(e);
			return "Failed to add attitude to review";
		}

	}

	public List<Reviews> getReviewByIdAndStatus(int id, String status) {
		
		try{
			List<Reviews> reviews = rr.getReviewsByAuthorIdUseridAndReviewStatus(id, status);
			return reviews;
		} catch (Exception e){
			System.out.println(e);
			return null;
		}

	}

	public String decisionOnPendingReview(int reviewId, String decision) {
		try{
			rr.decisionOnPendingReview(reviewId, decision);
			return "Review status has been changed to:" + decision;
		} catch (Exception e){
			System.out.println(e);
			return "Failed to update review status.";
		}

	}
}
