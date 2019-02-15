package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_089
 * Test Case Description : TO verify whether registered student details get stored in database.
 * PreCondition          : 1. User should have launched the application 
 */

public class ELearningRegisteredStudentDetailsPOM {

private WebDriver driver;
	
	public ELearningRegisteredStudentDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	@FindBy(id="password")
	private WebElement password;
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement Dropdown; 
	
	public void clickDropdown() {
		this.Dropdown.click(); 
	}
	
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement Logout; 
	
	public void clickLogout() {
		this.Logout.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign up!')]")
	private WebElement SignUp; 
	
	public void clickSignUp() {
		this.SignUp.click(); 
	}
	
	@FindBy(xpath="//input[@id='registration_firstname']")
	private WebElement FirstName; 
	
	public void sendFirstName(String FirstName) {
		this.FirstName.clear(); 
		this.FirstName.sendKeys(FirstName); 
	}
	
	@FindBy(xpath="//input[@id='registration_lastname']")
	private WebElement LastName; 
	
	public void sendLastName(String LastName) {
		this.LastName.clear(); 
		this.LastName.sendKeys(LastName); 
	}
	
	@FindBy(xpath="//input[@id='registration_email']")
	private WebElement Email; 
	
	public void sendEmail(String Email) {
		this.Email.clear(); 
		this.Email.sendKeys(Email); 
	}
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement UserNameTextbox; 
	
	public void sendUserNameTextbox(String UserNameTextbox) {
		this.UserNameTextbox.clear(); 
		this.UserNameTextbox.sendKeys(UserNameTextbox); 
	}
	
	@FindBy(xpath="//input[@id='pass1']")
	private WebElement PasswordTextbox; 
	
	public void sendPasswordTextbox(String PasswordTextbox) {
		this.PasswordTextbox.clear(); 
		this.PasswordTextbox.sendKeys(PasswordTextbox); 
	}
	
	@FindBy(xpath="//input[@id='pass2']")
	private WebElement ConfirmPasswordTextbox; 
	
	public void sendConfirmPasswordTextbox(String ConfirmPasswordTextbox) {
		this.ConfirmPasswordTextbox.clear(); 
		this.ConfirmPasswordTextbox.sendKeys(ConfirmPasswordTextbox); 
	}
	
	@FindBy(xpath="//input[@id='registration_phone']")
	private WebElement PhoneNumber; 
	
	public void sendPhoneNumber(String PhoneNumber) {
		this.PhoneNumber.clear(); 
		this.PhoneNumber.sendKeys(PhoneNumber); 
	}
	
	@FindBy(id="registration_language")
	private WebElement LanguageSelect;
	
	public void selectLanguageSelect(String LanguageSelect)
    {
     Select selectDropdown= new Select(this.LanguageSelect);
     selectDropdown.selectByVisibleText(LanguageSelect);
    }
	
	@FindBy(xpath="//label[contains(text(),'Student (follows courses)')]")
	private WebElement Profile; 
	
	public void selectProfile() {
		this.Profile.isSelected();
	}
	
	@FindBy(xpath="//button[@id='registration_submit']")
	private WebElement Register; 
	
	public void clickRegister() {
		this.Register.click();
	}

	
}
