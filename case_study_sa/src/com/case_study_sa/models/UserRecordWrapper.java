package com.case_study_sa.models;

import java.util.List;

import com.case_study_sa.entities.SiteUser;

public class UserRecordWrapper {
	
	private SiteUser siteUser;
	
	private List allSiteVideos;
	
	public UserRecordWrapper() {
		super();
	}
	
	public UserRecordWrapper(SiteUser siteUser, List allSiteVideos) {
		this.siteUser = siteUser;
		this.allSiteVideos = allSiteVideos;
	}

	public SiteUser getSiteUser() {
		return siteUser;
	}

	public void setSiteUser(SiteUser siteUser) {
		this.siteUser = siteUser;
	}

	public List getAllSiteVideos() {
		return allSiteVideos;
	}

	public void setAllSiteVideos(List allSiteVideos) {
		this.allSiteVideos = allSiteVideos;
	}
	
	

}
