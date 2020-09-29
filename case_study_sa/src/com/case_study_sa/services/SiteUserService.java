package com.case_study_sa.services;

import java.util.List;

import com.case_study_sa.dao.SiteUserDAO;
import com.case_study_sa.entities.SiteUser;

public class SiteUserService {
	
	private SiteUserDAO siteUserDAO = new SiteUserDAO();

	public boolean createUserService(SiteUser siteUser) {
		return siteUserDAO.createUser(siteUser);
	}

	public SiteUser getUserByEmailService(String userEmail) {
		return siteUserDAO.getUserByEmail(userEmail);
	}

	public boolean updateUserService(String userEmail, SiteUser newSiteUser) {
		return siteUserDAO.updateUser(userEmail, newSiteUser);
	}

	public SiteUser deleteUserService(String userEmail) {
		return siteUserDAO.deleteUser(userEmail);
	}

	public List getUserDownloadsByEmailService(String userEmail) {
		return siteUserDAO.getUserDownloadsByEmail(userEmail);
	}

	public List getUserVideolistsByEmailService(String userEmail) {
		return siteUserDAO.getUserVideolistsByEmail(userEmail);
	}

}
