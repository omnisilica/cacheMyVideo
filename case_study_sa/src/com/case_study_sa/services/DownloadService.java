package com.case_study_sa.services;

import com.case_study_sa.dao.DownloadDAO;
import com.case_study_sa.entities.Download;

public class DownloadService {
	
	private DownloadDAO downloadDAO = new DownloadDAO();

	public boolean createNewDownloadService(Download newDownload) {
		return downloadDAO.createNewDownload(newDownload);
	}

	public Download getDownloadByIDService(int downloadID) {
		return downloadDAO.getDownloadByID(downloadID);
	}

	public boolean updateDownloadService(int downloadID, Download updatedDownload) {
		return downloadDAO.updateDownload(downloadID, updatedDownload);
	}

	public Download deleteDownloadService(int downloadID) {
		return downloadDAO.deleteDownload(downloadID);
	}

}
