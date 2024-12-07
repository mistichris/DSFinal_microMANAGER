<!-- /**Display All Users jsp page to display all the users in the 
 * in the user list.
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
		<header>
			<h1 class="center">MicroMANAGER</h1>
		</header>
		<nav class="footer">
			<a class="linkOnDark" href="index.jsp">Home</a> 
			<a class="linkOnDark" href="displayAllProjects">View All Projects</a> 
			<a class="linkOnDark" href="newUser">Add New User</a> 
			<a class="linkOnDark" href="newTask">Add New Task</a> 
			<a class="linkOnDark" href="newProject">Add New Project</a>
		</nav>
		<section class="frame">
			<div><h3 class="center">All Users</h3></div>
			
			<table class="center" id="allUsers">
				<thead>
					<tr>
						<th>User #</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Delete User</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.allUsers}" var="user"  >
						<tr>
							<td>${user.id}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td><a href="deleteUser?userId=${user.id}"><button>Delete User</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p class="center"><span class="error">${messages.usersEmpty}</span></p>
		</section>
		<div class="footer">
			<a href="https://github.com/mistichris/DataStructuresFinal">Git
				Hub Link</a>
		</div>
		<p>&nbsp;</p>
	</div>
</body>
</html>