package com.revature.controllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.controller.UsersController;
import com.revature.model.Users;
import com.revature.service.UsersService;

/*
 * Author: Robbie
 */
public class UserControllerTest {
	
	@Mock
	private UsersService uService = Mockito.mock(UsersService.class);
	
	@InjectMocks
	UsersController uController = new UsersController(uService);
	
	@Test
	public void registerUserTest() {
		Users u = new Users();
		Mockito.when(uService.registUserAccount(u)).thenReturn("success!");
		
		assertEquals(new ResponseEntity<String>("success!", HttpStatus.OK), uController.registerUser(u));
		
	}//passed
	
	@Test
	public void updateUserTest() {
		Users u = new Users();
		Mockito.when(uService.updateUserAccount(u)).thenReturn("success!");
		
		assertEquals(new ResponseEntity<String>("success!", HttpStatus.OK), uController.updateUser(u));
		
	}//passed
	
	@Test
	public void loginUserTest() {
		String uName = "rob";
		String pWord = "wee";
		Users u = new Users(10,"Robbie", "Weeks", "rob", "wee", "xlstc110@gmail.com", "salt", null, null);
		Mockito.when(uService.getUserByUnameAndPword(uName, pWord)).thenReturn(u);
		
		assertEquals(new ResponseEntity<Users>(u, HttpStatus.OK), uController.loginUser(uName, pWord));
		
	}//passed
	
	
	
}
