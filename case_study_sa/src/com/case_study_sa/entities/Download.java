package com.case_study_sa.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Downloads")
public class Download {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="Download_ID", unique=true)
	private int downloadID;
	
	@Column(name="Download_Title")
	private String downloadTitle;
	
	@Column(name="Date_Created")
	private String dateDownloadWasCreated;
	
	@Column(name="Download_Image_URL")
	private String downloadImageUrl;
	
	@ManyToOne
	@JoinColumn(name="Site_User_Email")
	private SiteUser siteUserDownload;

	public Download() {
		super();
	}

	public Download(String downloadTitle, String downloadImageUrl, SiteUser siteUserDownload) {
		super();
		this.downloadTitle = downloadTitle;
		this.downloadImageUrl = downloadImageUrl;
		this.siteUserDownload = siteUserDownload;
	}

	public int getDownloadID() {
		return downloadID;
	}

	public void setDownloadID(int downloadID) {
		this.downloadID = downloadID;
	}

	public String getDownloadTitle() {
		return downloadTitle;
	}

	public void setDownloadTitle(String downloadTitle) {
		this.downloadTitle = downloadTitle;
	}

	public String getDateDownloadWasCreated() {
		return dateDownloadWasCreated;
	}

	public void setDateDownloadWasCreated(String dateDownloadWasCreated) {
		this.dateDownloadWasCreated = dateDownloadWasCreated;
	}

	public String getDownloadImageUrl() {
		return downloadImageUrl;
	}

	public void setDownloadImageUrl(String downloadImageUrl) {
		this.downloadImageUrl = downloadImageUrl;
	}

	public SiteUser getSiteUserDownload() {
		return siteUserDownload;
	}

	public void setSiteUserDownload(SiteUser siteUserDownload) {
		this.siteUserDownload = siteUserDownload;
	}



	@Override
	public String toString() {
		return "Download [downloadID=" + downloadID + ", downloadTitle=" + downloadTitle + ", dateDownloadWasCreated="
				+ dateDownloadWasCreated + ", downloadImageUrl=" + downloadImageUrl + "]";
	}
	
	
	
	
}
