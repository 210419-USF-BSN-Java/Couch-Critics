package com.revature.model;

import org.springframework.stereotype.Component;

@Component
public class Role {
	private int RoleId;
	private String Role;
	
	public Role(int RoleId, String Role) {
		super();
		this.RoleId = RoleId;
		this.Role = Role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Role == null) ? 0 : Role.hashCode());
		result = prime * result + RoleId;
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
		Role other = (Role) obj;
		if (Role == null) {
			if (other.Role != null)
				return false;
		} else if (!Role.equals(other.Role))
			return false;
		if (RoleId != other.RoleId)
			return false;
		return true;
	}

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int RoleId) {
		this.RoleId = RoleId;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}

	@Override
	public String toString() {
		return "Role [RoleId=" + RoleId + ", Role=" + Role + "]";
	}

	
}
