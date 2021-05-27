package com.revature.repository;

import java.util.List;

import com.revature.model.Discussion;

public interface DescussionDao {
	
	public List<Discussion> getDiscussionByUserId(int userID);
	
	public List<Discussion> getDiscussionByUserId();
	
	public List<Discussion> getDiscussionByReview();
	
	public boolean addDiscussion(Discussion d);
	
	public boolean deleteDiscussion(int discussionId);
}
