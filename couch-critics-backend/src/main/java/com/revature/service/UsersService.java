package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Role;
import com.revature.model.Users;
import com.revature.repository.UsersRepository;

import java.time.Clock;

@Service
public class UsersService {

	private UsersRepository ur;
	private Salt salt;
	
	public UsersService() {
		
	}
	
	@Autowired
	public UsersService(UsersRepository ur, Salt salt) {
		
		this.ur = ur;
		this.salt = salt;
		
	}
	
	/*
	   this method will have two return type: 
	    1) an Users object(JSON format) that contains the user's information base on userId.
	    2) a Null if the userId is not exist in database.
	*/
	public Users getUserById(int userId) {
		try{
			return ur.getUsersByUserid(userId);
		} catch (Exception e){
			return null;
		}	
	}
	
	/*
	   this method will have two return type: 
	    1) an Users object(JSON format) that contains the user's information.
	    2) a Null if the user name does not exist or the password is not correct.
	*/
	public Users getUserByUnameAndPword(String uName, String pWord) {
		Users u;
		System.out.println(uName);
		try{
			//retrieve the hashed password and associated salt of this user name.
			System.out.println(uName);
			u = ur.getPassWordAndSalt(uName);
			System.out.println(u);
		} catch (Exception e){
			//for front end: if u == null, incorrect user name.
			return null;
		}
		
		boolean verifyResult = salt.verifyHashedPass(pWord, u.getPassword(), u.getSalt());
		
		if(verifyResult) {
			//return Users object if the input password pass the hash verification.
			return u;
		}
		//for front end: if u == null, incorrect password.
		return null;
		
	}
	
	/*
	   this method will have two return a String that show if the registration is success.
	*/
	public String registUserAccount(Users u) {
		
		//pass in the original password to hash, and return with 1) hashed password, and 2) salt generated with this password.
		String[] hashedPassAndSalt = salt.saltHashing(u.getPassword());
		
		//set the hashed password and salt into the Users Object
		u.setPassword(hashedPassAndSalt[0]);
		u.setSalt(hashedPassAndSalt[1]);
		
		try {
			ur.save(u);
			return "registration successed.";
			
		} catch(Exception e) {
			System.out.println(e);
			return "registration failed.";
		}

	}
	
	/*
	   this method will have two return a String that show if the update is success.
	*/
	public String updateUserAccount(Users u) {
		try {
			//pass in the original password to hash, and return with 1) hashed password, and 2) salt generated with this password.
			String[] hashedPassAndSalt = salt.saltHashing(u.getPassword());
			
			//set the hashed password and salt into the Users Object
			u.setPassword(hashedPassAndSalt[0]);
			u.setSalt(hashedPassAndSalt[1]);
			
			ur.save(u);
			return "User account updated.";
			
		} catch(Exception e) {
			System.out.println(e);
			return "Failed to update user account.";
		}
	}

	public String checkUserName(String uName) {
		try {
			if(ur.getPassWordAndSalt(uName) == null) {
			
				return "Username available.";
			
			} 
			
		} catch(Exception e) {
			System.out.println(e);
			return "Failed to check username.";
		}
		return "Username already exit.";
	}

	public List<Users> getUserByRole(String role) {
		try {
			if(role.equals("employee")) {
				Role r = new Role(2);
				List<Users> u = ur.getUserByRoleId(r);
				return u;
			} else if (role.equals("customer")) {
				Role r = new Role(3);
				List<Users> u = ur.getUserByRoleId(r);
				return u;
			}
		} catch(Exception e) {
			System.out.println(e);

		}
		return null;
	}
	
}
