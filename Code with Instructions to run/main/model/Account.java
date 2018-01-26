package model;

public class Account {
	protected String email;
	protected String username;
	protected String password;
	protected String name;
	protected int phoneNumber;
	protected String gender;
	
	
	//private String street;
	//private String city;
	//private String state;
	//private String zip;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getgender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
