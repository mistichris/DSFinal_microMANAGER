package com.micromanager.controller;

import java.io.IOException;
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
 * Servlet implementation class updateProject
 */
@WebServlet("/deleteProject")
public class deleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProject() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get project id from previous page
		System.out.println("In deleteProject servlet");
		String idStr = request.getParameter("projectId");
		//parse the string id to and int and use it to locate the associated project in the project queue
		int projectID = Integer.parseInt(idStr);
		Project projectSelected = ProjectQueue.findProjectByID(projectID);
		
		//remove the project from the project queue
		ProjectQueue.deleteProject(projectSelected);
		
		//redirect to the display All Projects page again; project should be removed
		request.getRequestDispatcher("displayAllProjects.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
