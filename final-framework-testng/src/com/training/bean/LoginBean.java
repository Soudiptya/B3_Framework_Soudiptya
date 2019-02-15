package com.training.bean;

public class LoginBean {
	/*private String userName;
	private String password;

	public LoginBean() {
	}

	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}*/
	
	private String FirstName;
	private String LastName;
	private String Email;
	private String UserNameTextbox;
	private String PasswordTextbox;
	private String ConfirmPasswordTextbox;
	private String PhoneNumber;
	private String LanguageSelect;
	
	public LoginBean() {
	}
	
	public LoginBean(String FirstName, String LastName, String Email, String UserNameTextbox, String PasswordTextbox, String ConfirmPasswordTextbox, String PhoneNumber, String LanguageSelect) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.UserNameTextbox = UserNameTextbox;
		this.PasswordTextbox = PasswordTextbox;
		this.ConfirmPasswordTextbox = ConfirmPasswordTextbox;
		this.PhoneNumber = PhoneNumber;
		this.LanguageSelect = LanguageSelect;	
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getUserNameTextbox() {
		return UserNameTextbox;
	}

	public void setUserNameTextbox(String UserNameTextbox) {
		this.UserNameTextbox = UserNameTextbox;
	}

	public String getPasswordTextbox() {
		return PasswordTextbox;
	}

	public void setPasswordTextbox(String PasswordTextbox) {
		this.PasswordTextbox = PasswordTextbox;
	}

	public String getConfirmPasswordTextbox() {
		return ConfirmPasswordTextbox;
	}

	public void setConfirmPasswordTextbox(String ConfirmPasswordTextbox) {
		this.ConfirmPasswordTextbox = ConfirmPasswordTextbox;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

	public String getLanguageSelect() {
		return LanguageSelect;
	}

	public void setLanguageSelect(String LanguageSelect) {
		this.LanguageSelect = LanguageSelect;
	}
	
	@Override
	public String toString() {
		return "LoginBean [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", UserNameTextbox=" + UserNameTextbox + ", PasswordTextbox=" + PasswordTextbox + ", ConfirmPasswordTextbox=" + ConfirmPasswordTextbox + ", PhoneNumber=" + PhoneNumber + ", LanguageSelect=" + LanguageSelect + "]";
	}


}
