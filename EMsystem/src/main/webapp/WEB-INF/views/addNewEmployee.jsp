<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Employee</title>
<link rel="stylesheet" href="newEmp.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="common.js" ></script>
<script src="script.js" ></script>
<script src="validation.js" ></script>
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
				<input class="logout-btn" type="submit" value="logout" onclick="setDarkModePreference('false')"/>
			</form>
		</div>
	</div>
	</section>
	<section class="empform">
		<div class="heading">
			<h1>Add new Employee</h1>
		</div>
		<div class="box">
			<div class="form">
			<form action="saveDetails" method="post">
			<div class="details">
				<div class="personal-details">
				<h3>Personal details</h3>
				<div class="input-box">
						Name<br><input type="text" required="required" name="name" id="name">
						<span class="error-message" id="nameError"></span>
					</div>
					<div class="input-box">
						Email id:<br><input type="email" required="required" name="email" id="email">
						 <span class="error-message" id="emailError"></span>
					</div>
					<div class="input-box">
						Mobile No.<br><input type="text" required="required" name="mobile"  id="mobile">
						<span class="error-message" id="mobileError"></span>
					</div>
					<div class="input-box">
						City<br><input type="text" required="required" name="city" id="city">
						<span class="error-message" id="cityError"></span>
					</div>
				</div>
				<div class="empl-details">
				<h3>Employment details</h3>
				<div class="input-box">
						Department<br><input type="text" required="required" name="department" id="department">
						<span class="error-message" id="departmentError"></span>
					</div>
					<div class="input-box">
						Designation<br><input type="text" required="required" name="designation" id="designation">
						 <span class="error-message" id="designationError"></span>
					</div>
					<div class="input-box">
						Date of Joining<br><input type="date" required="required" name="date" id="date" >
						<span class="error-message" id="dateError"></span>
					</div>
					<div class="input-box">
						Salary<br><input type="text" required="required" name="salary" id="salary">
						<span class="error-message" id="salaryError"></span>
					</div>
				</div>
			</div>
				<div class="btn">
					<input type="submit" value="Save Details" class="save-btn" onclick="validateForm()">
				</div>
				<div style="color: green; margin-top: 5px;">
			<% 
			if(request.getAttribute("success")!=null){
			out.println(request.getAttribute("success"));
			}
			%>
			</div>
			</form>
		</div>
		</div>
	</section>

</body>
</html>