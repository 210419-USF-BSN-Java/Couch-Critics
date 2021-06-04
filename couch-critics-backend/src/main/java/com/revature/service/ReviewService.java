package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Reviews;
import com.revature.repository.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository rr;
	
	@Autowired
	public ReviewService (ReviewRepository rr) {
		this.rr = rr;
	}
	
	public List<Reviews> getReviewByCriticsId(int criticsId){
		
		try{
			List<Reviews> reviews = rr.getReviewsByAuthorId(criticsId);
			return reviews;
		} catch (Exception e){
			//implements more exceptions: one for out of index.
			return null;
		}
		
	}

	public List<Reviews> getReviewByMovieName(String movieName) {

		try{
			List<Reviews> reviews = rr.getReviewsByMovieName(movieName);
			return reviews;
		} catch (Exception e){
			//implements more exceptions: movie name does not exist any reviews.
			return null;
		}
	}

	public String addReview(Reviews r) {
		
		try{
			if(rr.save(r) != null) {
				return "Successfully added a review";
			}
			
		} catch (Exception e){
			//implements more exceptions: movie name does not exist any reviews.
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
			//implements more exceptions.
			return "Failed to delete a review";
		}

	}

	public List<Reviews> getReviewByReviewStatus(String status) {
		
		try{
			List<Reviews> reviews = rr.getReviewsByReviewStatus(status);
			return reviews;
		} catch (Exception e){
			//implements more exceptions: movie name does not exist any reviews.
			return null;
		}
	}
}
