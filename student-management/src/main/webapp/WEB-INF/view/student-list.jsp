<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>StudentList</title>

<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourcesFolder/css/my-style-sheet.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1 align="center">SPRING MAVEN MVC PROJECT</h1>
		<h1 align="center">Student Management</h1>

		<br>

		<div align="center">
			<h3>
				This is a User Management Application where <br>User <br>can
				CREATE, Read, Update and Delete.
			</h3>

		</div>

		<br>

		<form action="showAddStudentPage">
			<input class="btn btn-info" type="submit" value="ADD">
		</form>
		<hr>
		<table border="1" class="table table-success table-striped">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>

				</tr>
			</thead>
			<c:forEach var="student" items="${students }">
				<tr>

					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a
						href="/student-management/updateStudent?userId=${student.id}">UPDATE</a></td>
					<td><a
						href="/student-management/deleteStudent?userId=${student.id}"
						onclick="if(!(confirm('Are you sure you want to delete this student?')))return false">DELETE</a></td>


					<br>
				</tr>
			</c:forEach>

		</table>
		<br>
		<h4>
			Link to Login to Facebook page. <a href="https://www.facebook.com/">click
				here</a>
		</h4>
		<h4>
			Link to Login to Gmail page. <a href="https://www.gmail.com/">click
				here</a>
		</h4>
	</div>
	<div align="center">

		<img alt="student pic"
			src="/student-management/URLToReachImagesFolder/students.jpg"
			style="vertical-align: middle; margin: 50px 0px">
	</div>
	<br>

</body>
</html>