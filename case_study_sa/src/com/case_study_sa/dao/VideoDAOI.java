package com.case_study_sa.dao;

import com.case_study_sa.entities.Video;

public interface VideoDAOI {
	
	public boolean createNewVideo(Video newVideo);
	public Video getVideoByID(int videoID);
	public boolean updateVideo(int videoID, Video updatedVideo);
	public Video deleteVideo(int videoID);
	
}
