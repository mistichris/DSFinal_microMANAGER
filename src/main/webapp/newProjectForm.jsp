<!-- /**New Project Input Form jsp page to enter new project
 * information to create a new project and enter into the
 * project queue. 
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
	       	<a class="linkOnDark" href="displayAllProjects">Display All Projects</a>
			<a class="linkOnDark" href="displayAllUsers">View All Users</a> 
			<a class="linkOnDark" href="displayAllTasks">View All Tasks</a> 
			<a class="linkOnDark" href="newUser">Add New User</a> 
			<a class="linkOnDark" href="newTask">Add New Task</a> 
		</nav>
	    <section class="frame">
			<h3>Insert New Project Information</h3>
		        <form id="newProject" name="newProject" method="post" action="newProject">
		       	<p>
                    <label for="title">Title: </label>
                    <input type="text" name="title" id="title" value="${fn:escapeXml(param.title)}" required/>
                	<span class="error">${messages.title}</span>
                </p>
                
                <p>
                    <label for="description">Description: </label>
                    <input type="text" name="description" id="description" value="${fn:escapeXml(param.description)}" required/>
                	<span class="error">${messages.description}</span>
                </p>
                
                <p>
                    <label for="dueDate">Due Date: </label>
                    <input type="date" name="dueDate" id="dueDate" placeholder="MM/DD/YYY" value="${fn:escapeXml(param.dueDate)}" required/>
                	<span class="error">${messages.dueDate}</span>
                </p>
                
                <p>
                    <label for="assignedTo">Project Owner: </label>
	                    <select name="assignedTo" id="assignedTo" required>
	                    	<option value="">Select A User</option>
		                    <c:forEach items="${requestScope.allUsers}" var="user"  >
								<option value="${user.id}">${user.firstName} ${user.lastName}</option>
							</c:forEach>
	                    </select>
	             </p>
	             <p><span class="error">${messages.usersEmpty}</span></p>
                
                <p>
                    <input type="submit" name="submit" id="submit" value="Submit" />
                    <input type="reset" name="reset" id="reset" value="Reset" />
                </p>
            </form>
	
	    </section>
	    <div class="footer">
			<a href="https://github.com/mistichris/DataStructuresFinal">Git
				Hub Link</a>
		</div>
		<p>&nbsp;</p>
	</div>
</body>
</html>