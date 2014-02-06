<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html;charset=UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <link type="text/css" rel="stylesheet" href="stylesheet.css"/>
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
        <div class="box">
            <form action="regme" method="post">
                <table border="0">
                    <tr>
                        <td align="right"> <label> Your name:</label></td>
                        <td><input class="field" id="user" width="199" type="text" name="name" placeholder="User Name" required/></td>
                    </tr>
                    <tr>
                        <td><label> Your patronymic: </label></td>
                        <td><input class="field" id="pass" width="199" type="text" name="patronymic" placeholder="User patronymic" required/></td>
                    </tr>
                    <tr>
                        <td><label> Your e-mail address: </label></td>
                        <td><input class="field" id="pass" width="199" type="text" name="mail" placeholder="User e-mail address" required/></td>
                    </tr>
                    <tr>
                        <td><label> Choose your login: </label></td>
                        <td><input class="field" id="pass" width="199" type="text" name="login" placeholder="User login" required/></td>
                    </tr>
                    <tr>
                        <td><label> Your password: </label></td>
                        <td><input class="field" id="passz" width="199" type="password" name="passwd" placeholder="********" required/></td>
                    </tr>
                    <tr>
                        <td><label> Password confirmation: </label></td>
                        <td><input class="field" id="pass" width="199" type="password" name="Confirm" placeholder="Confirm password" required/></td>
                    </tr>
                </table>
                <input id="Registration" type="submit" value="Register" />
            </form>
	</div>
    </div>
</body>
</html>