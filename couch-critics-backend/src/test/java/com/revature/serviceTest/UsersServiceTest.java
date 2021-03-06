package com.revature.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.model.AccStatus;
import com.revature.model.Role;
import com.revature.model.Users;
import com.revature.repository.UsersRepository;
import com.revature.service.Salt;
import com.revature.service.UsersService;

/*
 * Author: Robbie
 */
public class UsersServiceTest {
	
	@Mock
	private UsersRepository uRepo = Mockito.mock(UsersRepository.class);
	
	@Mock
	private Salt salt = Mockito.mock(Salt.class);
	
	@InjectMocks
	private UsersService uService = new UsersService(uRepo, salt);
	
	Users u = new Users(10,"Robbie", "Weeks", "rob", "wee", "xlstc110@gmail.com", null, null, new AccStatus(2, "Activated"));
	
	@Test
	public void getUserByIdTest() {
		
		int userId = 10;
		
		Mockito.when(uRepo.getUsersByUserid(userId)).thenReturn(u);
		
		assertEquals(u, uService.getUserById(userId));
		
	}//passed
	
	@Test
	public void getUserByUnameAndPwordTest() {
		
		String uName = "Rob";
		String pWord = "Wee";
		
		Mockito.when(uRepo.getPassWordAndSalt(uName)).thenReturn(u);

		Mockito.when(salt.verifyHashedPass(pWord, u.getPassword(), u.getSalt())).thenReturn(true);
		
		assertEquals(u, uService.getUserByUnameAndPword(uName, pWord));
		
	}//passed
	
	@Test
	public void registUserAccountTest() {

		String[] hashedPassAndSalt = {"a9as7asd7", "as6s78s*&"};
		
		Mockito.when(salt.saltHashing(u.getPassword())).thenReturn(hashedPassAndSalt);

		Mockito.when(uRepo.save(u)).thenReturn(u);
		
		assertEquals("registration successed.", uService.registUserAccount(u));
		
	}//passed
	
	@Test
	public void updateUserAccountTest() {
		
		String[] hashedPassAndSalt = {"a9as7asd7", "as6s78s*&"};
		
		Mockito.when(salt.saltHashing(u.getPassword())).thenReturn(hashedPassAndSalt);
		Mockito.when(uRepo.save(u)).thenReturn(u);
		
		assertEquals("User account updated.", uService.updateUserAccount(u));
		
	}//passed
	
	@Test
	public void checkUserNameTest() {
		String uName = "rob";
		
		Mockito.when(uRepo.getPassWordAndSalt(uName)).thenReturn(null);
		
		assertEquals("Username available.", uService.checkUserName(uName));
		
		Mockito.when(uRepo.getPassWordAndSalt(uName)).thenReturn(u);
		
		assertEquals("Username already exit.", uService.checkUserName(uName));
		
	}//passed
	
	@Test
	public void getUserByRoleTest() {
		String role = "employee";
		Role r = new Role(2);
		List<Users> u = new ArrayList<>();
		
		Mockito.when(uRepo.getUserByRoleId(r)).thenReturn(u);
		
		assertEquals(u, uService.getUserByRole(role));

		
	}//passed
}
