package com.revature.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Users {

	private int userid;
	private String fName;
	private String lName;
	private String uName;
	private String pWord;
	private String email;
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

	
}