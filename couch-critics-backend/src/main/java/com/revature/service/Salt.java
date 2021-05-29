package com.revature.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Salt {
	
	
	public String[] saltHashing(String password) {
		//to be returned
		String[] result = new String[2];
		
		String hashedPass = "";
		
		//generate a random salt String with UUID.
		String salt = UUID.randomUUID().toString();
		
		//Concat password and salt String.
		String passSalt = password + salt; 
		
		try {
			//convert passSalt's characters into byte code array.
			byte[] bytePassWord = passSalt.getBytes();
			
			//Specify the digest algorithm verson, 1, 256, 312, or 512.
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			//hash the binary password.
			byte[] hashedBytePass = md.digest(bytePassWord);
			
			//convert each character in byte array into a String using StringBuilder append function.
			StringBuilder build = new StringBuilder();
			for(int i=0; i< hashedBytePass.length ;i++) {
				build.append(Integer.toString((hashedBytePass[i] & 0xff) + 0x100, 16).substring(1));        
	        }
			
			//convert the StringBuilder type to String.
			hashedPass = new String(build);
			
			//the records to be store in database for later verification.
			result[0] = hashedPass;
			result[1] = salt;
			
		} catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean verifyHashedPass(String password, String hashedPassword, String salt) {
		
		String hashedInput = "";
		String saltedPassword = password + salt;
		
		try {
			//convert passSalt's characters into byte code array.
			byte[] bytePassWord = saltedPassword.getBytes();
			
			//Specify the digest algorithm verson, 1, 256, 312, or 512.
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			//hash the binary password.
			byte[] hashedBytePass = md.digest(bytePassWord);
			
			//convert each character in byte array into a String using StringBuilder append function.
			StringBuilder build = new StringBuilder();
			for(int i=0; i< hashedBytePass.length ;i++) {
				build.append(Integer.toString((hashedBytePass[i] & 0xff) + 0x100, 16).substring(1));         
	        }
			
			//convert the StringBuilder type to String.
			hashedInput = new String(build);

			
		} catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		if(hashedInput.equals(hashedPassword)) {
			//the user input's hashed password matches the database password.
			return true;
		} else {
			//failed to match to password.
			return false;
		}
	}
	
}
