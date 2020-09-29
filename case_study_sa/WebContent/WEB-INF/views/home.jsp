<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.case_study_sa.entities.SiteUser,
    com.case_study_sa.entities.Video,
    com.case_study_sa.models.UserRecordWrapper,
    java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <% 
    
    //boolean userLoggedIn(String currentSessionSiteUser) {
    	
    //}
    
    %>
    <%--<% 
    	//session.getAttribute("siteUserLogin");
    	SiteUser currentUser = null;
    	String currentUserUsername = null;
    	if(request.getAttribute("siteUserRecord") != null){
    		currentUser = (SiteUser) request.getAttribute("siteUserRecord");
    		currentUserUsername = currentUser.getUserUsername();
    	}
    	//SiteUser currentUser = (SiteUser) session.getAttribute("siteUserRecord");
    	//String currentUserUsername = currentUser.getUserUsername();
    	//out.print(currentUser);
    	
    	//out.print("Over here:" + siteUser);
    	//out.print(siteUser.getUserEmail());
    	//session.setAttribute(name, value);
    %>--%>
    <% 
    SiteUser currentUser = null;
	String currentUserUsername = null;
	UserRecordWrapper userRecordWrapper = null;
	List<Video> allSiteVideos = null;
	if(request.getAttribute("userRecordWrapper") != null){
		userRecordWrapper = (UserRecordWrapper) request.getAttribute("userRecordWrapper");
		currentUser = (SiteUser) userRecordWrapper.getSiteUser();
		currentUserUsername = currentUser.getUserUsername();
		allSiteVideos = userRecordWrapper.getAllSiteVideos();
		allSiteVideos.size();
	}
    %>
    <body>
    	<section class="welcome-section">
			<header>
				<nav>
					<a href="${pageContext.request.contextPath}/login-page">Login | </a>
					<a href="${pageContext.request.contextPath}/downloads-page">Downloads | </a>
					<a href="${pageContext.request.contextPath}/videolists-page">Videolists | </a>
					<a href="${pageContext.request.contextPath}/logout">Logout</a>
				</nav>
			</header>
			<div>
				<!-- <video controls width="250">

				    <source src="${pageContext.request.contextPath}/resources/media/videos/video.mp4"
				            type="video/mp4">
				</video>-->
								
			</div>
    		<div class="welcome">
				<h1>Welcome  <%--<% if(request.getAttribute("siteUserRecord") != null && currentUserUsername != null && currentUserUsername.length() > 0){
    			out.print("back, " + currentUserUsername);
    			} %>--%>
    			<%if(request.getAttribute("userRecordWrapper") != null && currentUserUsername != null && currentUserUsername.length() > 0){
        			out.print("back, " + currentUserUsername);
        			} %>
    			
    			
    			</h1>
			</div>
    	</section>
    	<section class="content">
    		<div class="inner-content">
    			<img src="${pageContext.request.contextPath}/resources/media/img/pexels-johannes-plenio-1126373.jpg" />
    			<h1>What is Lorem Ipsum?</h1>
    			<div>
					<p>
						Lorem Ipsum is simply dummy text of the printing 
						and typesetting industry. Lorem Ipsum has been the 
						industry's standard dummy text ever since the 1500s, 
						when an unknown printer took a galley of type and 
						scrambled it to make a type specimen book. It has 
						survived not only five centuries, but also the leap 
						into electronic typesetting, remaining essentially 
						unchanged. It was popularised in the 1960s with the 
						release of Letraset sheets containing Lorem Ipsum 
						passages, and more recently with desktop publishing 
						software like Aldus PageMaker including versions of 
						Lorem Ipsum.
					</p>
    			</div>
    		</div>
    		<div class="inner-content">
    			<img src="${pageContext.request.contextPath}/resources/media/img/pexels-nick-bondarev-4348224.jpg" />
    			<h1>What is Lorem Ipsum?</h1>
    			<div>
					<p>
						Lorem Ipsum is simply dummy text of the printing 
						and typesetting industry. Lorem Ipsum has been the 
						industry's standard dummy text ever since the 1500s, 
						when an unknown printer took a galley of type and 
						scrambled it to make a type specimen book. It has 
						survived not only five centuries, but also the leap 
						into electronic typesetting, remaining essentially 
						unchanged. It was popularised in the 1960s with the 
						release of Letraset sheets containing Lorem Ipsum 
						passages, and more recently with desktop publishing 
						software like Aldus PageMaker including versions of 
						Lorem Ipsum.
					</p>
    			</div>
    		</div>
    	</section>
    	<section>
    	<%--<%out.print(allSiteVideos.get(0).getDateVideoWasCreated());
    	out.print(allSiteVideos.get(0).getVideoTitle());
    	out.print(allSiteVideos.get(0).getVideoImageUrl());%>--%>
    		<div class="displayed-home-videos-capsule">
            	<div class="displayed-home-videos">
            		<c:forEach items="<%=allSiteVideos %>" var="siteVideo" >
            			<div class="single-home-video">
							<div class="home-video-image-capsule">
								<!-- <img src="${siteVideo.getVideoImageUrl()}"/> -->
								<video controls >
									<source src="${pageContext.request.contextPath}/resources/media/videos/video.mp4" 
									type="video/mp4">
								</video>
							</div>
							<div class="home-video-information">
								<h3>Title: ${siteVideo.getVideoTitle()}</h3>
								<!-- <p>${userDownload}</p>-->
								<h3>Added: ${siteVideo.getDateVideoWasCreated()}</h3>
								<h3>Description</h3>
								<p>Contrary to popular belief, Lorem Ipsum is not simply random text. 
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
							<form>
								<input type="text" name="videolistID" placeholder="Videolist ID"/>
								<button type="submit" formmethod="POST" formaction="add-to-videolist" name="videoID" value="${siteVideo.getVideoID()}">Add To Videolist</button>
							</form>
							<form><button type="submit" formmethod="POST" formaction="${pageContext.request.contextPath}/watch-video/${siteVideo.getVideoID()}" name="watchVideoID" value="${siteVideo.getVideoID()}">Watch Video</button></form>
            			</div>
            		</c:forEach>
            	</div>
            </div>
    		<form action="add-video" method="POST">
                <input type="text" name="videoTitle" placeholder="Title"/>
                <input type="text" name="videoImageUrl" placeholder="Image URL"/>
                <input type="submit" value="Create Video" />
            </form>
    	</section>
    </body>
</html>