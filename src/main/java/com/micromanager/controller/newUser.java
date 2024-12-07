/**Servlet to complete the processing needed to retrieve the information entered
 * on the newUser.jsp page and enter in a new User object.
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
 * Servelet implementation class newUser
 */
@WebServlet("/newUser")
// for the jsp in the /WEB-INF/newUser.jsp
public class newUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public newUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/newUserForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Postprocess request: gather and validate submitted data and display the
		// result in the same JSP.

		System.out.println("In Servlet newUser");
		// Create a Bundle of errors in the form of Map
		Map<String, String> messages = new HashMap<String, String>();
		Map<String, String> previousInputs = new HashMap<String, String>();
		request.setAttribute("messages", messages);

		// Get the input values from the website
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		// If error occur, previous entered data will be reflected
		previousInputs.put("firstName", firstName);
		previousInputs.put("lastName", lastName);

		// Check for valid entry of first/last name values
		if (!UserHelper.validateName(firstName))

			// If error occur, enter message for error message
			messages.put("firstName", "Please enter a valid first name");

		if (!UserHelper.validateName(lastName))

			// If error occur, enter message for error message
			messages.put("lastName", "Please enter a valid first name");

		if (messages.isEmpty()) {

			// If no error occur, redirect to the response website
			User user = new User(firstName, lastName);
			UserHelper.addUser(user);
			response.sendRedirect("displayAllUsers");
		} else {

			// Set this bundle into the request attribute; pass the data to the requested website
			request.setAttribute("previousInputs", previousInputs);
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("/newUserForm.jsp").forward(request, response);
		}

	}
}
