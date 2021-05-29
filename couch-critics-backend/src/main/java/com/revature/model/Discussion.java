package com.revature.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Discussion {
	@Id
	@GeneratedValue
	private int discId;
	@Column
	@Autowired
	private Users user;
	@Column
	@Autowired
	private Reviews review;
	@Column
	private String content;
	
	public Discussion() {
		
	}
	
	public Discussion(int discId, Users user, Reviews review) {
		super();
		this.discId = discId;
		this.user = user;
		this.review = review;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discId;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public int getDiscId() {
		return discId;
	}

	public void setDiscId(int discId) {
		this.discId = discId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Reviews getReview() {
		return review;
	}

	public void setReview(Reviews review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Discussion [discId=" + discId + ", user=" + user + ", review=" + review + "]";
	}
	

	
}