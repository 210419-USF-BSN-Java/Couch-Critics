package com.revature.service;

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
	
	public List<Discussion> getDiscussionsByUserId(int userId){
		try {	
			return dRepo.getDiscussionByUserIdUserid(userId);
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<Discussion> getDiscussionsByReviewId(int reviewId){
		try {	
			return dRepo.getDiscussionByReviewIdReviewId(reviewId);
		}catch(Exception e) {
			return null;
		}
	}
	
	public Discussion getDiscussionByDiscussionId(int id){
		try {	
			return dRepo.getById(id);
			//disc = dRepo.getDiscussionById(id);
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean addDiscussion(Discussion d) {
		try {
			System.out.println(dRepo.save(d));
			//dRepo.addDiscussion(d);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean deleteDiscussion(int id) {
		try {
			dRepo.deleteById(id);
			//dRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
