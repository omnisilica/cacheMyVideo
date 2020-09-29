package com.case_study_sa.dao;

import com.case_study_sa.entities.Download;

public interface DownloadDAOI {
	
	public boolean createNewDownload(Download newDownload);
	public Download getDownloadByID(int downloadID);
	public boolean updateDownload(int downloadID, Download updatedDownload);
	public Download deleteDownload(int downloadID);
	
}
