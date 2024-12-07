/**Servlet to complete the processing needed for the displayAllProjects.jsp page.
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
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micromanager.ProjectQueue;
import com.micromanager.UserHelper;

/**
 * Servlet implementation class displayAllProjects
 */
@WebServlet("/displayAllProjects")
public class displayAllProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayAllProjects() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create variables to add new users to user list

		// setting attribute names on the .jsp page
		request.setAttribute("allProjects", ProjectQueue.getAllProjects());

		// Prepare messages for errors.
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		// Shows a message if there are no Projects to display
		if (ProjectQueue.isEmpty()) {
			messages.put("projectsEmpty",
					"There are no projects to display. Click 'Add New Project' to add additional projects.");
		}

		// executes the path, request, and response
		request.getRequestDispatcher("displayAllProjects.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
