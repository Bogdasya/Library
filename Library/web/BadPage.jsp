<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="stylesheet" rel="stylesheet" href="stylesheetBadPage.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>Bad Page</title>
        <link type="text/css" rel="stylesheet" href="stylesheetBadePage.css"/>
    </head>
    <body>
        <div class="content">
            <img src="Logo.jpg" width="260" height="40" alt="logo"/>
        </div>
        
        <div class ="form">
           <span> This page does not exist or has not been created.
               Return to the main menu</span>
        </div>
        <input class="Registration"  id ="Registration" type="submit" value="Main Page" onclick="location.href='index.jsp'"/>
    </body>
</html>
