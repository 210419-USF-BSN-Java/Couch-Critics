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
	private String fName;
	@Column
	private String lName;
	@Column(unique=true, nullable=false)
	private String uName;
	@Column(nullable=false)
	private String pWord;
	@Column
	private String email;
	private String salt;
	@Autowired
	@ManyToOne
	private Role roleId;//role_Id

	@Autowired
	@ManyToOne
	private AccStatus statusid;
	
	public Users() {
		
	}
	
	public Users(int userid, String fName, String lName, String uName, String pWord, String email, Role roleId,
			AccStatus statusid) {
		super();
		this.userid = userid;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.pWord = pWord;
		this.email = email;
		this.roleId = roleId;
		this.statusid = statusid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getroleId() {
		return roleId;
	}

	public void setroleId(Role roleId) {
		this.roleId = roleId;
	}

	public AccStatus getStatusid() {
		return statusid;
	}

	public void setStatusid(AccStatus statusid) {
		this.statusid = statusid;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", pWord="
				+ pWord + ", email=" + email + ", salt=" + salt + ", roleId=" + roleId + ", statusid=" + statusid + "]";
	}

	
	
}