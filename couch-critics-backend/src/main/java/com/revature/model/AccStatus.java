package com.revature.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class AccStatus {
	@Id
	@GeneratedValue
	private int accStatusId;
	@Column
	private String accStatus;
	
	public AccStatus() {
		
	}
	
	public AccStatus(int accStatusId, String accStatus) {
		super();
		this.accStatusId = accStatusId;
		this.accStatus = accStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accStatus == null) ? 0 : accStatus.hashCode());
		result = prime * result + accStatusId;
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
		AccStatus other = (AccStatus) obj;
		if (accStatus == null) {
			if (other.accStatus != null)
				return false;
		} else if (!accStatus.equals(other.accStatus))
			return false;
		if (accStatusId != other.accStatusId)
			return false;
		return true;
	}

	public int getAccStatusId() {
		return accStatusId;
	}

	public void setAccStatusId(int accStatusId) {
		this.accStatusId = accStatusId;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	@Override
	public String toString() {
		return "accStatus [accStatusId=" + accStatusId + ", accStatus=" + accStatus + "]";
	}
	
	
}
