package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Reviews;

/*
 * Author: Robbie
 */
@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer>{
	
	public List<Reviews> getReviewsByAuthorId(int authorId);
	
	public List<Reviews> getReviewsByMovieName(String movieName);

	public List<Reviews> getReviewsByReviewStatus(String reviewStatus);
	
	
	//public List<Reviews> getReviewsById(int criticID);
	//done by findById
	
	//public List<Reviews> getReviewsByReviewStatus(String reviewStatus);
	
	//public boolean addReview(Reviews r);
	//done by save()
	
	//public boolean deleteReview(int reviewID);
	//done by delete()
	
}
