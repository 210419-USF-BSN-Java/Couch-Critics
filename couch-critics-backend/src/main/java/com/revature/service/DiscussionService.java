package com.revature.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Discussion;
import com.revature.repository.DiscussionRepository;

@Service
public class DiscussionService {
	private DiscussionRepository dRepo;

	public DiscussionService() {
		
		
	}
	
	@Autowired
	public DiscussionService(DiscussionRepository dRepo) {
		this.dRepo = dRepo;
		
	}
	
	public List<Discussion> getDiscussionByUserId(int userId){
		List<Discussion> discList = new LinkedList<>();
		try {	
			discList = dRepo.getDiscussionByUserId(userId);
		}catch(Exception e) {
			
		}
		return discList;
	}
	
	public List<Discussion> getDiscussionByReviewId(int reviewId){
		List<Discussion> discList = new LinkedList<>();
		try {	
			discList = dRepo.getDiscussionByReviewId(reviewId);
		}catch(Exception e) {
			
		}
		return discList;
	}
	
	public Discussion getDiscussionByDiscussionId(int id){
		Discussion disc = null;
		try {	
			disc = dRepo.getById(id);
		}catch(Exception e) {
			
		}
		return disc;
	}
	
	public boolean addDiscussion(Discussion d) {
		boolean success = false;
		
		try {
			dRepo.save(d);
			success = true;
		}catch(Exception e) {
			
		}
		return success;
	}
	
	public boolean deleteDiscussion(int id) {
		boolean success = false;
		
		try {
			dRepo.deleteById(id);
			success = true;
		}catch(Exception e) {
			
		}
		return success;
	}
	
}
