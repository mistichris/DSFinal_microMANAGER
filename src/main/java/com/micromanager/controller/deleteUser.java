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
 * Servlet implementation class updateUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteUser() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get project id from previous page
		System.out.println("In deleteUser servlet");
		String idStr = request.getParameter("userId");
		// parse the string id to and int and use it to locate the associated user in
		// the userHelper
		int userID = Integer.parseInt(idStr);
		User userSelected = UserHelper.findUserByID(userID);

		// remove the project from the project queue
		UserHelper.removeUser(userSelected);

		// redirect to the display All Projects page again; project should be removed
		request.getRequestDispatcher("displayAllUsers.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getRequestDispatcher("displayAllUsers").forward(request, response);
		doGet(request, response);
	}

}
