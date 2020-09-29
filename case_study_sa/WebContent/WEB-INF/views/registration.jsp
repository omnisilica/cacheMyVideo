<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <body>
        <div class="full-body-capsule">
            <div class="form-capsule">
                <h1>MyDownloads</h1>
                <form action="registration" method="POST">
                    <input type="email" name="userEmail" placeholder="Email"/>
                    <input type="text" name="userUsername" placeholder="Username (optional)"/>
                    <input type="password" name="userPassword" placeholder="Password"/>
                    <input type="submit" value="Sign Up"/>
                </form>
                <div class="policies">
                    <p>By signing up, you agree to our <a href="terms">Terms</a> , 
                    <a href="data-policy">Data Policy</a> and <a href="cookie-policy">Cookies Policy</a>.</p>
                </div>
                <p>Have An Account? <span class="login-in-link"><a href="login-page">Log In</a></span></p>
            </div>
        </div>
    </body>
</html>