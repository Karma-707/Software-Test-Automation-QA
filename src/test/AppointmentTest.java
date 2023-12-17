import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {

	//Test AppointmentId
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment ID cant be more than 10 characters")
    void testAppointmentIDWithMoreThanTenCharacters() {
		Appointment appointment = new Appointment( new Date(2025, 01, 13), "Pick up son from school");
		if(appointment.getAppointmentId().length() > 10) {
			fail("Appointment ID overflow");
		}
	}
	
	//Test Appointment date
	@Test
	@DisplayName("AppointmentDate is Null")
	void testAppointmentDateIsNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "Pick up son from school");
		});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("AppointmentDate cant be in the past")
	void testPastAppointmentDate() {
		Appointment appointment = new Appointment( new Date(1997, 01, 15), "Pick up son from school");
		if(appointment.getAppointmentDate().before(new Date())) {
			fail("Appointment Date is before current/in the past");
		}
	}
	
	
	
	//Test Description
	@Test
	@DisplayName("AppointmentDescription cant be more than 50 characters")
	void testAppointmentDescriptionWithMoreThanFiftyCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(new Date(), "123456789012345678901234567890123456789012345678901");
		});
	}
	
	@Test
	@DisplayName("AppointmentDescription is Null")
	void testDescriptionIsNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(new Date(), null);
		});
	}
	
	@Test
	@DisplayName("Appointment description changed")
	void testSetDescription() {
		Appointment appointment = new Appointment(new Date(), "Pick up son from school");
		appointment.setDescription("Get cheese from fridge");
		assertTrue(appointment.getDescription().equals("Get cheese from fridge"));
	}
	
	@Test
	@DisplayName("Appointment description changed null")
	void testSetDescriptionNull() {
		Appointment appointment = new Appointment(new Date(), "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription(null);
		});
	}
	
	@Test
	@DisplayName("Appointment description changed > 50 char")
	void testSetDescriptionFiftyOneChar() {
		Appointment appointment = new Appointment(new Date(), "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription("123456789012345678901234567890123456789012345678901");
		});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment date changed")
	void testSetDate() throws Exception {
		Date dt = new Date(2027, 11, 27);
		Appointment appointment = new Appointment(new Date(), "Pick up son from school");
		appointment.setDate(dt);
		assertTrue(dt.equals(appointment.getAppointmentDate()));
	}
	
	@Test
	@DisplayName("Appointment date changed null")
	void testSetDateNull() throws Exception {
		Appointment appointment = new Appointment(new Date(), "Pick up son from school");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDate(null);
		});
	}
	
}
