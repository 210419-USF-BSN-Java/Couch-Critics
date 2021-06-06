package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Reviews;

/*
 * Author: Robbie
 */
@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer>{
	
	public List<Reviews> getReviewsByauthorIdUserid(int authorIdUserid);
	
	public List<Reviews> getReviewsByMovieName(String movieName);

	public List<Reviews> getReviewsByReviewStatus(String reviewStatus);
	
	public List<Reviews> getReviewsByAuthorIdUseridAndReviewStatus(int authorId, String reviewStatus);
	
	@Transactional
	@Modifying
	@Query("UPDATE Reviews r SET r.likes = r.likes + 1 WHERE r.reviewId=?1")
	public void addLikeToReview(int reviewId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Reviews r SET r.dislikes = r.dislikes + 1 WHERE reviewId=:reviewId")
	public void addDislikeToReview(int reviewId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Reviews r SET r.reviewStatus =:decision WHERE reviewId=:reviewId")
	public void decisionOnPendingReview(int reviewId, String decision);
	
	
}
