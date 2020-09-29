package com.case_study_sa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.case_study_sa.dao.VideoDAO;
import com.case_study_sa.dao.VideolistDAO;
import com.case_study_sa.entities.Download;
//import com.adbofficesapp_01.models.Users; //delete
import com.case_study_sa.entities.SiteUser;
import com.case_study_sa.entities.Video;
import com.case_study_sa.entities.Videolist;
import com.case_study_sa.models.UserRecordWrapper;
import com.case_study_sa.services.DownloadService;
import com.case_study_sa.services.SiteUserService;
import com.case_study_sa.services.VideoService;
import com.case_study_sa.services.VideolistService;

@Controller
@SessionAttributes("siteUserLogin")
public class MainController {
	
	private SiteUserService siteUserService = new SiteUserService();
	private DownloadService downloadService = new DownloadService();
	private VideolistService videolistService = new VideolistService();
	private VideolistDAO videolistDAO = new VideolistDAO();
	private VideoService videoService = new VideoService();
	
	
	@ModelAttribute("siteUserLogin")
	public SiteUser setUpSiteUser() {
		return new SiteUser();
	}
	
	@RequestMapping("/")
	public String indexPageHandler() {
		return "login"; //jsp
	}

	@RequestMapping("/cookie-policy")
	public String cookiePolicyPageHandler() {
		return "cookie-policy"; //jsp
	}

	@RequestMapping("/data-policy")
	public String dataPolicyPageHandler() {
		return "data-policy"; //jsp
	}

	@RequestMapping("/error")
	public String errorPageHandler() {
		return "error"; //jsp
	}
	
	@RequestMapping("/downloads-page")
	public ModelAndView downloadsPageHandler(@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		ModelAndView modelAndView = new ModelAndView("downloads");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		
		List<Download> currentUserDownloads = new ArrayList<>();
	    
		if(siteUserRecord.getUserDownloads() != null) {
			currentUserDownloads = siteUserRecord.getUserDownloads();
		}
		
			
	    modelAndView.addObject("currentUserDownloads", currentUserDownloads);
		
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/home-page")
	public ModelAndView homePageHandler(@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {

		SiteUser siteUserRecord = siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		
		List<Video> allSiteVideos = new ArrayList<>();
    	
		allSiteVideos = videoService.getAllVideos();
		
		
		UserRecordWrapper userRecordWrapper = new UserRecordWrapper(siteUserRecord, allSiteVideos);
		
		modelAndView.addObject("userRecordWrapper", userRecordWrapper);
		
		return modelAndView; 
	}

	@RequestMapping("/inbox")
	public String inboxPageHandler() {
		return "inbox"; //jsp
	}

	@RequestMapping("/login")
	public ModelAndView loginTransactionHandler(/*@Valid */@ModelAttribute SiteUser currentSiteUser,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		System.out.println("LOGIN*********" + "\n" + currentSiteUser);
	
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUser.getUserEmail());
		
		String viewName = "home";
		ModelAndView modelAndView = new ModelAndView("home");
		
		currentSiteUserSession.setUserEmail(currentSiteUser.getUserEmail());
		currentSiteUserSession.setUserPassword(currentSiteUser.getUserPassword());
		
		if(siteUserRecord.getUserUsername() != null && siteUserRecord.getUserUsername() != "") {
			currentSiteUserSession.setUserUsername(siteUserRecord.getUserUsername());
		}
		
		modelAndView.addObject("siteUserRecord", siteUserRecord);
		
		List<Video> allSiteVideos = new ArrayList<>();
    	
		allSiteVideos = videoService.getAllVideos();
		
		
		
		UserRecordWrapper userRecordWrapper = new UserRecordWrapper(siteUserRecord, allSiteVideos);
		
		modelAndView.addObject("userRecordWrapper", userRecordWrapper);
		
		System.out.println("LOGIN*********" + "\n" + currentSiteUserSession);
		return modelAndView; //jsp
	}
	
	@RequestMapping("/login-page")
	public String loginPageHandler() {
		return "login";
	}

	@RequestMapping("/new-download")
	public ModelAndView newDownloadHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		ModelAndView modelAndView = new ModelAndView("downloads");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		String downloadTitle = request.getParameter("downloadTitle");
		String downloadImageUrl = request.getParameter("downloadImageUrl");
		
		Download newDownload = new Download(downloadTitle, downloadImageUrl, currentSiteUserSession);
		newDownload.setDateDownloadWasCreated(java.time.LocalDate.now().toString());
		
		
		System.out.println("THE DATE**********" + newDownload.getDateDownloadWasCreated());
		downloadService.createNewDownloadService(newDownload);
		System.out.println("AFTER**********" + downloadService.getDownloadByIDService(newDownload.getDownloadID()));
		
		
		List<Download> currentUserDownloads = new ArrayList<>();
    	
	    currentUserDownloads = siteUserRecord.getUserDownloads();
		
		
		modelAndView.addObject("currentUserDownloads", currentUserDownloads);
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/update-download/{downloadIDUrl}")
	public ModelAndView updateDownloadHandler(@PathVariable("downloadIDUrl") int downloadID,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		
		
		ModelAndView modelAndView = new ModelAndView("updated-download");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		Download downloadToBeUpdated = downloadService.getDownloadByIDService(downloadID);
		
		modelAndView.addObject("downloadToBeUpdated", downloadToBeUpdated);
		
		
		return modelAndView; //jsp
	}
	
	
	@RequestMapping("/download-updated")
	public ModelAndView downloadUpdatedHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		System.out.println("reached this too");
		ModelAndView modelAndView = new ModelAndView("downloads");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		String downloadTitle = request.getParameter("downloadTitle");
		String downloadImageUrl = request.getParameter("downloadImageUrl");
		String downloadID = request.getParameter("downloadID");
		System.out.println(request.getParameter("downloadID"));
		
		int parsedDownloadID = Integer.parseInt(downloadID);
		Download downloadToBeUpdated = downloadService.getDownloadByIDService(parsedDownloadID);
		
		downloadToBeUpdated.setDownloadTitle(downloadTitle);
		downloadToBeUpdated.setDownloadImageUrl(downloadImageUrl);
		
		downloadService.updateDownloadService(downloadToBeUpdated.getDownloadID(), downloadToBeUpdated);
		
		
		List<Download> currentUserDownloads = new ArrayList<>();
    	
	    currentUserDownloads = siteUserRecord.getUserDownloads();
	    
	    modelAndView.addObject("currentUserDownloads", currentUserDownloads);
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/delete-download")
	public ModelAndView deleteDownloadHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		ModelAndView modelAndView = new ModelAndView("downloads");
		
		System.out.println("DOWNLOADiIDdddd	" + request.getParameter("downloadID"));
		String downloadID = request.getParameter("downloadID");
		
		int parsedDownloadID = Integer.parseInt(downloadID);
		
		downloadService.deleteDownloadService(parsedDownloadID);
		

		List<Download> currentUserDownloads = new ArrayList<>();
    	
	    currentUserDownloads = siteUserRecord.getUserDownloads();
	    
	    modelAndView.addObject("currentUserDownloads", currentUserDownloads);
		
		return modelAndView; //jsp
	}	
	
	@RequestMapping("/update-download-page")
	public String updateDownloadPageHandler() {
		return "update-download"; //jsp
	}
	
	@RequestMapping("/new-download-page")
	public String newDownloadPageHandler() {
		return "new-download"; //jsp
	}

	@RequestMapping("/registration")
	public ModelAndView registrationPageHandler(@ModelAttribute SiteUser newSiteUser,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession,
			HttpServletRequest request) {
		System.out.println("REGISTRATION*********" + "\n" + newSiteUser);
		
		String viewName = "home";
		ModelAndView modelAndView = new ModelAndView("home");
		
		String userEmail = request.getParameter("userEmail");
		String userUsername = request.getParameter("userUsername");
		String userPassword = request.getParameter("userPassword");
		
		SiteUser user = new SiteUser(userEmail, userPassword);
		
		if(userUsername != null && userUsername != "") {
			user.setUserUsername(userUsername);
		}
		
		siteUserService.createUserService(user);
		
		
		currentSiteUserSession.setUserEmail(newSiteUser.getUserEmail());
		currentSiteUserSession.setUserPassword(newSiteUser.getUserPassword());
		
		
		if(newSiteUser.getUserUsername() != null && newSiteUser.getUserUsername() != "") {
			currentSiteUserSession.setUserUsername(newSiteUser.getUserUsername());
		}
		
		SiteUser siteUserRecord = currentSiteUserSession;
		
		
		List<Video> allSiteVideos = new ArrayList<>();
    	
		allSiteVideos = videoService.getAllVideos();
		
		
		
		UserRecordWrapper userRecordWrapper = new UserRecordWrapper(siteUserRecord, allSiteVideos);
		
		modelAndView.addObject("userRecordWrapper", userRecordWrapper);
		return modelAndView; //jsp
		
	}

	@RequestMapping("/reset-password")
	public String resetPasswordPageHandler() {
		return "reset-password"; //jsp
	}
	
	@RequestMapping("/sign-up")
	public String signUpPageHandler() {
		return "registration"; //jsp
	}
	@RequestMapping("/terms")
	public String termsPageHandler() {
		return "terms"; //jsp
	}

	@RequestMapping("/new-videolists")
	public ModelAndView newVideolistHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		ModelAndView modelAndView = new ModelAndView("videolist");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		String videolistTitle = request.getParameter("videolistTitle");
		String videolistImageUrl = request.getParameter("videolistImageUrl");
		
		Videolist newVideolist = new Videolist(videolistTitle, videolistImageUrl, siteUserRecord);
		newVideolist.setVideolistOwnerEmail(siteUserRecord.getUserEmail());;
		
		newVideolist.setDateVideolistWasCreated(java.time.LocalDate.now().toString());
		
		
		
		videolistService.createNewVideolistService(newVideolist);
		
		
		List<Videolist> currentUserVideolists = new ArrayList<>();
    	
		currentUserVideolists = siteUserRecord.getUserVideolists();
		
		
		modelAndView.addObject("currentUserVideolists", currentUserVideolists);
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/videolists-page")
	public ModelAndView videolistPageHandler(@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {

		ModelAndView modelAndView = new ModelAndView("videolist");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		
		List<Videolist> currentUserVideolists = new ArrayList<>();
	    	
		
		if( siteUserRecord.getUserVideolists().size() > 0) {
			currentUserVideolists = siteUserRecord.getUserVideolists();
		}

	    modelAndView.addObject("currentUserVideolists", currentUserVideolists);
		
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/new-videolist-page")
	public String newVideolistPageHandler() {
		return "new-videolist"; //jsp
	}
	
	@RequestMapping("/view-videolist/{videolistIDUrl}")
	public ModelAndView viewVideolistHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession,
			@PathVariable("videolistIDUrl") int videolistID) {
		
		ModelAndView modelAndView = new ModelAndView("view-videolist");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		Videolist videolist = videolistService.getVideolistByIDService(videolistID);
		
		
		modelAndView.addObject("videolist", videolist);
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/add-to-videolist")
	public ModelAndView addToVideolistHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		ModelAndView modelAndView = new ModelAndView("videolist");
		
		
		int videolistID = Integer.parseInt(request.getParameter("videolistID"));
		int videoID = Integer.parseInt(request.getParameter("videoID"));
		Video video = videoService.getVideoByIDService(videoID);
		video.setAssociatedVideolistsSingle(videolistService.getVideolistByIDService(videolistID));
		
		videoService.updateVideoService(videoID, video);
		
		
		List<Videolist> currentUserVideolists = new ArrayList<>();
    	
		currentUserVideolists = siteUserRecord.getUserVideolists();
			
	    modelAndView.addObject("currentUserVideolists", currentUserVideolists);
		
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/add-video")
	public ModelAndView addVideoHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		String videoTitle = request.getParameter("videoTitle");
		String videoImageUrl = request.getParameter("videoImageUrl");
		
		
		Video newVideo = new Video(videoTitle, videoImageUrl);
		
		newVideo.setDateVideoWasCreated(java.time.LocalDate.now().toString());
		
		videoService.createNewVideoService(newVideo);
		
		List<Video> allSiteVideos = new ArrayList<>();
    	
		allSiteVideos = videoService.getAllVideos();
		
		
		UserRecordWrapper userRecordWrapper = new UserRecordWrapper(siteUserRecord, allSiteVideos);
		
		modelAndView.addObject("userRecordWrapper", userRecordWrapper);
		
		return modelAndView; //jsp
	}
	
	@RequestMapping("/watch-video/{videoIDUrl}")
	public ModelAndView watchVideoHandler(HttpServletRequest request,
			@SessionAttribute("siteUserLogin") SiteUser currentSiteUserSession,
			@PathVariable("videoIDUrl") int videoID) {
		
		ModelAndView modelAndView = new ModelAndView("watch-video");
		
		SiteUser siteUserRecord = (SiteUser) siteUserService.getUserByEmailService(currentSiteUserSession.getUserEmail());
		
		Video videoToWatch = videoService.getVideoByIDService(videoID);
		
		
		modelAndView.addObject("videoToWatch", videoToWatch);
		
		return modelAndView; //jsp
	}
	

	@RequestMapping("/view-message")
	public String viewMessagePageHandler() {
		return "view-message"; //jsp
	}
	
	@RequestMapping("/logout")
	public String logoutHandler(HttpSession session, SessionStatus status) {
		
		status.setComplete();

		session.invalidate();
		
		return "logout";
		
	}

}
