package com.revature.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

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
	
	Users u = new Users(10,"Robbie", "Weeks", "rob", "wee", "xlstc110@gmail.com", null, null, null);
	
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
		
		Mockito.when(uRepo.save(u)).thenReturn(u);
		
		assertEquals("User account updated.", uService.updateUserAccount(u));
		
	}//passed
}
