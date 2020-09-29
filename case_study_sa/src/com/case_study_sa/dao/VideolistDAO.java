package com.case_study_sa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.case_study_sa.entities.Video;
import com.case_study_sa.entities.Videolist;

public class VideolistDAO implements VideolistDAOI {
	
	private String persistenceUnitName = "case_study_sa";

	@Override
	public boolean createNewVideolist(Videolist newVideolist) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(newVideolist);
			
			entityManager.getTransaction().commit();
			result = true;
		} catch(Exception e) {
			System.out.println("OVERHERE*********");
			e.printStackTrace();
			System.out.println("OVERHERE*********");
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return result;
		
	}
	
	public boolean addVideoToVideolist(int videolistID, Video video) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Video> currentVideolistVideos = null;
		boolean result = false;
		
		try {
			
			entityManager.getTransaction().begin();
			
			Videolist videolist = getVideolistByID(videolistID);
			currentVideolistVideos = videolist.getVideolistVideos();
			currentVideolistVideos.add(video);
			System.out.println(currentVideolistVideos.get(0).getVideoID());
			videolist.setVideolistVideos(currentVideolistVideos);
			
			entityManager.getTransaction().commit();
			
			result = true;
		} catch(Exception e) {
			System.out.println("OVERHERE*********");
			e.printStackTrace();
			System.out.println("OVERHERE*********");
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return result;
		
	}

	@Override
	public Videolist getVideolistByID(int videolistID) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Videolist videolistFound = new Videolist();
		
		try {
			videolistFound = entityManager.find(Videolist.class, videolistID);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return videolistFound;
		
	}

	@Override
	public boolean updateVideolist(int videolistID, Videolist updatedVideolist) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			Videolist oldVideolist = entityManager.find(Videolist.class, videolistID);
			
			if(oldVideolist != null) {
				entityManager.getTransaction().begin();
				entityManager.getTransaction().commit();
			    result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return result;
		
	}

	@Override
	public Videolist deleteVideolist(int videolistID) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Videolist deletedVideolist = new Videolist();
		
		try {
			entityManager.getTransaction().begin();
			
			deletedVideolist = entityManager.find(Videolist.class, videolistID);
			entityManager.remove(deletedVideolist);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return deletedVideolist;
		
	}

}
