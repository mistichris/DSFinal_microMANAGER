/** Unit Tests to test proper functioning of the Classes and priority queue
 * proper functioning.
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

import static org.junit.Assert.*;

import org.junit.Test;

import com.micromanager.User;
import com.micromanager.UserHelper;

/**
 * 
 */
public class MMTestScripts {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//User class and UserHelper functions
	@Test
	public void testAddNewUser() {
		String ln1 = "Smith";
		String fn1 = "Beth";
		User user1 = new User(fn1, ln1);
		String expected = "User [id=1, firstName=Beth, lastName=Smith]";
		String actual = user1.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSortUserLastName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUserIsEmpty() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testReturnUser() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRetrieveUserList() {
		String ln1 = "Smith";
		String fn1 = "Beth";
		User user1 = new User(fn1, ln1);
		UserHelper displayAll = new UserHelper();
		displayAll.addUser(user1);
		String expected = "User [id=1, firstName=Beth, lastName=Smith]";
		String actual = user1.toString();
		assertEquals(expected,actual);
	}
	
	//Project class and ProjectQueueHelper
	@Test
	public void testAddProject() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRetrieveProjectQueue() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateProject() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCloseProject() {
		fail("Not yet implemented");
	}
	
	//Shouldn't have to sort the priorityQueue
	//should redistribute as items are added and deleted
//	@Test
//	public void testSortProjectQueue() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testReturnProject() {
		fail("Not yet implemented");
	}
	
	//Task class and TaskQueueHelper
	@Test
	public void testAddTaskToQueue() {
		fail("Not yet implemented");
	}
	
	
	//Shouldn't have to sort the priorityQueue
	//should redistribute as items are added and deleted
//	@Test
//	public void testSortTaskQueue() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testCloseTaskInQueue() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateTaskInQueue() {
		fail("Not yet implemented");
	}
	
	@Test
	public void tesUpdateTask() {
		fail("Not yet implemented");
	}
}
