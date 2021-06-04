package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Reviews {
	@Id
	@GeneratedValue
	private Integer reviewId;
	@Column
	private String review;
	@Column
	private String reviewStatus;
	@Column
	private Date submit;
	@Column
	private Integer likes;
	@Column
	private Integer dislikes;
	@Column
	private Integer movieId;
	@Column
	private String movieName;
	@Autowired
	@ManyToOne
	private Users authorId;
	@Autowired
	@ManyToOne
	private Users managerId;
	
	public Reviews() {
		
	}

<<<<<<< HEAD
	public Reviews(int reviewId, String review, String reviewstatus, Date submit, Integer likes, Integer dislikes,
			int movieId, String movieName, Users authorId, Users managerId) {
=======
	public Reviews(Integer reviewId, String review, String reviewstatus, Date submit, String likes, String dislikes,
			Integer movieId, String movieName, Users authorId, Users managerId) {
>>>>>>> 4e8f73ee7048e2edcaf9fe69c2391af804b51898
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
	
	

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Date getSubmit() {
		return submit;
	}

	public void setSubmit(Date submit) {
		this.submit = submit;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Users getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Users authorId) {
		this.authorId = authorId;
	}

	public Users getManagerId() {
		return managerId;
	}

	public void setManagerId(Users managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", review=" + review + ", reviewStatus=" + reviewStatus + ", submit="
				+ submit + ", likes=" + likes + ", dislikes=" + dislikes + ", movieId=" + movieId + ", movieName="
				+ movieName + ", authorId=" + authorId + ", managerId=" + managerId + "]";
	}

	
	
}
