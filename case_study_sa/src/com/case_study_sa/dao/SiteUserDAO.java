package com.case_study_sa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.case_study_sa.entities.Download;
import com.case_study_sa.entities.SiteUser;
import com.case_study_sa.entities.Videolist;

public class SiteUserDAO implements SiteUserDAOI {
	
	private String persistenceUnitName = "case_study_sa";

	@Override
	public boolean createUser(SiteUser siteUser) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(siteUser);
			
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
	public SiteUser getUserByEmail(String userEmail) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		SiteUser siteUserFound = new SiteUser();
		
		try {
			siteUserFound = entityManager.find(SiteUser.class, userEmail);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return siteUserFound;
		
	}

	@Override
	public boolean updateUser(String userEmail, SiteUser newSiteUser) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			SiteUser oldSiteUser = entityManager.find(SiteUser.class, userEmail);
			if(oldSiteUser != null) {
				entityManager.getTransaction().begin();
				
				oldSiteUser.setUserEmail(newSiteUser.getUserEmail());
				oldSiteUser.setUserUsername(newSiteUser.getUserUsername());
				oldSiteUser.setUserPassword(newSiteUser.getUserPassword());
				
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
	public SiteUser deleteUser(String userEmail) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		SiteUser siteUserDeleted = new SiteUser();
		
		try {
			entityManager.getTransaction().begin();
			
			siteUserDeleted = entityManager.find(SiteUser.class, userEmail);
			entityManager.remove(siteUserDeleted);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return siteUserDeleted;
		
	}

	@Override
	public List getUserDownloadsByEmail(String userEmail) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List downloads = new ArrayList<Download>();
		
		try {
			String getDownloads = "SELECT d FROM Download d WHERE d.siteUserDownload = :givenEmail";
			Query query = entityManager.createQuery(getDownloads);
			query.setParameter("givenEmail", userEmail);
			downloads = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return downloads; // should get Download object
		
	}

	@Override
	public List getUserVideolistsByEmail(String userEmail) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List videolists = new ArrayList<Videolist>();
		
		try {
			String getVideolists = "SELECT v FROM Videolist v WHERE d.siteUserVideolist = :givenEmail";
			Query query = entityManager.createQuery(getVideolists);
			query.setParameter("givenEmail", userEmail);
			videolists = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		//returns Videolist object. Might have to make another query
		//targeting name or id of the videolist object so it can be accessed in
		//the Videos table. In other words get all the videolists from the videos
		//table that matches the videolist id
		return videolists;
		
	}

}
