/**Task class that defines the task attributes and assigns the task
 * to a user and prioritizes the task in a priority queue
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


/**
 * 
 */
public class Task implements Comparable<Task>{
	private int id;
	private static int idGenerator = 1;
	private String taskTitle;
	private String description;
	private LocalDate createdDate;
	private LocalDate lastUpdatedDate;
	private Date dueDate;
	private User assignedTo;
	private Boolean isOpen;
	private Project project;
	
	/**
	 * 
	 */
	public Task() {
		super();
		this.id = Task.idGenerator++;
		this.taskTitle = "";
		this.description = "";
		setCreatedDate();
		setLastUpdatedDate();
		this.dueDate = new Date();
//		this.assignedTo = assignedTo; //assign to the person logged in
		this.isOpen = true;
//		this.project = project; //leave blank/null
	}

	/**
	 * @param taskTitle
	 * @param description
	 * @param createdDate
	 * @param lastUpdatedDate
	 * @param dueDate
	 * @param assignedTo
	 * @param project
	 */
	public Task(String taskTitle, String description, Date dueDate, User assignedTo, Project project) {
		super();
		this.id = Task.idGenerator++;
		this.taskTitle = taskTitle;
		this.description = description;
		setCreatedDate();
		setLastUpdatedDate();
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.isOpen = true;
		this.project = project;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	//compare one task priority to another task priority
	public int compareTo(Task task) {
		return this.dueDate.compareTo(task.dueDate);
	}

	/**
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}

	/**
	 * @param taskTitle the taskTitle to set
	 */
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate() {
		LocalDate currentDate = LocalDate.now();
		this.createdDate = currentDate;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public LocalDate getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate() {
		LocalDate currentDate = LocalDate.now();
		this.createdDate = currentDate;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the assignedTo
	 */
	public User getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo the assignedTo to set
	 */
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public Boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "com.micromanager.Task [taskTitle=" + taskTitle + ", description=" + description + ", createdDate=" + createdDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", dueDate=" + dueDate + ", assignedTo=" + assignedTo
				+ ", isOpen=" + isOpen + ", project=" + project + "]";
	}
	
}
