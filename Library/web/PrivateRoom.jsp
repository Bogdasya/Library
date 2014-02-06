<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="stylesheetPrivateRoom.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Private Room</title>
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
                <div id="Greating">
                    <span> Hello, <%= request.getAttribute("User") %>. Choose action. </span>
                </div>
        </div>
                <div class="Control">
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
                    </div>
                <div class="box">
                    <form action="adding" method="post">
                    <p id="Title">Personal information</p>
                    <p class="list">Your name - <%= request.getAttribute("Name") %> </p>
                    <p class="list">Your login - <%= request.getAttribute("User") %> </p>
                    <p class="list">Your mail - <%= request.getAttribute("Email") %> </p>
                    <p class="list">Your password - <%= request.getAttribute("Passwd") %> </p>
                    </form>
                </div>
                
                <div>
                    <a href="#openModal"><input id ="AddButton" type="button" value="Add book"/></a>
                </div>
                    <div id="openModal" class="modalDialog">
                       <div>
                            <a href="#close" title="Закрыть" class="close">X</a>
                                <h2>Adding book</h2>
                                <form action="adding" method="post">
                                    <table border="0">
                                        <tr>
                                            <td> <label> Book title:</label></td>
                                            <td><input class="field" id="title" width="199" type="text" name="title" placeholder="Book title" /></td>
                                        </tr>
                                        <tr>
                                            <td><label> Author: </label></td>
                                            <td><input class="field" id="author" width="199" type="text" name="author" placeholder="Author's surname" /></td>
                                        </tr>
                                        <tr>
                                            <td><label> Genre: </label></td>
                                            <td><input class="field" id="genre" width="199" type="text" name="genre" placeholder="Book's genre" /></td>
                                        </tr>
                                        <tr>
                                            <td><label> Insert ISDN: </label></td>
                                            <td><input class="field" id="isdn" width="199" type="text" name="isdn" placeholder="Book's isdn" /></td>
                                        </tr>
                                        <tr>
                                            <td><label> Number of pages: </label></td>
                                            <td><input class="field" id="numbers" width="199" type="text" name="num" placeholder="Number" /></td>
                                        </tr>
                                    </table>
                                        <input id="Adding" type="submit" value="Add book" />
                                </form>
                        </div>
                    </div>
            
    </body>
</html>
