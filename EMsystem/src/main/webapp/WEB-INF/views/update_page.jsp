<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
<link rel="stylesheet" href="employeesList.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="common.js" ></script>
<script src="script.js" ></script>
</head>
<body>
	<section class="navsection">
	<div class="navbar">
		<div class="logo">
			<h1>EMSystem</h1>
		</div>
		<div class="navlinks">
			<a href="listEmp">View All Employees</a>
			<a href="saveDetails">Add New Employee</a>
			<form class="searchbox" action="search" method="post">
 				<input type="text" placeholder="Search by Eid" name="search">
  				<button type="submit"><i class="fa fa-search"></i></button>
			</form>
		</div>
		<div class="logout">
			<form action="logout" method="post">
				<input class="logout-btn" type="submit" value="logout" onclick="setDarkModePreference()" />
			</form>
		</div>
	</div>
	</section>
	<section class="employee-list">
		<div class="heading">
			<h1>Upadate Details</h1>
		</div>
		<div class="update-box">
			<form action="update" method="post">
		<div class="input-box">
				Email Id: <br>
				<input type="text" name="emailId" value="<%=request.getAttribute("email") %>">
			</div>
			<div class="input-box">
				Mobile no. <br>
				<input type="text" name="mobile" value="<%=request.getAttribute("mobile") %>">
			</div>
			<div class="save">
				<input type="submit" value="save" class="save-btn">
			</div>
		</form>
		</div>
	</section>
</body>
</html>