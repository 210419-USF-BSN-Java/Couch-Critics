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

	public Discussion(int discId, Users userId, Reviews reviewId, String content) {
		super();
		this.discId = discId;
		this.userId = userId;
		this.reviewId = reviewId;
		this.content = content;
	}

	public int getDiscId() {
		return discId;
	}

	public void setDiscId(int discId) {
		this.discId = discId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Reviews getReviewId() {
		return reviewId;
	}

	public void setReviewId(Reviews reviewId) {
		this.reviewId = reviewId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
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

	@Override
	public String toString() {
		return "Discussion [discId=" + discId + ", userId=" + userId + ", reviewId=" + reviewId + ", content=" + content
				+ "]";
	}
	
	

}