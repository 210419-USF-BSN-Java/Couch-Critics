package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
	@Query("FROM Users WHERE userName=?1")
	public Users getPassWordAndSalt(String username);

	//public List<Users> getUserByRole(String role);

	public List<Users> getUserByRoleId(int i);
	
}
