package com.revature.repository;

import java.util.List;

import com.revature.model.Users;


public interface UserDao {
	
	//retrieve user's information from database base on the user ID.
	public Users getUserInfo(int userId);
	
	//register an user into database with an Users Object.
	public boolean registUserAccount(Users u);
	
	//retrieve user's hashed password and Salt with an userName.
	public String[] getHashAndSalt(String userName);
	
}
