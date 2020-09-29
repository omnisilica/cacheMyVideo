<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.case_study_sa.entities.SiteUser, 
    	com.case_study_sa.services.SiteUserService, 
    	com.case_study_sa.services.DownloadService,
    	com.case_study_sa.entities.Download,
    	java.util.List, java.util.ArrayList,
    	java.time.LocalDate" %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Downloads</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <%
	    /*SiteUser currentUser = null;
    	List<Download> currentUserDownloads = null;
    	SiteUserService siteUserService = new SiteUserService();
		if(request.getAttribute("siteUserRecord") != null){
			currentUser = (SiteUser) request.getAttribute("siteUserRecord");
			currentUserDownloads = currentUser.getUserDownloads();
			//currentUserDownloads = siteUserService.getUserDownloadsByEmailService(currentUser.getUserEmail());
		}*/
		SiteUserService siteUserService = new SiteUserService();
		DownloadService downloadService = new DownloadService();
     %>
    <body class="downloads-body">
    	<div class="download-section">
	    	<header>
				<nav>
					<a href="${pageContext.request.contextPath}/login-page">Login | </a>
					<a href="${pageContext.request.contextPath}/home-page">Home | </a>
					<a href="${pageContext.request.contextPath}/new-download-page">New Download | </a>
					<a href="${pageContext.request.contextPath}/videolists-page">Videolists</a>
				</nav>
			</header>
	    	<% 
	    	//out.print(currentUser);
	    	//out.print(currentUserDownloads.length);
	    	/*for(Download d : currentUserDownloads){
	    		out.print(d);
	    	}*/
	    	List<Integer> ise = new ArrayList<>();
	    	ise.add(1);
	    	ise.add(2);
	    	ise.add(3);
	    	%>
	    	
			<div class="displayed-downloads-capsule">
				<div class="displayed-downloads">
					<c:forEach items="${currentUserDownloads}" var="userDownload" >
						
						<div class="single-download">
							<div class="download-image-capsule">
								<!-- <img src="${userDownload.downloadImageUrl}"/> -->
								<video controls >
									<source src="${pageContext.request.contextPath}/resources/media/videos/video.mp4" 
									type="video/mp4">
								</video>
							</div>
							<div class="download-information">
								<h6>Title: ${userDownload.getDownloadTitle() }</h6>
								<!-- <p>${userDownload}</p>-->
								<h6>Downloaded: ${userDownload.getDateDownloadWasCreated()}</h6>
								<!-- <h6>Downloaded: ${userDownload.dateDownloadWasCreated.toString() }<%--<%out.print("\n" + downloadService.getDownloadByIDService(51).getDateDownloadWasCreated());%>--%></h6> -->
								<!-- <h6>Downloaded: <%--<%out.print(java.time.LocalDate.now().toString()); %>--%></h6>-->
								<a href="${pageContext.request.contextPath}/update-download/${userDownload.downloadID}">Update</a>
								<!-- <button type="submit" formaction="delete-download">Delete</button>-->
								<form><button type="submit" formmethod="POST" formaction="${pageContext.request.contextPath}/delete-download" name="downloadID" value="${userDownload.downloadID}">Delete</button></form>
							</div>
						</div>
						<!-- ${userDownload.downloadID} <a href="${userDownload.downloadImageUrl}">edit</a> | <a href="#">Delete</a> -->
						
						
					</c:forEach>
				</div>
			</div>
	    	
    	</div>
    </body>
</html>