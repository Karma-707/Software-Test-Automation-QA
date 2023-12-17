import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	/*The appointment service shall be able to add appointments with a unique appointment ID.
	The appointment service shall be able to delete appointments per appointment ID.*/
	
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(); //List of appointment

	//Add appointment to appointmentList
	public void addAppointment(Date date, String description) {
		Appointment appointment = new Appointment(date, description); //create appointment object
		appointmentList.add(appointment); //add appointment to appointmentList
	}
	
	//Delete appointment from appointmentList by id
	public void deleteAppointment(String appointmentId) throws Exception {
		appointmentList.remove(searchForAppointment(appointmentId));
	}
	
	//Update appointment description by id
	public void updateDescription(String updatedDescription, String AppointmentId) throws Exception {
		searchForAppointment(AppointmentId).setDescription(updatedDescription);
	}
	
	//Update appointment description by id
	public void updateDate(Date updatedDate, String AppointmentId) throws Exception {
		searchForAppointment(AppointmentId).setDate(updatedDate);
	}	
	
	//Check if Id exist in appointment list then return that appointment
	public Appointment searchForAppointment(String taskId) throws Exception {
		//Check if taskId exist taskList
		for(int i = 0; i < appointmentList.size(); i++) {
			if(appointmentList.get(i).getAppointmentId().equals(taskId)) {
				return appointmentList.get(i);
			}
		}
		//If task id not found throw error
		throw new Exception("Appointment does not exist with that ID!");
	}	
	
}
