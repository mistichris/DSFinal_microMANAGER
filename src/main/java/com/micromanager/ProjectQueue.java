/**ProjectQueue helper;
 * Helper functions to complete functions on the priority queue for the Projects
 * that are needed to be completed in the servlets
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * ProjectQueue Helper functions to call to complete functions in servlets.
 */
public class ProjectQueue {
	//creating instance of a priority queue for the projects for sorting
	private static PriorityQueue<Project> projectQueue = new PriorityQueue<Project>();

	//add Project to priorityQueue
	public static void addProject(Project project) {
		projectQueue.add(project);
		//sort the queue
	}
	
	//remove project from priority queue
	public static void deleteProject(Project project) {
		projectQueue.remove(project);
	}
	
	//find Project by ID
	public static Project findProjectByID(int id) {
		Project project = null;
		Iterator<Project> value = projectQueue.iterator();
		while (value.hasNext()) {
			Project current = value.next(); 
			if (current.getId() == id) {
				project = current;
			}
		}
		return project;
	}
	
	//This shouldn't be needed. A Title can include what ever characters they want
	//the html page will prevent a blank entry.
	public static boolean validateTitle(String name) {
		String regex = "^[a-zA-Z ]+$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}
	
	//add if have time; update a project currently in the priority queue
	public static void updateProject(Project project) {
		// to do if have time
		//find the project by id
		
		//delete the old project
		
		//enter in updated information as a new project
		
		//resort the queue

	}
	
	//return the current size of the priority queue
	public static int getProjectQueueSize() {
		return projectQueue.size();
	}
	
	//return true if the queue is empty
	public static boolean isEmpty() {
		return projectQueue.isEmpty();
	}
	
	//method to see if project queue contains a value; add if needed in future
		//projectQueue.contains();
	
	//change the status of isOpen to false to close a project; same as update project; 
		//implement if have time
	public static void closeProject(int id) {
		// to do
		// find com.micromanager.Project by id
		// set isOpen to false;
		
		//delete from queue?
		//move to closed project queue?

	}
	
	//return a list of all projects in the priority queue
	public static List<Project> getAllProjects() {
		// to do
		List<Project> projectList = new ArrayList<>(projectQueue);
		return Collections.unmodifiableList(projectList);
		//projectQueue.sort
//		Iterator<Project> value = projectQueue.iterator();
//		while (value.hasNext()) {
//			System.out.print(value.next() + " ");
//		}
//		System.out.println();
	}
	
	/**
	 * 
	 * @param jobQueue
	 * Takes in the jobQueue queue and iterates through the queue
	 * and prints out all the objects using the toString method from
	 * the Job class.
	 */
	public static void printQueue(PriorityQueue<Project> projectQueue) {
		Iterator<Project> value = projectQueue.iterator();
		System.out.print("com.micromanager.Project Queue items: ");
		while (value.hasNext()) {
			System.out.print(value.next() + " ");
		}
		System.out.println();
	}
}
