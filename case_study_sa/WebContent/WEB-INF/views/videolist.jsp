<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Videolists</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <body>
    	<div class="videolist-section">
	    	<header>
				<nav>
					<a href="${pageContext.request.contextPath}/login-page">Login | </a>
					<a href="${pageContext.request.contextPath}/home-page">Home | </a>
					<a href="${pageContext.request.contextPath}/downloads-page">Downloads | </a>
					<a href="${pageContext.request.contextPath}/new-videolist-page">New Videolist </a>
				</nav>
			</header>
	    	<div class="displayed-videolists-capsule">
	    		<div class="displayed-videolists">
	    			<c:forEach items="${currentUserVideolists}" var="userVideolists" >
	    				<div class="single-videolist">
	    					<div class="videolist-image-capsule">
	    						<img src="${userVideolists.videolistImageUrl}"/>
	    					</div>
	    					<div class="videolist-information">
	    						<h6>Title: ${userVideolists.videolistTitle}</h6>
								<h6>Created: ${userVideolists.dateVideolistWasCreated}</h6>
								<h6>Videolist ID: ${userVideolists.videolistID}</h6>
								<a href="${pageContext.request.contextPath}/view-videolist/${userVideolists.videolistID}">View Videolist</a>
	    					</div>
	    				</div>
	    			</c:forEach>
	    		</div>
	    	</div>
    	</div>
    </body>
</html>