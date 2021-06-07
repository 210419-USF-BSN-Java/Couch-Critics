package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.AccStatus;
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
		try{
			//retrieve the hashed password and associated salt of this user name.
			u = ur.getPassWordAndSalt(uName);
			
			if(u == null) {
				//incorrect username, return null.
				return null;
			}
			
		} catch (Exception e){
			System.out.println(e);
			return null;
		}
		
		boolean verifyResult = salt.verifyHashedPass(pWord, u.getPassword(), u.getSalt());
		if(verifyResult) {
			//credential matched, clear previous attempts count and return Users object.
			ur.clearAttemptsById(u.getUserid());
			return u;
		} else {
			//username exist but incorrect password, failed login attempts +1.
			ur.addFailedLoginAttemp(u.getUserid());
			
			int attempsTotal = ur.getAttempsByuserid(u.getUserid());
			//when login attempts failed reaches 10, deactivate this user account.
			if (attempsTotal >= 10) {
				AccStatus deactivate = new AccStatus(3, "Deactivated");
				ur.changeAccountStatus(u.getUserid(), deactivate);
			}
		}
		return null;
	}
	
	public String setUserAccountStatus(int userid, String status) {
		
		try {
			AccStatus activate = null;
			if(status.equals("Activate")) {
				activate = new AccStatus(2, "Activated");
			} else if(status.equals("Deactivate")) {
				activate = new AccStatus(3, "Deactivated");
			} else {
				return "Invalid status input.";
			}
			
			ur.changeAccountStatus(userid, activate);
			return "Successfully set user account status to: " + status;
			
		} catch(Exception e) {
			System.out.println(e);
			return "Failed to set user account status to: " + status;
		}

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
