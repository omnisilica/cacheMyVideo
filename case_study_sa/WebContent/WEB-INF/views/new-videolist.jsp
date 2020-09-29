<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.case_study_sa.entities.SiteUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>New Videolist</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
	<%
    	SiteUser siteUser = (SiteUser)session.getAttribute("siteUserLogin");
    	String siteUserEmail = siteUser.getUserEmail();
    	
    %>
    <body>
    	<div class="welcome-section new-videolist-section">
	    	<header>
	    		<nav>
	    			<a href="${pageContext.request.contextPath}/login-page">Login | </a>
	    			<a href="${pageContext.request.contextPath}/home-page">Home | </a>
					<a href="${pageContext.request.contextPath}/downloads-page">Downloads | </a>
					<a href="${pageContext.request.contextPath}/videolists-page">Videolists</a>
	    		</nav>
	    	</header>
	    	<div class="videolist-form">
	    		<!-- videolist form -->
	    		<div class="form-capsule">
	    			<h1>Hello, <%=siteUserEmail %>. Create a new Videolist</h1>
	    			<form action="${pageContext.request.contextPath}/new-videolists" method="POST">
	    				<input type="text" name="videolistTitle" placeholder="Title" />
	    				<input type="text" name="videolistImageUrl" placeholder="Image URL" />
						<input type="submit" value="Create" />
	    			</form>
	    		</div>
	    	</div>
    	</div>
    </body>
</html>