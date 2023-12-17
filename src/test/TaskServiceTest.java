import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TaskServiceTest {

	@Test
	@DisplayName("TaskService can add tasks to list")
	void testAddTask() throws Exception {
		TaskService service = new TaskService();
		service.addTask("Johnny", "Pick up son from school");
		assertNotNull(service.checkTaskId("1"));
	}

	@Test
	@DisplayName("TaskService can delete task from list")
	void testDeleteTask() throws Exception {
		TaskService service = new TaskService();
		service.addTask("Johnny", "Pick up son from school");
		service.deleteTask("1");
		//Ensure Tasklist is empty and check with new arraylist made
		ArrayList<Task> TaskListEmpty = new ArrayList<Task>();
		assertEquals(service.taskList, TaskListEmpty);
	}

	@Test
	@DisplayName("TaskService updated name sucessfully")
	void testUpdateName() throws Exception {
		TaskService service = new TaskService();
		service.addTask("Johnny", "Pick up son from school");
		service.updateName("Seven", "1");
		assertEquals("Seven", service.checkTaskId("1").getName());
	}

	@Test
	@DisplayName("TaskService updated description sucessfully")
	void testUdpateDescription() throws Exception {
		TaskService service = new TaskService();
		service.addTask("Johnny", "Pick up son from school");
		service.updateDescription("Get cheese from fridge", "1");
		assertEquals("Get cheese from fridge", service.checkTaskId("1").getDescription());
	}
	
	@Test
	@DisplayName("TaskService found in list test with id")
	void testCheckTaskIdWhenIdIsInList() throws Exception {
		TaskService service = new TaskService();
		service.addTask("Johnny", "Pick up son from school");
		assertTrue(service.checkTaskId("1").getTaskId().equals("1"));
	}

	@Test
	@DisplayName("Task Id not found")
	void testTaskIdNotFoundByDelete () {
		TaskService service = new TaskService();
		service.addTask("Johnny", "Pick up son from school");
		Assertions.assertThrows(Exception.class, () -> {
			service.deleteTask("22");
		});
	}
	
}
