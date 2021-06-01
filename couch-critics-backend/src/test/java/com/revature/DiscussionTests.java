package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Discussion;
import com.revature.model.Users;
import com.revature.repository.DiscussionRepository;
import com.revature.service.DiscussionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscussionTests {
	@Autowired
	@Mock
	private DiscussionRepository dRepo;
	
	private DiscussionService dServ;
	
	@Before
	public void init() {
		dServ = new DiscussionService(dRepo);
	}
	
	@Test
	public void testAddDiscussion() {
		Discussion d = new Discussion(0, null, null, "Hello Add");
		
		assertTrue(dServ.addDiscussion(d));	
	}
	
	@Test
	public void testDeleteDiscussion() {
		Discussion d = new Discussion(1, null, null, "Hello Delete");
		
		dServ.addDiscussion(d);
		assertTrue(dServ.deleteDiscussion(d.getDiscId()));	
	}
	
	@Test
	public void testGetDiscussionById() {
		Discussion d = new Discussion(2, null, null, "Hello Get By Id");
		
		dServ.addDiscussion(d);
		assertEquals(dServ.getDiscussionByDiscussionId(d.getDiscId()).getDiscId(), d.getDiscId());
	}
	
	@Test
	public void testGetDiscussionsByUserId() {
		Users u = new Users(1,"Test", "Testson", "test", "123", "test@rev.com", null, null);
		Discussion d = new Discussion(4, u, null, "Hello Get By User");
		
		dServ.addDiscussion(d);
		assertFalse(dServ.getDiscussionsByUserId(d.getUserId().getUserid()).isEmpty());
	}
	
	
	
}
