package com.revature.controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.controller.DiscussionController;
import com.revature.model.Discussion;
import com.revature.model.Reviews;
import com.revature.model.Users;
import com.revature.service.DiscussionService;

public class DiscussionControllerTest {

	@Mock
	DiscussionService ds;
	
	DiscussionController dc;
	
	private static Users u = new Users(5,"Kemo", "Allen", "kemo", "123", "kem@rev.com", null, null, null);
	private static Reviews r = new Reviews(5, "okay", null, null, null, null, 6, null, null, null);
	private static Discussion d = new Discussion(5, u, r, "Great review.");
	private static List<Discussion> dList = new LinkedList<>();
	
	@Before
	public void init() {
		ds = Mockito.mock(DiscussionService.class);
		dc = new DiscussionController(ds);
	
		dList.add(d);
		
		Mockito.when(ds.addDiscussion(d)).thenReturn(true);
		Mockito.when(ds.deleteDiscussion(d.getDiscId())).thenReturn(true);
		Mockito.when(ds.getDiscussionByDiscussionId(d.getDiscId())).thenReturn(d);
		Mockito.when(ds.getDiscussionsByUserId(d.getUserId().getUserid()))
											.thenReturn(dList.stream()
											.filter(x -> x.getUserId().getUserid() == d.getUserId().getUserid())
											.collect(Collectors.toList()));
		Mockito.when(ds.getDiscussionsByReviewId(d.getReviewId().getReviewId()))
											.thenReturn(dList.stream()
											.filter(x -> x.getReviewId().getReviewId() == d.getReviewId().getReviewId())
											.collect(Collectors.toList()));
	}
	
	@Test
	public void testAddDiscussion() {
		ResponseEntity<Boolean> re = new ResponseEntity<>(true, HttpStatus.OK);
		assertEquals(dc.addDiscussion(d), re);
	}
	
	@Test
	public void testGetDiscussionById() {
		ResponseEntity<Discussion> re = new ResponseEntity<>(d, HttpStatus.OK);
		assertEquals(dc.getDiscussionById(d.getDiscId()), re);
	}
	
	@Test
	public void testGetDiscussionByUserId() {
		ResponseEntity<List<Discussion>> re = new ResponseEntity<>(dList, HttpStatus.OK);
		assertEquals(dc.getDiscussionByUserId(d.getUserId().getUserid()), re);
	}
	
	@Test
	public void testGetDiscussionByReviewId() {
		ResponseEntity<List<Discussion>> re = new ResponseEntity<>(dList, HttpStatus.OK);
		assertEquals(dc.getDiscussionByReviewId(d.getReviewId().getReviewId()), re);
	}
	
}
