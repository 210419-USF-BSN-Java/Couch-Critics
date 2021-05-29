package com.revature.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Reviews {
	private int reviewId;
	private String review;
	private String reviewStatus;
	private Date submit;
	private String likes;
	private String dislikes;
	private int movieId;
	private String movieName;
	@Autowired
	private Users authorId;
	@Autowired
	private Users managerId;
	
	public Reviews(int reviewId, String review, String reviewstatus, Date submit, String likes, String dislikes,
			int movieId, String movieName, Users authorId, Users managerId) {
		super();
		this.reviewId = reviewId;
		this.review = review;
		this.reviewStatus = reviewstatus;
		this.submit = submit;
		this.likes = likes;
		this.dislikes = dislikes;
		this.movieId = movieId;
		this.movieName = movieName;
		this.authorId = authorId;
		this.managerId = managerId;
	}

	
}
