import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




class AppointmentServiceTest {

	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Add Appointment to appointmentList")
	void testAddAppointment() throws Exception {
		AppointmentService service = new AppointmentService();
		service.addAppointment(new Date(2025, 01, 15), "Pick up son from school");
		assertTrue(String.valueOf(service.appointmentList.size()).equals("1"));
		
	}

	@Test
	@DisplayName("Delete Appointment from appointmentList")
	void testDeleteAppointment() throws Exception {
		AppointmentService service = new AppointmentService();
		service.addAppointment(new Date(), "Pick up son from school");
		service.deleteAppointment("1");
		//Ensure appointmentlist is empty and check with new arraylist made
		ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>();
		assertEquals(service.appointmentList, appointmentListEmpty);
	}

	@Test
	@DisplayName("Test if appointment is part of list with ID given")
	void testSearchForAppointment() throws Exception {
		AppointmentService service = new AppointmentService();
		service.addAppointment(new Date(), "Pick up son from school");
		assertTrue(service.searchForAppointment("1").getAppointmentId().equals("1"));
	}

	@Test
	@DisplayName("Change appointment description")
	void testChangeInAppointmentDescription() throws Exception {
		AppointmentService service = new AppointmentService();
		service.addAppointment(new Date(), "Pick up son from school");
		service.updateDescription("Go on a hike", "1");
		assertEquals("Go on a hike", service.searchForAppointment("1").getDescription());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Change appointment date")
	void testChangeInAppointmentDate() throws Exception {
		Date dt = new Date(2027, 11, 27);
		AppointmentService service = new AppointmentService();
		service.addAppointment(new Date(), "Pick up son from school");
		service.updateDate(dt, "1");
		assertTrue(dt.equals(service.searchForAppointment("1").getAppointmentDate()));
	}
	
	@Test
	@DisplayName("Appointment Search ID not found")
	void testSearchAppointmentIdNotFound() throws Exception {
		AppointmentService service = new AppointmentService();
		service.addAppointment(new Date(), "Pick up son from school");
		Assertions.assertThrows(Exception.class, () -> {
			service.deleteAppointment("22");
		});
	}
}
