
public class Task {
	/*The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
	The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
	The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.*/
	
	public int id = 1;
	private final String taskId; // <=10 char, !null, !updatable
	private String name; // <=20 char, !null
	private String description; // <=50 char, !null
	
	//Constructor
	public Task(String name, String description) {
		
		//Check if Id meets requirement before setting in taskId
		if(String.valueOf(id).length() > 10) {
			throw new IllegalArgumentException("ID overflow");
		}
		//TaskId auto generated accepted
		this.taskId = String.valueOf(id);
		id++; //update id for next task id
		
		//Check if name meets requirement otherwise throw error
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		//Accept name
		this.name = name;
		
		//Check if description meets requirement otherwise throw error
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		//Accept description
		this.description = description;
	}
	
	//Getter methods
	
	//Get taskId
	public String getTaskId() {
		return taskId;
	}
	
	//Get task name
	public String getName() {
		return name;
	}
	
	//Get description
	public String getDescription() {
		return description;
	}
	
	//Setter methods
	
	//Set new name by checking requirement
	public void setName(String name) {
		//Check name requirements otherwise throw error
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		//Accept name
		this.name = name;
	}
	
	//Set new description
	public void setDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		//Accept description
		this.description = description;
	}
	
}
