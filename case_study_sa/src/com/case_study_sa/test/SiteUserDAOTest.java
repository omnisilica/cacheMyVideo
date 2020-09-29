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

public class SiteUserDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testGetUserByEmail() {
		
		SiteUserDAO siteUserDAO = new SiteUserDAO();
		
		//Given
		//CHANGE: TEST CASES ARE PERSISTED
		SiteUser siteUser = new SiteUser("test2@gmail.com", "test2");
		
		boolean expected = true;
		
		//When
		boolean actual = siteUserDAO.createUser(siteUser);
		
		//Then
		assertEquals(expected, actual);
	}
	
	/*
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllDownloads() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllVideolists() {
		fail("Not yet implemented");
	}*/

}
