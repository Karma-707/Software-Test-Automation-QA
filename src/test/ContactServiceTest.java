import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ContactServiceTest {

	@Test
	@DisplayName("Test service can add contact")
	void testAddContact() throws Exception {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		assertNotNull(service.getContactId("1"));
	}

	@Test
	@DisplayName("Test service can correctly delete contacts")
	void testDeleteContact() throws Exception {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		service.deleteContact("1");
		//Ensure contactlist is empty and check with new arraylist made
		ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
		assertEquals(service.contactList, contactListEmpty);
	}

	@Test
	@DisplayName("Test update first name")
	void testUpdateFirstName() throws Exception {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		service.updateFirstName("Seven", "1");
		assertEquals("Seven", service.getContactId("1").getFirstName());
	}

	@Test
	@DisplayName("Test update last name")
	void testUpdateLastName() throws Exception {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		service.updateLastName("Ford", "1");
		assertEquals("Ford", service.getContactId("1").getLastName());
	}

	@Test
	@DisplayName("Test update phone number")
	void testUpdatePhoneNum() throws Exception {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		service.updatePhoneNum("1112223333", "1");
		assertEquals("1112223333", service.getContactId("1").getPhoneNum());
	}

	@Test
	@DisplayName("Test update address")
	void testUpdateAddress() throws Exception {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		service.updateAddress("1943 Grand St, CA 54321", "1");
		assertEquals("1943 Grand St, CA 54321", service.getContactId("1").getAddress());
	}

	@Test
	@DisplayName("Contact Id not found")
	void testContactIdNotFoundByDelete () {
		ContactService service = new ContactService();
		service.addContact("Johnny", "Anderson", "1234567890", "123 Grand St, NY 12345");
		Assertions.assertThrows(Exception.class, () -> {
			service.deleteContact("23");
		});
	}

}
