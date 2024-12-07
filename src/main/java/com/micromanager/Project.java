/**
 * Sets the project attributes as well as adds a task priority
 * queue and manager to the project.
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

import java.time.LocalDate;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * 
 */
public class Project implements Comparable<Project> {
	private int id;
	private static int idGenerator = 1;
	private String title;
	private String description;
	private User manager;
	private Date dueDate;
	private LocalDate createdDate;
//	private Date nextTaskDue;		//Add back in if time allows
	// should be equal to the due date of the task at the top of the queue
	// updated whenever the list is pulled
	private Boolean isOpen;
	
	public TaskQueue taskQueue; // holds multiple tasks for the project.
	
	/**
	 * 
	 */
	public Project() {
		super();
		this.id = Project.idGenerator++;
		this.title = "";
		this.description = "";
		this.manager = null;
		this.dueDate = new Date();
		setCreatedDate();
		this.isOpen = true;
		this.taskQueue = new TaskQueue();
	}

	/**
	 * @param title
	 * @param description
	 * @param manager
	 * @param dueDate
	 * @param createdDate
	 * @param nextTaskDue
	 * @param TaskQueue
	 */
	public Project(String title, String description, Date dueDate, User manager) {
		super();
		this.id = Project.idGenerator++;
		this.title = title;
		this.description = description;
		this.manager = manager;
		this.dueDate = dueDate;
		setCreatedDate();
		this.isOpen = true;
		this.taskQueue = new TaskQueue();
	}

	// compare one task priority to another task priority
	public int compareTo(Project project) {
		return this.dueDate.compareTo(project.dueDate);
	}
	

	//add a task to the projects task Queue
	public void addTaskToProject(Task task) {
		this.taskQueue.addTask(task);
	}
	
	//Initialize a new task queue if one does not exist
	
	// Setters Alphabetically
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate() {
		LocalDate currentDate = LocalDate.now();
		this.createdDate = currentDate;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}
	/**
	 * @param nextTaskDue the nextTaskDue to set
	 */
//	public void setNextTaskDue() {
//		//this.nextTaskDue = nextTaskDue;
//		// needs to be the due date of the first element in the task queue
//		// update whenever the list is called
//	}
	/**
	 * @param taskQueue the taskQueue to set
	 */
	public void setTaskQueue(TaskQueue taskQueue) {
		this.taskQueue = taskQueue;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	

	// Getters Alphabetically
	/**
	 * @return the createdDate
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the isOpen
	 */
	public Boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * @return the manager
	 */
	public User getManager() {
		return manager;
	}

	/**
	 * @return the nextTaskDue
	 */
//	public Date getNextTaskDue() {
//		return nextTaskDue;
//	}

	/**
	 * @return the taskQueue
	 */
	public TaskQueue getTaskQueue() {
		return taskQueue;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", description=" + description + ", manager=" + manager
				+ ", dueDate=" + dueDate + ", createdDate=" + createdDate + ", isOpen=" + isOpen + ", taskQueue="
				+ taskQueue + "]";
	}

}
