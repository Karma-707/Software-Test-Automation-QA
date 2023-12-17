
public class Contact {

	/*The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
	The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
	The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
	The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
	The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.*/
	public int id = 1;
	private final String contactId; // <=10 char, !null, !updateable
	private String firstName; // <=10 char, !null
	private String lastName; // <=10 char, !null
	private String phoneNum; //=10 digits, !null
	private String address; // <=30 char, !null
	
	//Constructor
	public Contact(String firstName, String lastName, String phoneNum, String address) {
		
		//Check if id meet requirement before setting to contactID
		if(String.valueOf(id).length() > 10) {
			throw new IllegalArgumentException("ID overflow");
		}		
		//Contact ID auto generated Accepted
		this.contactId = String.valueOf(id);
		id++; //update id for next contact
		
		
		//Check if first name meet requirement otherwise throw error
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		//Accept first name
		this.firstName = firstName;
		
		//Check if last name meet requirement otherwise throw error
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		//Accept last name
		this.lastName = lastName;
		
		//Check if phone number meet requirement otherwise throw error
		if(phoneNum == null || phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		//Accept phone number
		this.phoneNum = phoneNum;
		
		//Check if address meet requirement otherwise throw error
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		//Accept address
		this.address = address;
	}	
	
	//Getter methods
	
	//Get contactId
	public String getContactId() {
		return contactId;
	}
	
	//Get contact first name
	public String getFirstName() {
		return firstName;
	}
	
	//Get contact last name
	public String getLastName() {
		return lastName;
	}
	
	//Get contact phone number
	public String getPhoneNum() {
		return phoneNum;
	}
	
	//Get contact address
	public String getAddress() {
		return address;
	}
	
	
	//Setter methods
	
	//Set first name with requirements
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10 || firstName.isEmpty()) {
			throw new IllegalArgumentException("Invalid first name");
		}
		else {
			this.firstName = firstName;
		}
	}
	
	//Set last name with requirements
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10 || lastName.isEmpty()) {
			throw new IllegalArgumentException("Invalid last name");
		}
		else {
			this.lastName = lastName;
		}
	}
	
	
	//Set phone number with requirements
	public void setPhoneNum(String phoneNum) {
		if(phoneNum == null || phoneNum.length() != 10 || phoneNum.isEmpty()) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		else {
			this.phoneNum = phoneNum;
		}
	}
	
	//Set address with requirements
	public void setAddress(String address) {
		if(address == null || address.length() > 30 || address.isEmpty()) {
			throw new IllegalArgumentException("Invalid address");
		}
		else {
			this.address = address;
		}
	}
	

}
