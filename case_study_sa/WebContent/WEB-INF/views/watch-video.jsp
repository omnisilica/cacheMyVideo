<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.case_study_sa.entities.SiteUser,
    com.case_study_sa.entities.Video,
    com.case_study_sa.models.UserRecordWrapper,
    com.case_study_sa.services.VideoService,
    java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Watch Video</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
   
    <% 
	List<Video> allSiteVideos = null;
	Video videoToWatch = null;
	String videoTitle = null;
	String dateVideoWasCreated = null;
	VideoService videoService = new VideoService();
	if(request.getAttribute("videoToWatch") != null){
		videoToWatch = (Video) request.getAttribute("videoToWatch");
		videoTitle = videoToWatch.getVideoTitle();
		dateVideoWasCreated = videoToWatch.getDateVideoWasCreated();
		
		allSiteVideos = videoService.getAllVideos();
		
	}
    %>
    <body>
    	<div class="watch-video-page-capsule">
			<header class="header-nav">
				<nav>
					<a href="${pageContext.request.contextPath}/home-page">
						<i class="fas fa-layer-group"></i>
						<p>Home</p>
					</a>
					<a href="${pageContext.request.contextPath}/downloads-page">
						<i class="fas fa-cloud-download-alt"></i>
						<p>Downloads</p>
					</a>
					<a href="${pageContext.request.contextPath}/#" class="active-link">
						<i class="fas fa-play"></i>
						<p>Videos</p>
					</a>
					<a href="${pageContext.request.contextPath}/videolists-page">
						<i class="far fa-list-alt"></i>
						<p>Videolists</p>
					</a>
					<a href="${pageContext.request.contextPath}/logout">
						<i class="fas fa-sign-out-alt"></i> 
						<p>Logout</p>
					</a>
				</nav>
			</header>
	    	<section class="section-content">
	   			<div class="video-presentation">
	   				<div class="watch-video-capsule">
						<!-- <img src="${siteVideo.getVideoImageUrl()}"/> -->
						<video controls >
							<source src="${pageContext.request.contextPath}/resources/media/videos/video.mp4" 
							type="video/mp4">
						</video>
					</div>
					<div class="video-information">
						<h3>Title: <%=videoTitle%></h3>
						<h3>Date Added: <%= dateVideoWasCreated%></h3>
						<p><span class="video-description" >Description: </span>Contrary to popular belief, Lorem Ipsum is not simply random text. 
									It has roots in a piece of classical Latin literature from 45 BC, 
									making it over 2000 years old. Richard McClintock, a Latin professor 
									at Hampden-Sydney College in Virginia, looked up one of the more obscure 
									Latin words, consectetur, from a Lorem Ipsum passage, and going through 
									the cites of the word in classical literature, discovered the undoubtable 
									source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de 
									Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, 
									written in 45 BC. This book is a treatise on the theory of ethics, very 
									popular during the Renaissance. The first line of Lorem Ipsum, "Lorem 
									ipsum dolor sit amet..", comes from a line in section 1.10.32.The standard 
									chunk of Lorem Ipsum used since the 1500s is reproduced below for those 
									interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et 
									Malorum" by Cicero are also reproduced in their exact original form, 
									accompanied by English versions from the 1914 translation by H. Rackham.</p>
					</div>
				</div>
	           	<div class="other-site-videos">
	           		<c:forEach items="<%=allSiteVideos %>" var="siteVideo" >
	           				<div>
								<div class="site-video">
									<!-- <img src="${siteVideo.getVideoImageUrl()}"/> -->
									<video controls >
										<source src="${pageContext.request.contextPath}/resources/media/videos/video.mp4" 
										type="video/mp4">
									</video>
								</div>
								<div class="site-video-information">
									<h6>${siteVideo.videoTitle}</h6>
									<h6>Date Added: ${siteVideo.dateVideoWasCreated }</h6>
								</div>
							</div>
	          
	           		</c:forEach>
	           	</div>
	    	</section>
    	</div>
    </body>
</html>