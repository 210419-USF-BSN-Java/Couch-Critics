package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Component
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Reviews {
	@Id
	@GeneratedValue
	private int reviewId;
	@Column
	private String review;
	@Column
	private String reviewStatus;
	@Column
	private Date submit;
	@Column
	private String likes;
	@Column
	private String dislikes;
	@Column
	private int movieId;
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

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", review=" + review + ", reviewStatus=" + reviewStatus + ", submit="
				+ submit + ", likes=" + likes + ", dislikes=" + dislikes + ", movieId=" + movieId + ", movieName="
				+ movieName + ", authorId=" + authorId + ", managerId=" + managerId + "]";
	}

	
	
}
