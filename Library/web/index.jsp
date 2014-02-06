<%-- 
    Document   : index
    Created on : 12.07.2013, 10:29:43
    Author     : bogdan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
        <link type="text/css" rel="stylesheet" href="stylesheetMainPage.css"/>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Kavoon">
    </head>
    <body>
        <div class="content">
            <img src="Logo.jpg" width="260" height="40" alt="logo"/>
            <div class="lang">	
                <ul id="nav">
                    <li>
                        <a href="#" title="Change Lang">Language</a>
                        <ul>
                            <li><a href="#">Rus</a></li>
                            <li><a href="#">Eng</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="SortBox">
                <select>
                    <option>Sort by...</option>
                    <option>Name</option>
                    <option>Author</option>
                    <option>Genre</option>
                    <option>ISDN</option>
                </select>
                <input class="SearchPanel" name="searchpanel"  type="text" placeholder="Insert here"/>
                <select class="SearchBox">
                    <option>Search by...</option>
                    <option>Name</option>
                    <option>Author</option>
                    <option>Genre</option>
                    <option>ISDN</option>
                </select>
                <input id ="SearchButton" type="submit" value="Search"/>
                    <div class="Gallery">
                        <h2>Book Covers </h2>
                    </div>
            </div>
           
            <div class="form">
                <p id ="Name"> Authorize yourself</p>
                <form action="log" method="post">
                <input class="field" id="user" width="199" type="text" name="name" placeholder="Login"/>
                <input class="field" id="pass" width="199" type="password" name="Password" placeholder="Password"/>
                <input class="Registration" id ="Login" type="submit" value="Login"/>
                </form>
                <input class="Registration" id ="forgot" type="submit" value="I forgot" onclick="location.href='ForgotPass.jsp'"/>
                <input class="Registration"  id ="Registration" type="submit" value="Registration" onclick="location.href='register.jsp'"/>
            </div>
            
        </div>         
    </body>
</html>
