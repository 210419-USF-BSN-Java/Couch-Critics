package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Discussion;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer>{
	
	public List<Discussion> getDiscussionByUserIdUserid(int userId);
	
	public List<Discussion> getDiscussionByReviewIdReviewId(int reviewId);
	//.getById from JpaRepository
	//public Discussion getDiscussionById(int id);
	
	//.save from JpaRepository
	//public boolean addDiscussion(Discussion d);
	
	//.deleteById from JpaRepository
	//public boolean deleteDiscussionById(int id);
}
