
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Students</title>

<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourcesFolder/css/add-student.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

</head>

<body>

	<!-- Create a Spring form where the user can enter Data  -->
	<div align="center">

		<h1>ADD STUDENTS</h1>
		<form:form action="save-student" modelAttribute="student"
			method="POST">

			<form:hidden path="id" />
			<label>Name: </label>
			<form:input path="name" />
			<br />
			<label>Mobile: </label>
			<form:input path="mobile"/>
			<br />
			<label>Country: </label>
			<form:input path="country" />
			<br />
			<br />

			<input type="submit" value="submit" class="btn btn-outline-success">
		</form:form>
	</div>

</body>
</html>