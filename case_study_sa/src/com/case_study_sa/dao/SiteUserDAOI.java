package com.case_study_sa.dao;

import java.util.List;

import com.case_study_sa.entities.SiteUser;

public interface SiteUserDAOI {
	
	public boolean createUser(SiteUser siteUser);
	public SiteUser getUserByEmail(String userEmail);
	public boolean updateUser(String userEmail, SiteUser newSiteUser);
	public SiteUser deleteUser(String userEmail);
	public List getUserDownloadsByEmail(String userEmail); //of type Download
	public List getUserVideolistsByEmail(String userEmail); //of type Videolist

}
