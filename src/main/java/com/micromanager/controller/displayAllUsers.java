/**Servlet to complete the processing needed for the displayAllUsers.jsp page.
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

import com.micromanager.User;
import com.micromanager.UserHelper;

/**
 * servlet implementation class displayAllUsers
 */
@WebServlet("/displayAllUsers")
public class displayAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayAllUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create variables to add new users to user list
//		String ln1 = "Smith";
//		String fn1 = "Beth";
//
//		String ln2 = "Sanchez";
//		String fn2 = "Rick";
//
//		String ln3 = "Smith";
//		String fn3 = "Summer";
//
//		User user1 = new User(fn1, ln1);
//		User user2 = new User(fn2, ln2);
//		User user3 = new User(fn3, ln3);
//
//		// create an instance of the UserHelper class
////		UserHelper displayAll = new UserHelper();
//
//		// add some users to users list to start off the page
//		UserHelper.addUser(user1);
//		UserHelper.addUser(user2);
//		UserHelper.addUser(user3);

		// PreProcess request: retrieve list of users and display the result in the same
		// JSP.
		request.setAttribute("allUsers", UserHelper.getAllUsers());

		// set path to display list of projects
		String path = "/displayAllUsers.jsp";

		// Prepare messages for errors.
		Map<String, String> messages = new HashMap<String, String>();
		request.setAttribute("messages", messages);
		

		// Shows a message if there are no Users to display
		if (UserHelper.isEmpty()) {
			messages.put("usersEmpty", "There are no users to display. Click 'Add New Users' to add additional users.");
		}

		// executes the path, request, and response
		getServletContext().getRequestDispatcher(path).forward(request, response);

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
