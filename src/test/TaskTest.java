import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

	/*Test constructor*/
	@Test
	@DisplayName("Task constructed correctly")
	void testTask() {
		Task task = new Task("Johnny", "Pick up son from school");
		assertAll("task", 
				() -> assertEquals("1", task.getTaskId()),
				() -> assertEquals("Johnny", task.getName()),
				() -> assertEquals("Pick up son from school", task.getDescription())
				);
	}
	
	/*Testing TaskId*/
	@Test
	@DisplayName("TaskId cant be more than 10 characters")
	void testTaskIdWithMoreThanTenCharacters() {
		Task task = new Task("Johnny", "Pick up son from school");
		if(task.getTaskId().length() > 10) {
			fail("Contact Id has more than 10 characters.");
		}
	}	

	/*Testing task name*/
	@Test
	@DisplayName("Task name is Null")
	void testTaskNameIsNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Pick up son from school");
		});
	}
		
	@Test
	@DisplayName("Task name cant be more than 20 characters")
	void testNameWithMoreThanTwentyCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Johnny789012345678901", "Pick up son from school");
		});
	}
	
	@Test
	@DisplayName("Task name cant be set Null")
	void testSetNameToNull() {
		Task task = new Task("Johnny", "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	@Test
	@DisplayName("Task name cant be set over 20 char")
	void testSetNameToTwentyOneChar() {
		Task task = new Task("Johnny", "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName("123456789012345678901");
		});
	}
	
	@Test
	@DisplayName("Task name changed")
	void testSetName() {
		Task task = new Task("Johnny", "Pick up son from school");
		task.setName("Matthew");
		assertTrue(task.getName().equals("Matthew"));
	}
	
	/*Test description*/

	@Test
	@DisplayName("Task description is Null")
	void testTaskDescriptionIsNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Johnny", null);
		});
	}
		
	@Test
	@DisplayName("Task description cant be more than 50 characters")
	void testDescriptionWithMoreThanFiftyCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Johnny", "Pick up son from school4567890123456789012345678901");
		});
	}
	
	@Test
	@DisplayName("Task description cant be set Null")
	void testSetDescriptionToNull() {
		Task task = new Task("Johnny", "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}
	
	@Test
	@DisplayName("Task description cant be set over 50 char")
	void testSetDescriptionToFiftyOneChar() {
		Task task = new Task("Johnny", "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription("123456789012345678901234567890123456789012345678901");
		});
	}
	
	@Test
	@DisplayName("Task description changed")
	void testSetDescription() {
		Task task = new Task("Johnny", "Pick up son from school");
		task.setDescription("Get cheese from fridge");
		assertTrue(task.getDescription().equals("Get cheese from fridge"));
	}
	
	
	

}
