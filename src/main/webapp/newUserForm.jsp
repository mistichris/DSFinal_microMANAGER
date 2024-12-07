<!-- /**New User Input Form jsp page to enter new user
 * user information to create a new user and enter into the
 * user list. 
 * 
 * @author Misti Christianson 
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Windows 11
* IDE: Eclipse for Java Developers Version: 2024-06 (4.32.0)
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Data Structures: MicroManager</title>
<link href="style.css" rel="stylesheet" type="text/css" rel="stylesheet" />

</head>

<body>
	<div class="wrapper">
		<div class="wrapper">
			<header>
				<h1 class="center">MicroMANAGER</h1>
				<h2></h2>
			</header>
			<nav class="footer">
				<a class="linkOnDark" href="index.jsp">Home</a> <a
					class="linkOnDark" href="displayAllProjects">View All Projects</a>
				<a class="linkOnDark" href="displayAllUsers">View All Users</a> <a
					class="linkOnDark" href="displayAllUsers">Display All Users</a> <a
					class="linkOnDark" href="newTask">Add New Task</a> <a
					class="linkOnDark" href="newProject">Add New Project</a>
			</nav>
			<section class="frame">
				<h3>Insert New User Information</h3>
				<form id="newUser" name="newUser" onsubmit="return validateForm()"
					method="post" action="newUser">
					<p>
						<label for="firstName">First Name: </label> <input type="text"
							name="firstName" id="firstName"
							value="${previousInputs.firstName}" /> <span id="first-error"
							class="error">${messages.firstName}</span>
					</p>

					<p>
						<label for="lastName">Last Name:</label> <input type="text"
							name="lastName" id="lastName" value="${previousInputs.lastName}" />
						<span id="last-error" class="error">${messages.lastName}</span>
					</p>

					<p>
						<input type="submit" name="submit" id="submit" value="Submit" />
						<input type="reset" name="reset" id="reset" value="Reset" />
					</p>
				</form>
				<script src="validName.js"></script>
			</section>
			<div class="footer">
				<a href="https://github.com/mistichris/DataStructuresFinal">Git
					Hub Link</a>
			</div>

			<p>&nbsp;</p>
		</div>
</body>
</html>