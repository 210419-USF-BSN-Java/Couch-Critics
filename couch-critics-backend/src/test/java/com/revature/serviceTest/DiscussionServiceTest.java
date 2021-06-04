package com.revature.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.model.Discussion;
import com.revature.model.Reviews;
import com.revature.model.Users;
import com.revature.repository.DiscussionRepository;
import com.revature.service.DiscussionService;

public class DiscussionServiceTest {
	@Mock
	private DiscussionRepository dRepo;
	
	private DiscussionService dServ;
	
	private static Users u = new Users(5,"Kemo", "Allen", "kemo", "123", "kem@rev.com", null, null, null);
	private static Reviews r = new Reviews(5, "okay", null, null, null, null, null, null, null, null);
	private static Discussion d = new Discussion(5, u, r, "Great review.");
	
	@Before
	public void init() {
		dRepo = Mockito.mock(DiscussionRepository.class);
		dServ = new DiscussionService(dRepo);
		
		List<Discussion> dList = new LinkedList<>();
		dList.add(d);
		
		Mockito.when(dRepo.save(d)).thenReturn(d);
		Mockito.when(dRepo.getById(d.getDiscId())).thenReturn(d);
		Mockito.when(dRepo.getDiscussionByUserIdUserid(d.getUserId().getUserid()))
											.thenReturn(dList.stream()
											.filter(x -> x.getUserId().getUserid() == d.getUserId().getUserid())
											.collect(Collectors.toList()));
		Mockito.when(dRepo.getDiscussionByReviewIdReviewId(d.getReviewId().getReviewId()))
											.thenReturn(dList.stream()
											.filter(x -> x.getReviewId().getReviewId() == d.getReviewId().getReviewId())
											.collect(Collectors.toList()));
	}
	
	@Test
	public void testAddDiscussion() {		
		assertTrue(dServ.addDiscussion(d));	
	}
	
	@Test
	public void testDeleteDiscussion() {
		dServ.addDiscussion(d);
		assertTrue(dServ.deleteDiscussion(d.getDiscId()));	
	}
	
	@Test
	public void testGetDiscussionById() {
		dServ.addDiscussion(d);
		assertEquals(dServ.getDiscussionByDiscussionId(d.getDiscId()).getDiscId(), d.getDiscId());
	}

	@Test
	public void testGetDiscussionsByUserId() {
		dServ.addDiscussion(d);
		assertFalse(dServ.getDiscussionsByUserId(d.getUserId().getUserid()).isEmpty());
	}
	
	@Test
	public void testGetDiscussionsByReviewId() {
		dServ.addDiscussion(d);
		assertFalse(dServ.getDiscussionsByUserId(d.getReviewId().getReviewId()).isEmpty());
	}
	
}
