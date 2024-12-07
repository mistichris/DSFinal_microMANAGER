/** TaskQueue Helper 
 * Helper functions to complete functions on the priority queue for the Tasks
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
 * 
 */
public class TaskQueue {
	// creating instance of a priority queue for the projects for sorting
	private static PriorityQueue<Task> taskQueue = new PriorityQueue<Task>();

	// add task to taskQueue
	public void addTask(Task task) {
		taskQueue.add(task);
	}

	// return the task queue size
	public static int getTaskQueueSize() {
		return taskQueue.size();
	}

	// return a list of all the tasks in the task queue
	public static List<Task> getAllTasks() {
		List<Task> taskList = new ArrayList<>(taskQueue);
		return Collections.unmodifiableList(taskList);
	}

	// find a task by the task id number
	public Task findTaskByID(int id) {
		Task task = null;
		Iterator<Task> value = taskQueue.iterator();
		while (value.hasNext()) {
			Task current = value.next();
			if (current.getId() == id) {
				task = current;
			}
		}

		return task;
	}
	
	// sort the task; don't need; priority queue should redistribute objects as
	// needed
//	public static void sortTaskQueue() {
//		
//	}

	// Close task= change isOpen to false; same as update task
	// add if have time
	public static void closeTask(Task task) {

	}

	// return true if the queue is empty
	public boolean isEmpty() {
		return taskQueue.isEmpty();
	}

	// remove task from task queue
	public void removeTask(Task task) {
		taskQueue.remove(task);
	}

	public static boolean validateTitle(String name) {
		String regex = "^[a-zA-Z ]+$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}

	// Update task; complete if time allows
	public static void updateTask(Task task) {
		// to do if have time
		// find the task by id

		// delete the old task

		// enter in updated information as a new task

		// resort the queue
	}

	// iterate through task queue and print to a string
	public static void printQueue(PriorityQueue<Task> taskQueue) {
		Iterator<Task> value = taskQueue.iterator();
		System.out.print("com.micromanager.Task Queue items: ");
		while (value.hasNext()) {
			System.out.print(value.next() + " ");
		}
		System.out.println();
	}

}
