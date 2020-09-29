package com.case_study_sa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.case_study_sa.entities.Video;
import com.case_study_sa.entities.Videolist;

public class VideoDAO implements VideoDAOI {
	
	private String persistenceUnitName = "case_study_sa";

	@Override
	public boolean createNewVideo(Video newVideo) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(newVideo);
			
			entityManager.getTransaction().commit();
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return result;
		
	}

	@Override
	public Video getVideoByID(int videoID) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Video videoFound = new Video();
		
		try {
			videoFound = entityManager.find(Video.class, videoID);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return videoFound;
		
	}
	
	public List getAllVideos() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List videos = new ArrayList<Video>();
		
		try {
			String getVideos = "SELECT v FROM Video v";
			Query query = entityManager.createQuery(getVideos);
			videos = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return videos;
		
	}

	@Override
	public boolean updateVideo(int videoID, Video updatedVideo) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			
			Video oldVideo = entityManager.find(Video.class, videoID);
			
			if(oldVideo != null) {
				entityManager.getTransaction().begin();
				
				oldVideo.setVideoTitle(updatedVideo.getVideoTitle());
				oldVideo.setVideoImageUrl(updatedVideo.getVideoImageUrl());
				
				Videolist associatedVideolist = updatedVideo.getAssociatedVideolistsSingle();
				
				if(associatedVideolist != null) {
					oldVideo.setAssociatedVideolistsSingle(associatedVideolist);
				}
				
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
	public Video deleteVideo(int videoID) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Video deletedVideo = new Video();
		
		try {
			entityManager.getTransaction().begin();
			
			deletedVideo = entityManager.find(Video.class, videoID);
			entityManager.remove(deletedVideo);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return deletedVideo;
		
	}

}
