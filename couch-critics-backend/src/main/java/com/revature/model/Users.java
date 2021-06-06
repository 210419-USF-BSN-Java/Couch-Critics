package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int userid;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column
	private String email;
	private String salt;
	private Integer attemps = 0;
	
	@Autowired
	@ManyToOne
	private Role roleId;//role_Id

	@Autowired
	@ManyToOne
	private AccStatus statusid;
	
	public Users() {
		
	}
	
	

	public Users(int userid, String firstName, String lastName, String username, String password, String email,
			String salt, Role roleId, AccStatus statusid) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.salt = salt;
		this.roleId = roleId;
		this.statusid = statusid;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public AccStatus getStatusid() {
		return statusid;
	}

	public void setStatusid(AccStatus statusid) {
		this.statusid = statusid;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", salt=" + salt + ", roleId=" + roleId
				+ ", statusid=" + statusid + "]";
	}



	public Integer getAttemps() {
		return attemps;
	}



	public void setAttemps(Integer attemps) {
		this.attemps = attemps;
	}

	
	
	
}