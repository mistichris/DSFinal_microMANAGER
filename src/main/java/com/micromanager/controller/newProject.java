/**Servlet to complete the processing needed to retrieve the information entered
 * on the newProject.jsp page and enter in a new User object.
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
package com.micromanager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micromanager.Project;
import com.micromanager.ProjectQueue;
import com.micromanager.User;
import com.micromanager.UserHelper;

/**
 * Servlet implementation class newProject
 */
@WebServlet("/newProject")
public class newProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// set attributes to print to page (request attribute)
		request.setAttribute("allUsers", UserHelper.getAllUsers());

		// Prepare message for if there are no users to select
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		// Shows a message if there are no users to select from drop down
		if (UserHelper.isEmpty()) {
			messages.put("usersEmpty", "There are no users available to assign to the Project. Please add users first.");
		}

		request.getRequestDispatcher("/newProjectForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// obtain all parameters from page once submit has been clicked
		// set attributes to retrieve data
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String dueDateStr = request.getParameter("dueDate");
		String assignedToStr = request.getParameter("assignedTo"); // should be a user ID

		// change attributes to appropriate types
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dueDate = null;
		try {
			dueDate = sdf.parse(dueDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// parse userId string to an int; find User by ID
		int assignedToID = Integer.parseInt(assignedToStr);
		User assignedTo = UserHelper.findUserByID(assignedToID);

		// create a new project object
		Project project = new Project(title, description, dueDate, assignedTo);

		// Add Project to project queue
		ProjectQueue.addProject(project);

		// redirect back to displayAllTasks (aka displayAllTasks servlet)
		response.sendRedirect("displayAllProjects");

	}

}
