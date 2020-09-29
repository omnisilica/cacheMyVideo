package com.case_study_sa.services;

import java.util.List;

import com.case_study_sa.dao.VideoDAO;
import com.case_study_sa.entities.Video;

public class VideoService {
	
	private VideoDAO videoDAO = new VideoDAO();

	public boolean createNewVideoService(Video newVideo) {
		return videoDAO.createNewVideo(newVideo);
	}

	public Video getVideoByIDService(int videoID) {
		return videoDAO.getVideoByID(videoID);
	}

	public boolean updateVideoService(int videoID, Video updatedVideo) {
		return videoDAO.updateVideo(videoID, updatedVideo);
	}

	public Video deleteVideoService(int videoID) {
		return videoDAO.deleteVideo(videoID);
	}
	
	public List getAllVideos() {
		return videoDAO.getAllVideos();
	}

}
