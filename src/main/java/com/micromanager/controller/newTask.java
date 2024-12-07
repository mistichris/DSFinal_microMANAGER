/**Servlet to complete the processing needed to retrieve the information entered
 * on the newTask.jsp page and enter in a new Task object.
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
import com.micromanager.Task;
import com.micromanager.TaskQueue;
import com.micromanager.User;
import com.micromanager.UserHelper;

/**
 * Servlet implementation class newTask
 */
@WebServlet("/newTask")
public class newTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In add task to project servlet");
//		// set attributes to print to page (request attribute)
//		
//		String idStr = request.getParameter("projectId");
//		//parse the string id to and int and use it to locate the associated project in the project queue
//		int projectID = Integer.parseInt(idStr);
//		Project projectSelected = ProjectQueue.findProjectByID(projectID);
//		String projectTitle = projectSelected.getTitle();
//		//pass the project title to be displayed in the page
//		request.setAttribute("projectTitle", projectTitle);
//		
		
		// users to put in drop down menu
		request.setAttribute("allUsers", UserHelper.getAllUsers());

		// Prepare message for if there are no users to select
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		// Shows a message if there are no Users to select from drop down
		if (UserHelper.isEmpty()) {
			messages.put("usersEmpty", "There are no users available to assign to the task. Please add users first.");
		}

		// projects to put in drop down menu
		request.setAttribute("allProjects", ProjectQueue.getAllProjects());

		// Shows a message if there are no Users to select from drop down
		if (ProjectQueue.isEmpty()) {
			messages.put("projectsEmpty",
					"There are no projects available to assign to the task. Please a project first.");
		}

		request.getRequestDispatcher("/newTaskForm.jsp").forward(request, response);
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
		String projectStr = request.getParameter("project"); // should be project ID

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

		// parse projectId string to an int; find Project by ID
		int projectID = Integer.parseInt(projectStr);
		Project project = ProjectQueue.findProjectByID(projectID);

		// add new task
		// create a new instance of TaskQueue Helper

		// create a new task object
		Task task = new Task(title, description, dueDate, assignedTo, project);

		// add the task object to the taskQueue
		project.addTaskToProject(task);
		
		//set projectId to use on the display tasks page
		Map<String, String> previousInputs = new HashMap<String, String>();
		previousInputs.put("projectId", projectStr);
		request.setAttribute("previousInputs", previousInputs);

		// return back to insert new task and display message of successful entry
		request.getRequestDispatcher("displayAllTasks?projectId="+projectStr).forward(request, response);
	}

}
