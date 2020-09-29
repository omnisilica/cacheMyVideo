<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
    <%--<%@ page errorPage="error" %>--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <body>
        <div class="full-body-capsule">
            <div class="form-capsule">
                <!--<form:form action="login" method="POST" modelAttribute="siteUser"> 
                    <h1>MyDOWNLOADS</h1>
                    
                    <form:input type="text" path="userEmail" placeholder="Email or Username"/>
                    <form:errors path="userEmail" />
                    <form:input type="password" path="userPassword" placeholder="Password"/>
                 	<form:errors path="userPassword" />
                    <form:input type="submit" path="userEmail" value="Login" placeholder="Log In"/>
                    <div>
                        <span><a href="registration" class="sign-up-link">Sign Up</a></span><span> | </span><span><a href="reset-password" class="forgot-password-link">Forgot Password?</a></span>
                    </div>
                </form:form>-->
                <h1>MyDownloads</h1>
                <h6>(not really...)</h6>
                <form action="${pageContext.request.contextPath}/login" method="POST">
                    <input type="text" name="userEmail" placeholder="Email or Username"/>
                    <input type="password" name="userPassword" placeholder="Password"/>
                    <input type="submit" value="Login" placeholder="Log In"/>
                </form>
                <div class="extra-links">
                    <span><a href="sign-up" class="sign-up-link">Sign Up</a></span><span> | </span><span><a href="reset-password" class="forgot-password-link">Forgot Password?</a></span>
                </div>
            </div>
        </div>
    </body>
</html>