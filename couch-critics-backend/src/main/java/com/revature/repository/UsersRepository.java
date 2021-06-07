package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.AccStatus;
import com.revature.model.Role;
import com.revature.model.Users;

/*
 * Author: Robbie
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	//retrieve user's information from database base on the user ID.
	public Users getUsersByUserid(int userId);

	//public boolean registUserAccount(Users u);
	public Users findUsersByusername(String username);
	
	//retrieve user's information from database base on the userName.

	@Query("FROM Users WHERE username=?1")

	public Users getPassWordAndSalt(String username);

	//public List<Users> getUserByRole(String role);

	public List<Users> getUserByRoleId(Role r);
	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.attemps = u.attemps + 1 WHERE u.userid=:userId")
	public void addFailedLoginAttemp(int userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.statusid =:statusId WHERE u.userid=:userId")
	public void changeAccountStatus(int userId, AccStatus statusId);
	
	@Query("Select attemps FROM Users WHERE userid=?1")
	public int getAttempsByuserid(int userid);
	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.attemps = 0 WHERE u.userid=:userid")
	public void clearAttemptsById(int userid);
	
}
