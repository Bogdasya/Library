<%-- 
    Document   : ForgotPass
    Created on : 09.09.2013, 19:38:24
    Author     : bogdasya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>password_recovery</title>
        <link type="text/css" rel="stylesheet" href="RecoveryPass.css"/>
    </head>
    <body>
        <div class="content">
            <img src="Logo.jpg" width="260" height="40" alt="logo"/>
                <div class="box">
                    <form action="recovery" method="post">
                        <h3>Password recovery</h3>
                        <input class="field" id="pass" width="199"  name="mail" placeholder="Enter your mail"/>
                        <input id="Send" type="submit" value="Send me password"/>
                    </form>
                </div>
        </div>
    </body>
</html>
