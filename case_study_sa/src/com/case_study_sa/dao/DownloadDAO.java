package com.case_study_sa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.case_study_sa.entities.Download;

public class DownloadDAO implements DownloadDAOI {
	
	private String persistenceUnitName = "case_study_sa";

	@Override
	public boolean createNewDownload(Download newDownload) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(newDownload);
			
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
	public Download getDownloadByID(int downloadID) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Download downloadFound = new Download();
		try {
			downloadFound = entityManager.find(Download.class, downloadID);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return downloadFound;
		
	}

	@Override
	public boolean updateDownload(int downloadID, Download updatedDownload) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean result = false;
		
		try {
			
			Download oldDownload = entityManager.find(Download.class, downloadID);
			
			if(oldDownload != null) {
				entityManager.getTransaction().begin();
				
				oldDownload.setDownloadTitle(updatedDownload.getDownloadTitle());
				oldDownload.setDownloadImageUrl(updatedDownload.getDownloadImageUrl());
				
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
	public Download deleteDownload(int downloadID) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Download deletedDownload = new Download();
		
		try {
			entityManager.getTransaction().begin();
			
			deletedDownload = entityManager.find(Download.class, downloadID);
			entityManager.remove(deletedDownload);
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return deletedDownload;
		
	}

}
