package com.revature.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Reviews {
	private int reviewId;
	private String review;
	private String Reviewstatus;
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
		Reviewstatus = reviewstatus;
		this.submit = submit;
		this.likes = likes;
		this.dislikes = dislikes;
		this.movieId = movieId;
		this.movieName = movieName;
		this.authorId = authorId;
		this.managerId = managerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reviewstatus == null) ? 0 : Reviewstatus.hashCode());
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((dislikes == null) ? 0 : dislikes.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + reviewId;
		result = prime * result + ((submit == null) ? 0 : submit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reviews other = (Reviews) obj;
		if (Reviewstatus == null) {
			if (other.Reviewstatus != null)
				return false;
		} else if (!Reviewstatus.equals(other.Reviewstatus))
			return false;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (dislikes == null) {
			if (other.dislikes != null)
				return false;
		} else if (!dislikes.equals(other.dislikes))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (reviewId != other.reviewId)
			return false;
		if (submit == null) {
			if (other.submit != null)
				return false;
		} else if (!submit.equals(other.submit))
			return false;
		return true;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewstatus() {
		return Reviewstatus;
	}

	public void setReviewstatus(String reviewstatus) {
		Reviewstatus = reviewstatus;
	}

	public Date getSubmit() {
		return submit;
	}

	public void setSubmit(Date submit) {
		this.submit = submit;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getDislikes() {
		return dislikes;
	}

	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
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
		return "Reviews [reviewId=" + reviewId + ", review=" + review + ", Reviewstatus=" + Reviewstatus + ", submit="
				+ submit + ", likes=" + likes + ", dislikes=" + dislikes + ", movieId=" + movieId + ", movieName="
				+ movieName + ", authorId=" + authorId + ", managerId=" + managerId + "]";
	}
	
	

	
}
