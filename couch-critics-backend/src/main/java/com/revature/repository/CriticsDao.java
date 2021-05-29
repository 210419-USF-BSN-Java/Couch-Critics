package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Reviews;
import com.revature.model.Users;

public interface CriticsDao extends JpaRepository<Users, Integer>{
	
	//public List<Reviews> getReviewsById(int criticID);
	//done by findById
	
	public List<Reviews> getReviewsByReviewStatus(String reviewStatus);
	
	//public boolean addReview(Reviews r);
	//done by save()
	
	//public boolean deleteReview(int reviewID);
	//done by delete()
	
	
}
