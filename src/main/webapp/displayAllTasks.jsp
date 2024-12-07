<!-- /**Display All tasks jsp page to display all the tasks in the 
 * 	in the taskQueue for the selected project.
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
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
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
			<a class="linkOnDark" href="index.jsp">Home</a> <a class="linkOnDark"
				href="displayAllProjects">View All Projects</a> <a
				class="linkOnDark" href="displayAllUsers">Display All Users</a> <a
				class="linkOnDark" href="newUser">Add New User</a> <a
				class="linkOnDark" href="newTask">Add New Task</a> <a
				class="linkOnDark" href="newProject">Add New Project</a>
		</nav>
		<section class="frame">
			<h3 class="center">All Tasks for Project ${project.getTitle()} </h3>
			<table class="center" id="allTasks">
				<thead>
					<tr>
						<th>Task. #</th>
						<th>Title</th>
						<th>Description</th>
						<th>Owner</th>
						<th>Due Date</th>
						<th>Delete Task</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allTasks.getAllTasks()}" var="task">
						<tr>
							<td>${task.id}</td>
							<td>${task.taskTitle}</td>
							<td>${task.description}</td>
							<td>${task.assignedTo.getFirstName()} ${task.assignedTo.getLastName()}</td>
							<td><fmt:formatDate pattern = "MM-dd-yyyy" value = "${task.dueDate}" /></td>
							<td><a href="deleteTask?taskId=${task.id}&projectId=${project.getId()}"><button>Delete Task</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p class="center">
				<span class="error">${messages.tasksEmpty}</span>
			</p>
		</section>
		<div class="footer">
			<a href="https://github.com/mistichris/DataStructuresFinal">Git
				Hub Link</a>
		</div>
		<p>&nbsp;</p>
	</div>
</body>
</html>