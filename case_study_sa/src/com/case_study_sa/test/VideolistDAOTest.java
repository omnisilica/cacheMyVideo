package com.case_study_sa.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.case_study_sa.dao.SiteUserDAO;
import com.case_study_sa.dao.VideolistDAO;
import com.case_study_sa.entities.SiteUser;
import com.case_study_sa.entities.Videolist;

public class VideolistDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
	
	@Test
	public void testCreateNewVideolist() {
		VideolistDAO videolistDAO = new VideolistDAO();
		
		//CHANGE: TEST CASES ARE PERSISTED
		SiteUser siteUserVideolist = new SiteUser("anotherTest2@gmail.com", "anotherTest2");
		SiteUserDAO siteUserDAO = new SiteUserDAO();
		
		siteUserDAO.createUser(siteUserVideolist);
		
		//Given
		//CHANGE: TEST CASES ARE PERSISTED
		Videolist videolist = new Videolist("Sun and water", "https://images.pexels.com/photos/33834/landscape-shore-sunset-clouds.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", siteUserVideolist);
		
		boolean expected = true;
		
		//When
		boolean actual = videolistDAO.createNewVideolist(videolist);
		
		//Then
		assertEquals(expected, actual);
		
	}

	
	/*
	@Test
	public void testGetVideolistByID() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testUpdateVideolist() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteVideolist() {
		fail("Not yet implemented");
	}*/

}
