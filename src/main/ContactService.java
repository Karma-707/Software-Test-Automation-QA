import java.util.ArrayList;

public class ContactService {
	
	/*The contact service shall be able to add contacts with a unique ID.
	The contact service shall be able to delete contacts per contact ID.
	The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
		firstName
		lastName
		Number
		Address*/
	
	
	public ArrayList<Contact> contactList = new ArrayList<Contact>(); //List of contacts
	
	//Add new contact to contact list using contact constructor
	public void addContact(String firstName, String lastName, String phoneNum, String address) {
		Contact contact = new Contact(firstName, lastName, phoneNum, address); //create contact
		contactList.add(contact); //add contact to contact list
	}
	
	
	//Delete contact by ID
	public void deleteContact(String contactId) throws Exception {
		/*for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContactId().equals(contactId)) {
				//remove from contact list
				contactList.remove(i);
				break;
			}
			//When contact id not found return no match found
			if(i == contactList.size()-1 ) {
				System.out.println("Contact ID: " + contactId + " not found.");
			}
		}*/
		
		contactList.remove(getContactId(contactId));
	}
	
	//Update contact first name by contact id
	public void updateFirstName(String updatedFirstName, String contactId) throws Exception {
		/*for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContactId().equals(contactId)) {
				contactList.get(i).setFirstName(updatedFirstName); //set first name
				break;
			}
			//When contact id not found return no match found
			if(i == contactList.size()-1 ) {
				System.out.println("Contact ID: " + contactId + " not found.");
			}
		}*/
		
		getContactId(contactId).setFirstName(updatedFirstName);
	}
	
	//Update contact last name by contact id
	public void updateLastName(String updatedLastName, String contactId) throws Exception {
		/*for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContactId().equals(contactId)) {
				contactList.get(i).setLastName(updatedLastName); //set last name
				break;
			}
			//When contact id not found return no match found
			if(i == contactList.size()-1 ) {
				System.out.println("Contact ID: " + contactId + " not found.");
			}
		}*/
		
		getContactId(contactId).setLastName(updatedLastName);
	}
	
	//Update contact phone number by contact id
	public void updatePhoneNum(String updatedPhoneNum, String contactId) throws Exception {
		/*for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContactId().equals(contactId)) {
				contactList.get(i).setPhoneNum(updatedPhoneNum); //set phone number
				break;
			}
			//When contact id not found return no match found
			if(i == contactList.size()-1 ) {
				System.out.println("Contact ID: " + contactId + " not found.");
			}
		}*/
		
		getContactId(contactId).setPhoneNum(updatedPhoneNum);
	}
	
	//Update contact address by contact id
	public void updateAddress(String updatedAddress, String contactId) throws Exception {
		/*for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContactId().equals(contactId)) {
				contactList.get(i).setAddress(updatedAddress); //set Address
				break;
			}
			//When contact id not found return no match found
			if(i == contactList.size()-1 ) {
				System.out.println("Contact ID: " + contactId + " not found.");
			}
		}*/
		getContactId(contactId).setAddress(updatedAddress);
		
	}

	//Using contact ID to return contact object if found
	public Contact getContactId(String contactId) throws Exception {
		//Check if contact object exist in list with given id
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getContactId().contentEquals(contactId)) {
				return contactList.get(i);
			}
		}
		//If id not found throw error
		throw new Exception("No Id found");
	}
	
	
}
