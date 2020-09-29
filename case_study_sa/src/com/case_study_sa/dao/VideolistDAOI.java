package com.case_study_sa.dao;

import com.case_study_sa.entities.Videolist;

public interface VideolistDAOI {
	
	public boolean createNewVideolist(Videolist newVideolist);
	public Videolist getVideolistByID(int videolistID);
	public boolean updateVideolist(int videolistID, Videolist updatedVideolist);
	public Videolist deleteVideolist(int videolistID);
	
}
