package com.case_study_sa.services;

import com.case_study_sa.dao.VideolistDAO;
import com.case_study_sa.entities.Download;
import com.case_study_sa.entities.Video;
import com.case_study_sa.entities.Videolist;

public class VideolistService {
	
	private VideolistDAO videolistDAO = new VideolistDAO();

	public boolean createNewVideolistService(Videolist newVideolist) {
		return videolistDAO.createNewVideolist(newVideolist);
	}

	public Videolist getVideolistByIDService(int videolistID) {
		return videolistDAO.getVideolistByID(videolistID);
	}

	public boolean updateVideolistService(int videolistID, Videolist updatedVideolist) {
		return videolistDAO.updateVideolist(videolistID, updatedVideolist);
	}

	public Videolist deleteVideolistService(int videolistID) {
		return videolistDAO.deleteVideolist(videolistID);
	}
	
	public boolean addVideoToVideolist(int videolistID, Video video) {
		return videolistDAO.addVideoToVideolist(videolistID, video);
	}

}
