package come.revature.controllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.controller.UsersController;
import com.revature.model.Users;
import com.revature.service.UsersService;

/*
 * Author: Robbie
 */
public class UserControllerTest {
	
	@Mock
	private UsersService us = Mockito.mock(UsersService.class);
	
	@InjectMocks
	UsersController uc = new UsersController(us);
	
	@Test
	public void registerUserTest() {
		Users u = new Users();
		Mockito.when(us.registUserAccount(u)).thenReturn("success!");
		
		assertEquals("success!", us.registUserAccount(u));
		
	}//passed
	
	@Test
	public void updateUserTest() {
		Users u = new Users();
		Mockito.when(us.registUserAccount(u)).thenReturn("success!");
		
		assertEquals("success!", us.registUserAccount(u));
		
	}//passed
	
	@Test
	public void loginUserTest() {
		String uName = "rob";
		String pWord = "wee";
		Users u = new Users(10,"Robbie", "Weeks", "rob", "wee", "xlstc110@gmail.com", null, null);
		Mockito.when(us.getUserByUnameAndPword(uName, pWord)).thenReturn(u);
		
		assertEquals(u, us.getUserByUnameAndPword(uName, pWord));
		
	}//passed
	
	
	
}
