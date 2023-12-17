import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

	//Test id
	@Test
	@DisplayName("Contact ID cant be more than 10 characters")
	void testContactIdWithMoreThanTenCharacters() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		if(contact.getContactId().length() > 10) {
			fail("Contact Id has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Contact Id overflow")
	void testContactIdOverflow () {
		for (int i = 1; i <= 1000000000; i++) {
			Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		}
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Christopher", "Anderson", "1011121513", "123 Grand St, NY 12345");
		});
	}
	
	@Test
	@DisplayName("Contact constructed correctly")
	void testContact() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		assertAll("contact", 
				() -> assertEquals("Johnny", contact.getFirstName()),
				() -> assertEquals("Anderson", contact.getLastName()),
				() -> assertEquals("1011121513", contact.getPhoneNum()),
				() -> assertEquals("123 Grand St, NY 12345", contact.getAddress())
				);
	}

	
	//Test first name
	@Test
	@DisplayName("Contact First Name changed")
	void testSetFirstName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		contact.setFirstName("Andrew");
		assertTrue(contact.getFirstName().equals("Andrew"));
	}
	
	@Test
	@DisplayName("Contact First Name Cant have more than 10 characters")
	void testContactFirstNameWithMoreThanTenCharacters() {
		/*Contact contact = new Contact("Christopher", "Anderson", "1011121513", "123 Grand St, NY 12345");
		if(contact.getFirstName().length() > 10) {
			fail("Contact First Name has more than 10 characters.");
		}*/
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Christopher", "Anderson", "1011121513", "123 Grand St, NY 12345");
		});
		
	}
	
	@Test
	@DisplayName("Contact first name is Null")
	void testContactFirstNameIsNull () {
		//Contact contact = new Contact(null, "Anderson", "1011121513", "123 Grand St, NY 12345");
		//assertNotNull(contact.getFirstName(), "First Name was null.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Anderson", "1011121513", "123 Grand St, NY 12345");
		});
	}
	

	@Test
	@DisplayName("To long set first name greater than 10 char")
	void testSetLongFirstName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Andrew78901");
		});
		
	}
	
	@Test
	@DisplayName("To long set first name nullr")
	void testSetNullFirstName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
		
	}
	
	@Test
	@DisplayName("To long set first name empty")
	void testSetEmptyFirstName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("");
		});
		
	}
	
	//Test last name

	@Test
	@DisplayName("Contact Last Name changed")
	void testSetLastName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		contact.setLastName("Ford");
		assertTrue(contact.getLastName().equals("Ford"));
	}

	@Test
	@DisplayName("Contact Last Name Cant have more than 10 characters")
	void testContactLastNameWithMoreThanTenCharacters() {
		/*Contact contact = new Contact("Johnny", "Summerfield", "1011121513", "123 Grand St, NY 12345");
		if(contact.getLastName().length() > 10) {
			fail("Contact Last Name has more than 10 characters.");
		}*/
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", "Summerfield", "1011121513", "123 Grand St, NY 12345");
		});
				
	}
	
	
	@Test
	@DisplayName("Contact last name is Null")
	void testContactLastNameIsNull () {
		//Contact contact = new Contact("Johnny", null, "1011121513", "123 Grand St, NY 12345");
		//assertNotNull(contact.getLastName(), "Last Name was null.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", null, "1011121513", "123 Grand St, NY 12345");
		});
		
	}
	
	@Test
	@DisplayName("To long set last name 11 char")
	void testSetLongLastName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("12345678901");
		});		
	}
	
	@Test
	@DisplayName("To long set last name empty")
	void testSetEmptyLastName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("");
		});
	}
	
	@Test
	@DisplayName("To long set last name null")
	void testSetNullLastName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});		
	}
	 	
	//Test phone number
	
	@Test
	@DisplayName("Contact Phone Number changed")
	void testSetPhoneNum() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		contact.setPhoneNum("5675396299");
		assertTrue(contact.getPhoneNum().equals("5675396299"));
	}

	
	@Test
	@DisplayName("Contact Phone number is less than 10 characters")
	void testContactPhoneNumberWithLessThanTenCharacters() {
		/*Contact contact = new Contact("Johnny", "Summerfield", "123", "123 Grand St, NY 12345");
		if(contact.getPhoneNum().length() < 10) {
			fail("Contact phone number has less than 10 characters.");
		}*/
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", "Summerfield", "123", "123 Grand St, NY 12345");
		});
		
		
	}
	
	@Test
	@DisplayName("Contact Phone number is more than 10 characters")
	void testContactPhoneNumberWithMoreThanTenCharacters() {
		/*Contact contact = new Contact("Johnny", "Summerfield", "12345678901", "123 Grand St, NY 12345");
		if(contact.getPhoneNum().length() > 10) {
			fail("Contact phone number has more than 10 characters.");
		}*/
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", "Summerfield", "12345678901", "123 Grand St, NY 12345");
		});
		
		
	}
	
	
	@Test
	@DisplayName("Contact phone numnber is Null")
	void testContactPhoneNumIsNull () {
		//Contact contact = new Contact("Johnny", "Anderson", null, "123 Grand St, NY 12345");
		//assertNotNull(contact.getPhoneNum(), "Phone number was null.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", "Anderson", null, "123 Grand St, NY 12345");
		});
	}
	
	@Test
	@DisplayName("To long set phone number 11 char")
	void testSetLongPhoneNum() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("12345678901");
		});		
	}
	
	@Test
	@DisplayName("To short set phone number < 10 char")
	void testSetShortPhoneNum() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("1");
		});		
	}
	
	@Test
	@DisplayName("To long set phone number empty")
	void testSetEmptyPhoneNum() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("");
		});
	}
	
	@Test
	@DisplayName("To long set phone number null")
	void testSetNullLasttName() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum(null);
		});		
	}
	
	
	//Test address
	
	@Test
	@DisplayName("Contact Address changed")
	void testSetAddress() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");
		contact.setAddress("456 Grand St, NJ 08565");
		assertTrue(contact.getAddress().equals("456 Grand St, NJ 08565"));
	}
	
	
	@Test
	@DisplayName("Contact address Cant have more than 10 characters")
	void testContactAddressWithMoreThanThirtyCharacters() {
		/*Contact contact = new Contact("Johnny", "Summerfield", "1011121513", "123456789 123456789 123456789 1");
		if(contact.getAddress().length() > 30) {
			fail("Contact address has more than 30 characters.");
		}*/
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", "Summerfield", "1011121513", "123456789 123456789 123456789 1");
		});
		
		
	}
	
	
	@Test
	@DisplayName("Contact address is Null")
	void testContactAddressIsNull () {
		//Contact contact = new Contact("Johnny", "Anderson", "1011121513", null);
		//assertNotNull(contact.getAddress(), "Address was null.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Johnny", "Anderson", "1011121513", null);
		});
		
	}
	
	@Test
	@DisplayName("To long set Address 31 char")
	void testSetLongAddress() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("1234567890123456789012345678901");
		});		
	}
	
	@Test
	@DisplayName("To long set Address empty")
	void testSetEmptyAddress() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("");
		});
	}
	
	@Test
	@DisplayName("To long set phone number null")
	void testSetNullAddress() {
		Contact contact = new Contact("Johnny", "Anderson", "1011121513", "123 Grand St, NY 12345");		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});		
	}

}
