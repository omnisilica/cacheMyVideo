package com.case_study_sa.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.case_study_sa.dao.DownloadDAO;
import com.case_study_sa.dao.SiteUserDAO;
import com.case_study_sa.entities.Download;
import com.case_study_sa.entities.SiteUser;

public class DownloadDAOTest {

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
	public void testCreateNewDownload() {
		fail("Not yet implemented");
	}
	*/

	
	@Test
	public void testGetDownloadByID() {
		
		SiteUserDAO siteUserDAO = new SiteUserDAO();
		SiteUser newUser = new SiteUser("auser2@gmail.com", "auser2");
		siteUserDAO.createUser(newUser);
		DownloadDAO downloadDAO = new DownloadDAO();
		
		
		//Given
		Download newDownload = new Download("grass and sky", "https://images.pexels.com/photos/1237119/pexels-photo-1237119.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", newUser);
		boolean expected = true;
		
		//When
		boolean actual = downloadDAO.createNewDownload(newDownload);
		
		//Then
		assertEquals(expected, actual);
		
	}
	
	/*
	@Test
	public void testUpdateDownload() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDownload() {
		fail("Not yet implemented");
	}*/

}
