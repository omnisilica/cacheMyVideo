package com.case_study_sa.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Videolists")
public class Videolist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="Videolist_ID", unique=true)
	private int videolistID;
	
	@Column(name="Owner")
	private String videolistOwnerEmail;
	
	@Column(name="Title")
	private String videolistTitle;
	
	@Column(name="Date_Created")
	private String dateVideolistWasCreated;
	
	@Column(name="Videolist_Image_URL")
	private String videolistImageUrl;
	
	@ManyToOne
	@JoinColumn(name="Site_User_Email")
	private SiteUser siteUserVideolist;
	
	@OneToMany(mappedBy="associatedVideolistsSingle")
	private List<Video> videolistVideos = new ArrayList<>(); //List of type videos
	
	
	public Videolist() {
		super();
	}

	public Videolist(String videolistTitle, String videolistImageUrl, SiteUser siteUserVideolist) {
		super();
		this.videolistTitle = videolistTitle;
		this.videolistImageUrl = videolistImageUrl;
		this.siteUserVideolist = siteUserVideolist;
	}

	public int getVideolistID() {
		return videolistID;
	}

	public void setVideolistID(int videolistID) {
		this.videolistID = videolistID;
	}

	public String getVideolistOwnerEmail() {
		return videolistOwnerEmail;
	}

	public void setVideolistOwnerEmail(String videolistOwnerEmail) {
		this.videolistOwnerEmail = videolistOwnerEmail;
	}

	public String getVideolistTitle() {
		return videolistTitle;
	}

	public void setVideolistTitle(String videolistTitle) {
		this.videolistTitle = videolistTitle;
	}

	public String getDateVideolistWasCreated() {
		return dateVideolistWasCreated;
	}

	public void setDateVideolistWasCreated(String dateVideolistWasCreated) {
		this.dateVideolistWasCreated = dateVideolistWasCreated;
	}

	public String getVideolistImageUrl() {
		return videolistImageUrl;
	}

	public void setVideolistImageUrl(String videolistImageUrl) {
		this.videolistImageUrl = videolistImageUrl;
	}

	public SiteUser getSiteUserVideolist() {
		return siteUserVideolist;
	}

	public void setSiteUserVideolist(SiteUser siteUserVideolist) {
		this.siteUserVideolist = siteUserVideolist;
	}

	//@Access(AccessType.PROPERTY)
	//@ManyToMany(mappedBy="associatedVideolists")
	public List<Video> getVideolistVideos() {
		return videolistVideos;
	}

	public void setVideolistVideos(List<Video> videolistVideos) {
		this.videolistVideos = videolistVideos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateVideolistWasCreated == null) ? 0 : dateVideolistWasCreated.hashCode());
		result = prime * result + ((siteUserVideolist == null) ? 0 : siteUserVideolist.hashCode());
		result = prime * result + videolistID;
		result = prime * result + ((videolistImageUrl == null) ? 0 : videolistImageUrl.hashCode());
		result = prime * result + ((videolistOwnerEmail == null) ? 0 : videolistOwnerEmail.hashCode());
		result = prime * result + ((videolistTitle == null) ? 0 : videolistTitle.hashCode());
		result = prime * result + ((videolistVideos == null) ? 0 : videolistVideos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videolist other = (Videolist) obj;
		if (dateVideolistWasCreated == null) {
			if (other.dateVideolistWasCreated != null)
				return false;
		} else if (!dateVideolistWasCreated.equals(other.dateVideolistWasCreated))
			return false;
		if (siteUserVideolist == null) {
			if (other.siteUserVideolist != null)
				return false;
		} else if (!siteUserVideolist.equals(other.siteUserVideolist))
			return false;
		if (videolistID != other.videolistID)
			return false;
		if (videolistImageUrl == null) {
			if (other.videolistImageUrl != null)
				return false;
		} else if (!videolistImageUrl.equals(other.videolistImageUrl))
			return false;
		if (videolistOwnerEmail == null) {
			if (other.videolistOwnerEmail != null)
				return false;
		} else if (!videolistOwnerEmail.equals(other.videolistOwnerEmail))
			return false;
		if (videolistTitle == null) {
			if (other.videolistTitle != null)
				return false;
		} else if (!videolistTitle.equals(other.videolistTitle))
			return false;
		if (videolistVideos == null) {
			if (other.videolistVideos != null)
				return false;
		} else if (!videolistVideos.equals(other.videolistVideos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Videolist [videolistID=" + videolistID + ", videolistOwnerEmail=" + videolistOwnerEmail
				+ ", videolistTitle=" + videolistTitle + ", dateVideolistWasCreated=" + dateVideolistWasCreated
				+ ", videolistImageUrl=" + videolistImageUrl + "]";
	}


}
