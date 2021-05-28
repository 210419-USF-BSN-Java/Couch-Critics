package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Discussion;

@Repository
public interface DiscussionDao {
	
	public List<Discussion> getDiscussionByUserId(int userID);
	
	public List<Discussion> getDiscussionByUserId();
	
	public List<Discussion> getDiscussionByReview();
	
	public boolean addDiscussion(Discussion d);
	
	public boolean deleteDiscussion(int discussionId);
}
