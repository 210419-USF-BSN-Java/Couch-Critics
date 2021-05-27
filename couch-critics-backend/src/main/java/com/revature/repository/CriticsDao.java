package com.revature.repository;

import java.util.List;

import com.revature.model.Reviews;

public interface CriticsDao {
	
	public List<Reviews> getReviewsByCriticId(int criticID);
	
	public List<Reviews> getPendingReviews();
	
	public List<Reviews> getApprovedReviews();
	
	public boolean addReview(Reviews r);
	
	public boolean deleteReview(int reviewID);
	
	
}
