<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees list</title>
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
				<input class="logout-btn" type="submit" value="logout" onclick="setDarkModePreference()"/>
			</form>
		</div>
	</div>
	</section>
	<section class="employee-list">
		<div class="heading">
			<h1>List of All Employees</h1>
		</div>
		<div class="list-table">
			<table class="list">
			<tr>
				<th>EID</th>
				<th>Employee Name</th>
				<th>Email Id</th>
				<th>Mobile No</th>
				<th>city</th>
				<th>Update</th>
				<th>Delete</th>
				<th>More Details</th>
			</tr>
			<%
			ResultSet res=(ResultSet)request.getAttribute("employees");
			while(res.next()){
			%>
			<tr>
				<td><%=res.getString(1) %></td>
				<td><%=res.getString(2) %></td>
				<td><%=res.getString(3) %></td>
				<td><%=res.getString(4) %></td>
				<td><%=res.getString(5) %></td>
				<td class="delete"><a href="delete?emailId=<%=res.getString(3)%>">Delete</a></td>
				<td class="update"><a href="update?emailId=<%=res.getString(3)%>&mobile=<%=res.getString(4)%>">Update</a></td>
				<td class="update"><a href="more?Id=<%=res.getString(1)%>">Details</a></td>
			</tr>
			
			<%}%>
			
			
			
			</table>
		</div>
	</section>
</body>
</html>