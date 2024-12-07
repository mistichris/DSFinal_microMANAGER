/**
 * User class that defines the user attributes and ties the
 * user to the task and project priority queues.
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
package com.micromanager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */
public class User implements Comparable<User>{
	private int id;
	private static int idGenerator = 1;
	private String firstName;
	private String lastName;
//	private boolean isManager;
//	private String username;
//	private String password;
//	PriorityQueue<Task> taskQueue;
//	PriorityQueue<Project> projectQueue;
	


	/**
	 * 
	 */
	public User() {
		super();
		this.id = User.idGenerator++;
		this.firstName = "";
		this.lastName = "";
//		this.isManager = false;
//		this.username = "";
//		this.password = "password";
//		this.taskQueue = new PriorityQueue<Task>();
//		this.projectQueue = new PriorityQueue<com.micromanager.Project>();
	}

	/**
	 * Constructor that accepts parameters and opens an empty task Queue and empty projecte queue
	 * @param firstName
	 * @param lastName
	 * @param isManager
	 * @param username
	 * @param password
	 * @param taskQueue
	 * @param projectQueue
	 */
	public User(String firstName, String lastName) {
		super();
		this.id = User.idGenerator++;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.isManager = isManager;
//		this.username = username;
//		this.password = password;
//		this.taskQueue = new PriorityQueue<Task>();
//		this.projectQueue = new PriorityQueue<Project>();
	}

	@Override
	public int compareTo(User u) {
		// TODO Auto-generated method stub
		return this.lastName.compareTo(u.lastName);
	}
	
	// Setters Alphabetically
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param id the id to set
	 */
//	public int setId() {
//		//set id to previous id + 1
//		this.id = this.id++;
//		return this.id;
//	}
	/**
	 * @param isManager the isManager to set
	 */
//	public void setIsManager(boolean isManager) {
//		this.isManager = isManager;
//	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param password the password to set
	 */
//	public void setPassword(String password) {
//		this.password = password;
//	}
	/**
	 * @param taskQueue the taskQueue to set
	 */
//	public void setTaskQueue(PriorityQueue<Task> taskQueue) {
//		this.taskQueue = taskQueue;
//	}
	/**
	 * @param username the username to set
	 */
//	public void setUsername(String username) {
//		this.username = username;
//	}
	/**
	 * @param projectQueue the projectQueue to set
	 */
	
	// Getters Alphabetically
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the isManager
	 */
//	public boolean getIsManager() {
//		return isManager;
//	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}



}
