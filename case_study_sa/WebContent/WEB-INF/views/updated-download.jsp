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
    <body class="downloads-body">
    	<div class="download-section">
	    	<header>
				<nav>
					<a href="login-page">Login | </a>
					<a href="home-page">Home | </a>
					<a href="new-download-page">New Download | </a>
					<a href="videolists-page">Videolists</a>
				</nav>
			</header>
	    	
			<div>
				<div class="download-image-capsule">
					<img src="${downloadToBeUpdated.downloadImageUrl}"/>
				</div>
				<form action="${pageContext.request.contextPath}/download-updated" method="POST">
					<input type="text" name="downloadTitle" placeholder="${downloadToBeUpdated.downloadTitle}" />
	    			<input type="text" name="downloadImageUrl" placeholder="${downloadToBeUpdated.downloadImageUrl}" />
					<!-- HOW DO I DO THIS: SECURITY RISK -->
					<input style="display:none" name="downloadID" value="${downloadToBeUpdated.downloadID }"/>
					<input type="submit" value="Update" />
				</form>
			</div>
	    	
    	</div>
    </body>
</html>