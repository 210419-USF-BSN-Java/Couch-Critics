package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Discussion {

	@Id
	@GeneratedValue
	private int discId;
	@ManyToOne
	@Autowired
	private Users userId;
	@Autowired
	@ManyToOne
	private Reviews reviewId;
	@Column
	private String content;
	
	public Discussion() {
		
	}

	public Discussion(int discId, Users user, Reviews review) {

		super();
		this.discId = discId;
		this.userId = user;
		this.reviewId = review;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discId;
		result = prime * result + ((reviewId == null) ? 0 : reviewId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Discussion other = (Discussion) obj;
		if (discId != other.discId)
			return false;
		if (reviewId == null) {
			if (other.reviewId != null)
				return false;
		} else if (!reviewId.equals(other.reviewId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public int getDiscId() {
		return discId;
	}

	public void setDiscId(int id) {
		this.discId = id;
	}

	public Users getUser() {
		return userId;
	}

	public void setUser(Users user) {
		this.userId = user;
	}

	public Reviews getReview() {
		return reviewId;
	}

	public void setReview(Reviews review) {
		this.reviewId = review;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + discId + ", user=" + userId + ", review=" + reviewId + "]";
	}

}