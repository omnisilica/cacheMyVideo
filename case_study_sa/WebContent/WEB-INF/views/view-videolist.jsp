<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.case_study_sa.entities.SiteUser, 
    	com.case_study_sa.entities.Videolist,
    	com.case_study_sa.entities.Video,
    	java.util.List" %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Videos</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <%
	    Videolist videolist = (Videolist)request.getAttribute("videolist");
    	List<Video> videos = videolist.getVideolistVideos();
    	Video video1 = videos.get(0);
    	out.print(video1);
    	out.print(video1.getVideoID());
     %>
    <body class="downloads-body">
    	<div class="download-section">
	    	<header>
				<nav>
					<a href="${pageContext.request.contextPath}/login-page">Login | </a>
					<a href="${pageContext.request.contextPath}/home-page">Home | </a>
					<a href="${pageContext.request.contextPath}/downloads-page">Downloads | </a>
					<a href="${pageContext.request.contextPath}/videolists-page">Videolists</a>
				</nav>
			</header>
	    	
			<div class="displayed-videos-from-videolist-capsule">
				<div class="displayed-videos-from-videolist">
					<c:forEach items="<%= videos %>" var="singleVideo" >
						<div class="single-video-from-videolist">
							<div class="video-image-from-videolist-capsule">
								<!-- <img src="${singleVideo.videoImageUrl}"/> -->
								<video controls >
									<source src="${pageContext.request.contextPath}/resources/media/videos/video.mp4" 
									type="video/mp4">
								</video>
							</div>
							<div class="video-from-videolist-information">
								<h6>Title: ${singleVideo.videoTitle }</h6>
								<h6>Created: ${singleVideo.dateVideoWasCreated}</h6>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
	    	
    	</div>
    </body>
</html>