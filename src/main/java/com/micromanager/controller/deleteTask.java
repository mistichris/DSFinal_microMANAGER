package com.micromanager.controller;

import java.io.IOException;
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
 * Servlet implementation class updateTask
 */
@WebServlet("/deleteTask")
public class deleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get project id from previous page
		System.out.println("In delete task servlet");
		String projectIDstr = request.getParameter("projectId");
		// parse the string id to an int and use it to locate the associated project in
		// the projectQueue
		int projectID = Integer.parseInt(projectIDstr);
		Project projectSelected = ProjectQueue.findProjectByID(projectID);

		// get the taskQueue for the project
		TaskQueue taskQueue = projectSelected.getTaskQueue();

		// get project id from previous page
		String idStr = request.getParameter("taskId");
		// parse the string id to an int and use it to locate the associated task in
		// the TaskQueue
		int taskId = Integer.parseInt(idStr);
		Task taskSelected = taskQueue.findTaskByID(taskId);

		// set projectId to use on the display tasks page
		Map<String, String> previousInputs = new HashMap<String, String>();
		previousInputs.put("projectId", projectIDstr);
		request.setAttribute("previousInputs", previousInputs);

		// remove the task from the project
		taskQueue.removeTask(taskSelected);

		// redirect to the display All Projects page again; project should be removed

		request.getRequestDispatcher("displayAllTasks?projectId=" + projectIDstr).forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
