<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.case_study_sa.entities.SiteUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>New Download</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <%
    	SiteUser siteUser = (SiteUser)session.getAttribute("siteUserLogin");
    	String siteUserEmail = siteUser.getUserEmail();
    	
    %>
    <body>
    	<div class="welcome-section new-download-section">
	    	<header>
	    		<nav>
	    			<a href="${pageContext.request.contextPath}/login-page">Login | </a>
	    			<a href="${pageContext.request.contextPath}/home-page">Home | </a>
					<a href="${pageContext.request.contextPath}/downloads-page">Downloads | </a>
					<a href="${pageContext.request.contextPath}/videolists-page">Videolists</a>
	    		</nav>
	    	</header>
	    	<div class="download-form">
	    		<!-- download form -->
	    		<div class="form-capsule">
	    			<h1>Hello, <%=siteUserEmail %>. Create a new Download</h1>
	    			<form action="new-download" method="POST">
	    				<input type="text" name="downloadTitle" placeholder="Title" />
	    				<input type="text" name="downloadImageUrl" placeholder="Image URL" />
						<input type="submit" value="Create" />
	    			</form>
	    		</div>
	    	</div>
    	</div>
    </body>
</html>