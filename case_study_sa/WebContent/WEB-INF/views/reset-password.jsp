<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Reset Password</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    </head>
    <body>
        <div class="full-body-capsule">
            <header>
                <a>METASTACK</a>
            </header>
            <form class="form-capsule">
                <p>Enter your email or username and we'll 
                send you a link to reset your password.</p>
                <input type="text" placeholder="Email or Username"/>
                <input type="submit" placeholder="Send Link"/>
                <p>Log In</p>
                <div>
                    <p>Thanks! Please Check Your Email To Reset Your Password.</p>
                </div>
            </form>
        </div>
    </body>
</html>