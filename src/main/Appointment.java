import java.util.Date;

public class Appointment {
	/*The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
	The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
	Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
	The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.*/
	
	public int id = 1;
	private final String appointmentId; // <=10 char, !null, !updatable
	private Date appointmentDate; // !inPast, !null
	private String description; // <=50 char, !null
	
	
	//Constructor
	public Appointment(Date date, String description) {
		
		//Check if Id meets requirement before setting in appointmentId
		if(String.valueOf(id).length() > 10) {
			throw new IllegalArgumentException("ID overflow");
		}
		//TaskId auto generated accepted
		this.appointmentId = String.valueOf(id);
		id++; //update id for next task id
		
		//Check if date meets requirement before setting in appointmentDate
		if(date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		//Accept date
		this.appointmentDate = date;
		
		//Check if description meets requirement otherwise throw error
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		//Accept description
		this.description = description;
				
	}
	
	//Getter methods
	
	//Get appointmentId
	public String getAppointmentId() {
		return appointmentId;
	}
	
	//Get description
	public String getDescription() {return description;}
	
	//Get appointmentDate
	public Date getAppointmentDate() {return appointmentDate;}

	
	//Setter methods
	
	//Set appointment description
	public void setDescription(String updatedDescription) {
		//Check if description meets requirement otherwise throw error
		if(updatedDescription == null || updatedDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		//Accept description
		this.description = updatedDescription;
	}

	//Set appointment date
	public void setDate(Date updatedDate) {
		//Check if date meets requirement before setting in appointmentDate
		if(updatedDate == null || updatedDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		//Accept date
		this.appointmentDate = updatedDate;
	}
	
}
