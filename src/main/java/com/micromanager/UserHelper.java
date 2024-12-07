/**User Helper class to complete functions on the servlet pages 
 * for displaying the users to the page and adding users to the list of
 * all users.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 */
public class UserHelper{


	//creating a new list to add all the users to
	private static ArrayList<User> allUsers = new ArrayList<User>();
	
	
	//add user to list of users
	public static void addUser(User user) {
		allUsers.add(user);
	}
	
	//remove a user from list of user
	public static void removeUser(User user) {
		allUsers.remove(user);
	}
	
	public static boolean validateName(String name) {
		String regex = "^[a-zA-Z ]+$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}
	
	//find User by ID
	public static User findUserByID(int id) {
		User user = null;
		Iterator<User> value = allUsers.iterator();
		while (value.hasNext()) {
			User current = value.next(); 
			if (current.getId() == id) {
				user = current;
			}
		}
		return user;
	}
	
	//display all Users; returns list of all users.
	public static List<User> getAllUsers() {
		//to do
		sortByLastName();
		return Collections.unmodifiableList(allUsers);
	}
	
	//print all users as a string
	public static String getAllUsersAsString() {
		Iterator<User> value = allUsers.iterator();
		String allUsersString = "";
		while (value.hasNext()) {
			String nextUser = value.toString() + " ";
			allUsersString = allUsersString + nextUser;
		}
		return allUsersString;
	}
	
	//method to determine if the list is empty
	public static boolean isEmpty() {
		return allUsers.isEmpty();
	}
	
	//method to see if user list contains a value
	//allUsers.contains();
	
	public static int getUserListSize() {
		return allUsers.size();
	}
	

	//method to sort the Users list by last name
	public static void sortByLastName() {
		// Sorting above list using sort() method
        // of Collections class
		boolean swapped;
		int size = allUsers.size();
		for(int i = 0; i < size -1; i++) {
			swapped = false;
			for (int j = 0; j < size - i - 1; j++) {
				User user1 = allUsers.get(j);
				User user2 = allUsers.get(j + 1);
				if(user1.getLastName().compareTo(user2.getLastName()) > 0 ) {
					allUsers.remove(j+1);
					allUsers.add(j+1, user1);
					allUsers.remove(j);
					allUsers.add(j, user2);
					swapped = true;
				}
			}
			if (swapped == false)
                break;
			
		}
	}
	
	public static void printUsers() {
		Iterator<User> value = allUsers.iterator();
		System.out.println("User List items: ");
		while (value.hasNext()) {
			System.out.println(value.next() + " ");
		}
		System.out.println();
	
	}
}
