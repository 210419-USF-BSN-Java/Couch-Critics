package com.revature.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
public class Users {
	
	private int userid;
	private String fName;
	private String lName;
	private String uName;
	private String pWord;
	private String email;
	private String salt;
	@Autowired
	private Role roleid;
	@Autowired
	private AccStatus statusid;
	
	public Users(int userid, String fName, String lName, String uName, String pWord, String email, Role roleid,
			AccStatus statusid) {
		super();
		this.userid = userid;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.pWord = pWord;
		this.email = email;
		this.roleid = roleid;
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

	public Role getRoleid() {
		return roleid;
	}

	public void setRoleid(Role roleid) {
		this.roleid = roleid;
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
				+ pWord + ", email=" + email + ", salt=" + salt + ", roleid=" + roleid + ", statusid=" + statusid + "]";
	}

	
	
}