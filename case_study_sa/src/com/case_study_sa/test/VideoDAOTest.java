package com.case_study_sa.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.case_study_sa.dao.VideoDAO;
import com.case_study_sa.entities.Video;

public class VideoDAOTest {

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
	

	@Test
	public void testCreateNewVideo() {
		VideoDAO videoDAO = new VideoDAO();
		
		//Given
		Video video = new Video("Sun and palm trees", "https://images.pexels.com/photos/219998/pexels-photo-219998.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
		
		boolean expected = true;
		
		//When
		boolean actual = videoDAO.createNewVideo(video);
		
		//Then
		assertEquals(expected, actual);
		
	}

	
	/*
	@Test
	public void testGetVideoByID() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testUpdateVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteVideo() {
		fail("Not yet implemented");
	}*/

}
