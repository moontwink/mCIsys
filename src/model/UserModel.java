package model;


public class UserModel {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private SavingsAccount savingsAccount;
	private BusinessAccount businessAccount;
	private CheckingsAccount checkingsAccount;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserModel(){
		setId(0);
		firstName = "";
		lastName = "";
		password = "";
		savingsAccount = null;
		businessAccount = null;
		checkingsAccount = null;
	}
	
	public UserModel(String firstName, String lastName, String username, String password){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	public BusinessAccount getBusinessAccount() {
		return businessAccount;
	}

	public void setBusinessAccount(BusinessAccount businessAccount) {
		this.businessAccount = businessAccount;
	}

	public CheckingsAccount getCheckingsAccount() {
		return checkingsAccount;
	}

	public void setCheckingsAccount(CheckingsAccount checkingsAccount) {
		this.checkingsAccount = checkingsAccount;
	}
}
