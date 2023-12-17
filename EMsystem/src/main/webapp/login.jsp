<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
<script src="script.js" defer></script>
<script src="common.js" ></script>
</head>
<body>
	<section class="navsection">
	<div class="navbar">
		<div class="logo">
			<h1>EMSystem</h1>
		</div>	
		<div class="darkmode">
				<input class="toggle-btn" type="button" value="Darkmode" onclick="toggleDarkMode();setDarkModePreference('is');"/>
		</div>
	</div>
	</section>
	<section class="login">
		<div class="box">
			<div class="form">
		<form action="verify" method="post">
		<h2>Sign in</h2>
			<div class="input-box">
				<input type="text" required="required" name="email">
				<span>Username</span>
				<i></i>
			</div>
			<div class="input-box">
				<input type="password" required="required" name="password">
				<span>Password</span>
				<i></i>
			</div>
			<div style="color:red; margin-top: 5px;">
			<% 
			if(request.getAttribute("error")!=null){
			out.println(request.getAttribute("error"));
			}
			%>
			</div>
			<div class="links">
				<a href="#" >Forgot Password</a>
				<a href="#" >Sign up</a>
			</div>
			<input type="submit" value="login">
		</form>
		</div>
		</div>
	</section>
</body>
</html>