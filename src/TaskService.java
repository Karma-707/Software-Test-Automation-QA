import java.util.ArrayList;

public class TaskService {
	/*The task service shall be able to add tasks with a unique ID.
	The task service shall be able to delete tasks per task ID.
	The task service shall be able to update task fields per task ID. The following fields are updatable:
		Name
		Description*/
	
	public ArrayList<Task> taskList = new ArrayList<Task>(); //List of tasks
	
	//Add task to taskList
	public void addTask(String name, String description) {
		Task task = new Task(name, description); //create task object
		taskList.add(task); //add task to taskList
	}
	
	//Delete task from taskList by id
	public void deleteTask(String taskId) throws Exception {
		taskList.remove(checkTaskId(taskId));
	}
	
	//Update task name by id
	public void updateName(String updatedName, String taskId) throws Exception {
		checkTaskId(taskId).setName(updatedName);
	}
	
	//Update task description by id
	public void updateDescription(String updatedDescription, String taskId) throws Exception {
		checkTaskId(taskId).setDescription(updatedDescription);
	}
	
	//Check if Id exist in task then return that task
	public Task checkTaskId(String taskId) throws Exception {
		//Check if taskId exist taskList
		for(int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getTaskId().equals(taskId)) {
				return taskList.get(i);
			}
		}
		//If task id not found throw error
		throw new Exception("Task does not exist with that ID!");
	}
	
}
